package br.com.mpr.admin.controllers;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {


    public static final String ERROR_MESSAGE = "errorMessage";
    @Autowired
    private AdminService adminService;

    @GetMapping("/fornecedor")
    public ModelAndView fornecedor(){
        ModelAndView mav = new ModelAndView("fornecedor/list");
        try {
            mav.addObject("list",adminService.getAllFornecedor());
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @GetMapping("/fornecedor/{id}")
    public ModelAndView fornecedor(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("fornecedor/view");
        try {
            mav.addObject("vo",adminService.getFornecedorById(id));
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

}
