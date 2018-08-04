package br.com.mpr.admin.controllers;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.service.AdminService;
import br.com.mpr.admin.vo.FornecedorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {


    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String SUCCESS_MESSAGE = "successMessage";
    @Autowired
    private AdminService adminService;

    @GetMapping("/fornecedor")
    public ModelAndView listFornecedor(){
        ModelAndView mav = new ModelAndView("fornecedor/list");
        try {
            mav.addObject("list",adminService.getAllFornecedor());
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @GetMapping("/fornecedor/{id}")
    public ModelAndView getFornecedor(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("fornecedor/view");
        try {
            FornecedorVo vo = adminService.getFornecedorById(id);
            //so adiciona o objeto se nao for nulo por causa do redirect do save.
            if (vo != null && vo.getId() != null) {
                mav.addObject("vo",vo);
            }
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @PostMapping("/fornecedor/save")
    public String saveFornecedor(@ModelAttribute FornecedorVo fornecedorVo, final RedirectAttributes redirectAttributes){
        try {
            fornecedorVo = adminService.saveFornecedor(fornecedorVo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Fornecedor cadastrado com sucesso");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        redirectAttributes.addFlashAttribute("vo",fornecedorVo);
        String redirect = "redirect:/admin/fornecedor/" + (fornecedorVo.getId() == null ? "0"
                : String.valueOf(fornecedorVo.getId()));
        return redirect;
    }

}
