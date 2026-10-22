/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.service.SuculentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author santi
 */
@Controller
public class IndexController {
    
    private final SuculentaService suculentaService;
    
    public IndexController(SuculentaService suculentaService){
        this.suculentaService = suculentaService;
    }
    
    @GetMapping("/")
    public String cargarPaginaInicio(Model model){
        var suculentas = suculentaService.getSuculentas(true);
        model.addAttribute("suculentas", suculentas);
        return "index";
    }
}
