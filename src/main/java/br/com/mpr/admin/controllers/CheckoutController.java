package br.com.mpr.admin.controllers;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.service.AdminService;
import br.com.mpr.admin.service.AuthService;
import br.com.mpr.admin.service.CheckoutService;
import br.com.mpr.admin.utils.BeanUtils;
import br.com.mpr.admin.utils.Token;
import br.com.mpr.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/checkout")
public class CheckoutController extends BaseController {


    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String SUCCESS_MESSAGE = "successMessage";
    public static final String AUTH = "auth";
    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private AdminService adminService;


    @Autowired
    private AuthService authService;


    @GetMapping("/escolhaCliente")
    public ModelAndView escolhaCliente(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("checkout/cliente");

        AuthVo auth = (AuthVo) request.getSession().getAttribute("auth");
        mav.addObject("auth",auth);

        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute AuthVo auth, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("checkout/cliente");

        Token token = authService.auth(auth.getUsername(), auth.getPassword());

        if (token == null){
            mav.addObject(ERROR_MESSAGE,"Usuário ou senha inválido");
            return mav;
        }else{

            request.getSession().setAttribute("auth",new AuthVo(auth.getUsername(), token));
            return carrinhoGet(request);
        }

    }

    @GetMapping("/logoff")
    public ModelAndView logoff(HttpServletRequest request){
        request.getSession().removeAttribute(AUTH);
        return escolhaCliente(request);

    }


    @GetMapping("/frete/view")
    public ModelAndView viewFrete(){
        ModelAndView mav = new ModelAndView("frete/frete");
        try{
            List<ProdutoVo> produtos = adminService.listAllProduto();
            mav.addObject("produtos", produtos);
        }catch(RestException ex){
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }

        return mav;
    }

    @GetMapping("/frete/calcular/{idProduto}/{cep}")
    public @ResponseBody ResultFreteVo[] calcularFrete(@PathVariable Long idProduto,
                                      @PathVariable String cep) throws RestException {
        return adminService.calcularFrete(idProduto,cep);

    }


    @GetMapping("/carrinho")
    public ModelAndView carrinhoGet(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("checkout/carrinho");
        try {
            AuthVo authVo = (AuthVo) request.getSession().getAttribute("auth");
            if (authVo == null){
                return escolhaCliente(request);
            }

            List<ProdutoVo> produtos = adminService.listAllProduto();
            mav.addObject("produtos", produtos);
            CarrinhoVo carrinhoVo = checkoutService.getCarrinho(authVo.getToken());
            List<CatalogoGrupoVo> listCatalogo = adminService.listAllCatalogoGrupo();
            mav.addObject("listCatalogo",listCatalogo);
            mav.addObject("imagensExclusivas",checkoutService
                    .listImagensExclusivas(listCatalogo.get(0).getId()));
            mav.addObject("carrinho",carrinhoVo);

        }catch(RestException ex){
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }
        return mav;
    }

    @PostMapping("/carrinho")
    public String carrinhoPost(){
        return "redirect:/admin/checkout/carrinho";
    }

    @PostMapping("/addProduto")
    public String addProduto(@ModelAttribute ItemCarrinhoForm item,
                                  HttpServletRequest request,
                                 final RedirectAttributes redirectAttributes){
        try {
            AuthVo authVo = (AuthVo) request.getSession().getAttribute("auth");
            if (authVo == null){
                return "redirect:/admin/checkout/escolhaCliente";
            }

            item.getAnexos().get(0).setNomeArquivo(item.getAnexos().get(0).getFotoCliente().getOriginalFilename());
            item.getAnexos().get(0).setFoto(item.getAnexos().get(0).getFotoCliente().getBytes());
            checkoutService.addItemCarrinho(authVo.getToken(),item);

        }catch(RestException ex){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,ex.getErrorMessageVo());

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,new ErrorMessageVo(500,e.getMessage()));
        }
        String redirect = "redirect:/admin/checkout/carrinho";
        return redirect;
    }

    @GetMapping("/removeProduto/{idItem}")
    public String removeProduto(@PathVariable Long idItem,
                             HttpServletRequest request,
                             final RedirectAttributes redirectAttributes){
        try {

            AuthVo authVo = (AuthVo) request.getSession().getAttribute("auth");
            if (authVo == null){
                return "redirect:/admin/checkout/escolhaCliente";
            }

            checkoutService.removeItemCarrinho(authVo.getToken(),idItem);
        }catch(RestException ex){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,ex.getErrorMessageVo());
        }
        String redirect = "redirect:/admin/checkout/carrinho";
        return redirect;
    }

    @PostMapping("/finish")
    public ModelAndView finish(@RequestParam Long idCarrinho){
        ModelAndView mav = new ModelAndView("checkout/checkout");
        try {
            CheckoutVo checkoutVo = checkoutService.checkout(idCarrinho);
            mav.addObject("checkout",checkoutVo);
            String token = checkoutService.getCheckoutToken();
            mav.addObject("token", token);

        }catch(RestException ex){
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
            mav.setViewName("checkout/carrinho");
        }
        return mav;
    }

    @PostMapping("/pagamento")
    public ModelAndView pagamento(@ModelAttribute CheckoutForm form){

        ModelAndView mav = new ModelAndView("checkout/pedido");
        try {
            ResultadoPagamentoVo resultadoPagamento = checkoutService.pagamento(form);
            mav.addObject("resultadoPagamento",resultadoPagamento);
        }catch(RestException ex){
            mav = finish(form.getIdCarrinho());
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }
        return mav;
    }

    @GetMapping("/addCupom/{idCarrinho}/{idCheckout}/{cupom}")
    public ModelAndView addCupom(@PathVariable Long idCarrinho,
                                 @PathVariable Long idCheckout,
                                 @PathVariable String cupom){
        ModelAndView mav = new ModelAndView("checkout/checkout");
        try {
            CheckoutVo checkoutVo = checkoutService.addCupom(idCheckout,cupom);
            mav.addObject("checkout",checkoutVo);
            String token = checkoutService.getCheckoutToken();
            mav.addObject("token", token);
        }catch(RestException ex){
            mav = finish(idCarrinho);
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }

        return mav;
    }

    @GetMapping("/alterarEndereco/{idCarrinho}/{idCheckout}/{idEndereco}")
    public ModelAndView alterarEndereco(@PathVariable Long idCarrinho,
                                        @PathVariable Long idCheckout,
                                        @PathVariable Long idEndereco){
        ModelAndView mav = new ModelAndView("checkout/checkout");
        try {
            CheckoutVo checkoutVo = checkoutService.alterarEndereco(idCheckout,idEndereco);
            mav.addObject("checkout",checkoutVo);
            String token = checkoutService.getCheckoutToken();
            mav.addObject("token", token);
        }catch(RestException ex){
            mav = finish(idCarrinho);
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }

        return mav;
    }

    @GetMapping("/alterarFrete/{idCarrinho}/{idCheckout}/{tipoFrete}")
    public ModelAndView alterarFrete(@PathVariable Long idCarrinho,
                                        @PathVariable Long idCheckout,
                                        @PathVariable String tipoFrete){
        ModelAndView mav = new ModelAndView("checkout/checkout");
        try {
            CheckoutVo checkoutVo = checkoutService.alterarFrete(idCheckout,tipoFrete);
            mav.addObject("checkout",checkoutVo);
            String token = checkoutService.getCheckoutToken();
            mav.addObject("token", token);
        }catch(RestException ex){
            mav = finish(idCarrinho);
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }

        return mav;
    }

}
