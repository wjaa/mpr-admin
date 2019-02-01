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
            item.setNomeArquivo(item.getFotoCliente().getOriginalFilename());
            item.setFoto(item.getFotoCliente().getBytes());
            checkoutService.addItemCarrinho(item);

        }catch(RestException ex){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,ex.getErrorMessageVo());

        } catch (IOException e) {
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,new ErrorMessageVo(500,e.getMessage()));
        }
        String redirect = "redirect:/admin/checkout/carrinho/" + item.getIdCliente();
        return redirect;
    }

    @GetMapping("/removeProduto/{idItem}")
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

}
