package br.com.mpr.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

    @GetMapping("/fornecedor/")
    public String fornecedor(){
        return "fornecedor/list";
    }

    @GetMapping("/fornecedor/{id}")
    public String fornecedor(@PathVariable Long id){
        return "fornecedor/view";
    }

}
