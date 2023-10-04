/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.idgs06.biblioUTEQ.usuarios.controllers;

import com.idgs06.biblioUTEQ.usuarios.entitys.Usuario;
import com.idgs06.biblioUTEQ.usuarios.services.IUsuarioService;
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
public class UsuarioController {
    
    @Autowired
    private IUsuarioService service;

    @GetMapping("/usuarios")
    public String pageUsuario(Model model) {
        model.addAttribute("menuActive", "usuarios");
        model.addAttribute("tituloOper", "Usuarios");
        model.addAttribute("usuarios", service.findAll());
        return "usuarios/usuarios";
    }

    @GetMapping("/agregar-usuario")
    public String agregarUsuario(Model model, Usuario usuario) {
        model.addAttribute("menuActive", "usuarios");
        model.addAttribute("operacion", "alta");
        model.addAttribute("tituloOper", "Agregar usuario");
        model.addAttribute("textBtn", "Guardar nuevo usuario");
        return "usuarios/formUsuarios";
    }

    @GetMapping("/editar-usuario/{idUsuario}")
    public String editarUsuario(Model model, Usuario usuario) {
        model.addAttribute("menuActive", "usuarios");
        model.addAttribute("operacion", "editar");
        model.addAttribute("tituloOper", "Editar usuario");
        model.addAttribute("textBtn", "Guardar cambios");
        model.addAttribute("usuario", service.findById(usuario.getIdUsuario()));
        return "usuarios/formUsuarios";
    }

    @PostMapping("/guardar-usuario")
    public String guardarUsuario(Model model, @Valid Usuario usuario, BindingResult results,
            @RequestParam("operacion") String operacion) {
        if (results.hasErrors()) {
            if ("alta".equals(operacion)) {
                model.addAttribute("tituloOper", "Agregar usuario");
                model.addAttribute("textBtn", "Guardar nuevo usuario");
            } else {
                model.addAttribute("tituloOper", "Editar usuario");
                model.addAttribute("textBtn", "Guardar cambios");
            }
            model.addAttribute("menuActive", "usuarios");
            model.addAttribute("operacion", operacion);

            return "usuarios/formUsuarios";
        }
        service.save(usuario);
        return "redirect:usuarios";
    }

    @PostMapping("/eliminar-usuario")
    public String eliminarUsuario(Model model, @RequestParam("idUsuario") int idUsuario) {
        service.delete(idUsuario);
        return "redirect:usuarios";
    }
    
}
