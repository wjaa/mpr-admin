package br.com.mpr.admin.controllers;

import br.com.mpr.admin.exception.RestException;
import br.com.mpr.admin.service.AdminService;
import br.com.mpr.admin.vo.FornecedorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {


    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String SUCCESS_MESSAGE = "successMessage";
    @Autowired
    private AdminService adminService;

    private Map<String,String> mapEntity = new HashMap<>();

    @PostConstruct
    private void init(){
        mapEntity.put("FornecedorEntity.list","fornecedor/list");
        mapEntity.put("FornecedorEntity.view","fornecedor/view");

    }


    @GetMapping("/{entity}")
    public ModelAndView listEntity(@PathVariable String entity){
        ModelAndView mav = new ModelAndView(mapEntity.get(entity + ".list"));
        try {
            mav.addObject("list",adminService.listAllEntity(entity));
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @GetMapping("/{entity}/{id}")
    public ModelAndView getEntity(@PathVariable String entity, @PathVariable Long id){
        ModelAndView mav = new ModelAndView(mapEntity.get(entity + ".view"));
        try {
            Serializable vo = adminService.getEntityById(entity,id);
            //so adiciona o objeto se nao for nulo por causa do redirect do save.
            if (vo != null && id != null) {
                mav.addObject("vo",vo);
            }
        } catch (RestException e) {
            mav.addObject(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        return mav;
    }

    @PostMapping("/FornecedorEntity/save")
    public String saveEntity(@ModelAttribute FornecedorVo fornecedorVo,
                             final RedirectAttributes redirectAttributes){
        try {
            fornecedorVo = adminService.saveFornecedor(fornecedorVo);
            redirectAttributes.addFlashAttribute(SUCCESS_MESSAGE,"Fornecedor cadastrado com sucesso");
        }catch (RestException e){
            redirectAttributes.addFlashAttribute(ERROR_MESSAGE,e.getErrorMessageVo());
        }
        redirectAttributes.addFlashAttribute("vo",fornecedorVo);
        String redirect = "redirect:/admin/FornecedorEntity/" + (fornecedorVo.getId() == null ? "0"
                : String.valueOf(fornecedorVo.getId()));
        return redirect;
    }





}
