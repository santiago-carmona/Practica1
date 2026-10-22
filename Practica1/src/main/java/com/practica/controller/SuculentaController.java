/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practica.controller;

import com.practica.domain.Suculenta;
import com.practica.service.SuculentaService;
import jakarta.validation.Valid;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author santi
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/suculenta")
public class SuculentaController {
    
    private final SuculentaService suculentaService;
    private final MessageSource messageSource;
    
    @GetMapping("/listado")
    public String listado(Model model){
        var suculentas = suculentaService.getSuculentas(false);
        model.addAttribute("suculentas", suculentas);
        model.addAttribute("totalSuculentas", suculentas.size());
        return "suculenta/listado";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Suculenta suculenta, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        String titulo = "todoOk";
        String mensaje = "mensaje.actualizado";
        if(bindingResult.hasErrors()){
            titulo = "error";
            mensaje = "suculenta.error04";
        }else{
            try{
                suculentaService.save(suculenta);
            }catch(DataIntegrityViolationException e){
                titulo = "error";
                mensaje = "suculenta.error05";
            }
        }
        redirectAttributes.addFlashAttribute(titulo, messageSource.getMessage(mensaje, null, Locale.getDefault()));
        return "redirect:/suculenta/listado";
    }
    
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idSuculenta, RedirectAttributes redirectAttributes){
        String titulo = "todoOk";
        String detalle = "mensaje.eliminado";
        try{
            suculentaService.delete(idSuculenta);
        }catch(IllegalArgumentException e){
            titulo = "error";
            detalle = "suculenta.error01"; // Captura la excepción de argumento inválido para el mensaje de "no existe"
        }catch(IllegalStateException e){
            titulo = "error"; // Captura la excepción de estado ilegal para el mensaje de "datos asociados"
            detalle = "suculenta.error02";
        }catch(Exception e){
            titulo = "error";// Captura cualquier otra excepción inesperada
            detalle = "suculenta.error03";
        }
        redirectAttributes.addFlashAttribute(titulo, messageSource.getMessage(detalle, null, Locale.getDefault()));
        return "redirect:/suculenta/listado";
    }
}
