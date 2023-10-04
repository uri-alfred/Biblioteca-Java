/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.idgs06.biblioUTEQ.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Uriel
 */
@Controller
public class InicioController {
    
    @GetMapping("/inicio")
    public String pageInicio(Model model) {
        model.addAttribute("menuActive", "inicio");
        return "index";
    }
    @GetMapping("/mapaSitio")
    public String mapaSitio(Model model) {
        model.addAttribute("menuActive", "inicio");
        return "mapaSitio";
    }
    @GetMapping("/contactanos")
    public String contactanos(Model model) {
        model.addAttribute("menuActive", "inicio");
        return "contactanos";
    }
    @GetMapping("/ayuda")
    public String ayuda(Model model) {
        model.addAttribute("menuActive", "inicio");
        return "ayuda";
    }
    
}
