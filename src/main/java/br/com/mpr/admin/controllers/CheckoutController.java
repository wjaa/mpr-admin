package br.com.mpr.admin.controllers;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.service.AdminService;
import br.com.mpr.admin.service.CheckoutService;
import br.com.mpr.admin.utils.BeanUtils;
import br.com.mpr.admin.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.PostConstruct;
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
    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private AdminService adminService;




    @GetMapping("/escolhaCliente")
    public ModelAndView escolhaCliente(){
        ModelAndView mav = new ModelAndView("checkout/cliente");
        try {
            List<ClienteVo> clientes = adminService.listAllCliente();
            mav.addObject("clientes", clientes);
        }catch(RestException ex){
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }
        return mav;
    }


    @GetMapping("/carrinho/{idCliente}")
    public ModelAndView carrinhoGet(@PathVariable Long idCliente){
        ModelAndView mav = new ModelAndView("checkout/carrinho");
        try {
            List<ProdutoVo> produtos = adminService.listAllProduto();
            mav.addObject("produtos", produtos);
            CarrinhoVo carrinhoVo = checkoutService.getCarrinhoByIdCliente(idCliente);
            mav.addObject("carrinho",carrinhoVo);
            mav.addObject("idCliente",idCliente);

        }catch(RestException ex){
            mav.addObject(ERROR_MESSAGE,ex.getErrorMessageVo());
        }
        return mav;
    }

    @PostMapping("/carrinho")
    public String carrinhoPost(@RequestParam Long idCliente){
        return "redirect:/admin/checkout/carrinho/" + idCliente;
    }

    @PostMapping("/addProduto")
    public String addProduto(@ModelAttribute ItemCarrinhoForm item,
                                 final RedirectAttributes redirectAttributes){
        try {
            item.getAnexos().get(0).setNomeArquivo(item.getAnexos().get(0).getFotoCliente().getOriginalFilename());
            item.getAnexos().get(0).setFoto(item.getAnexos().get(0).getFotoCliente().getBytes());
            checkoutService.addItemCarrinho(item);

        }catch(RestException ex){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,ex.getErrorMessageVo());

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,new ErrorMessageVo(500,e.getMessage()));
        }
        String redirect = "redirect:/admin/checkout/carrinho/" + item.getIdCliente();
        return redirect;
    }

    @GetMapping("/removeProduto/{idItem}/{idCliente}")
    public String removeProduto(@PathVariable Long idItem, @PathVariable Long idCliente,
                             final RedirectAttributes redirectAttributes){
        try {
            checkoutService.removeItemCarrinho(idItem);
        }catch(RestException ex){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,ex.getErrorMessageVo());
        }
        String redirect = "redirect:/admin/checkout/carrinho/" + idCliente;
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
            PedidoVo pedido = checkoutService.pagamento(form);
            mav.addObject("pedido",pedido);
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
