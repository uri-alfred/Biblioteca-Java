/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.idgs06.biblioUTEQ.bibliotecas.controllers;

import com.idgs06.biblioUTEQ.bibliotecas.entitys.Biblioteca;
import com.idgs06.biblioUTEQ.bibliotecas.services.IBibliotecaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Uriel
 */
@Controller
public class BibliotecasController {

    @Autowired
    private IBibliotecaService service;

    @GetMapping("/librerias")
    public String pageLibreria(Model model) {
        model.addAttribute("menuActive", "librerias");
        model.addAttribute("tituloOper", "Librerías");
        model.addAttribute("bibliotecas", service.findAll());
        return "bibliotecas/bibliotecas";
    }

    @GetMapping("/agregar-libreria")
    public String agregarLibreria(Model model, Biblioteca biblioteca) {
        model.addAttribute("menuActive", "librerias");
        model.addAttribute("operacion", "alta");
        model.addAttribute("tituloOper", "Agregar librería");
        model.addAttribute("textBtn", "Guardar nueva librería");
        return "bibliotecas/formLibrerias";
    }

    @GetMapping("/editar-libreria/{idBibl}")
    public String editarLibreria(Model model, Biblioteca biblioteca) {
        model.addAttribute("menuActive", "librerias");
        model.addAttribute("operacion", "editar");
        model.addAttribute("tituloOper", "Editar librería");
        model.addAttribute("textBtn", "Guardar cambios");
        model.addAttribute("biblioteca", service.findById(biblioteca.getIdBibl()));
        return "bibliotecas/formLibrerias";
    }

    @PostMapping("/guardar-libreria")
    public String guardarLibreria(Model model, @Valid Biblioteca biblioteca, BindingResult results,
            @RequestParam("operacion") String operacion) {
        if (results.hasErrors()) {
            if ("alta".equals(operacion)) {
                model.addAttribute("tituloOper", "Agregar librería");
                model.addAttribute("textBtn", "Guardar nueva librería");
            } else {
                model.addAttribute("tituloOper", "Editar librería");
                model.addAttribute("textBtn", "Guardar cambios");
            }
            model.addAttribute("menuActive", "librerias");
            model.addAttribute("operacion", operacion);

            return "bibliotecas/formLibrerias";
        }
        service.save(biblioteca);
        return "redirect:librerias";
    }

    @PostMapping("/eliminar-libreria")
    public String eliminarLibreria(Model model, @RequestParam("idBibl") int idBibl) {
        service.delete(idBibl);
        return "redirect:librerias";
    }

}
