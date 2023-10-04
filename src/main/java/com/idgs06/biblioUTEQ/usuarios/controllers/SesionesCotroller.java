package com.idgs06.biblioUTEQ.usuarios.controllers;

import com.idgs06.biblioUTEQ.usuarios.entitys.Usuario;
import com.idgs06.biblioUTEQ.usuarios.services.IUsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Uriel
 */
@Slf4j
@Controller
public class SesionesCotroller {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/")
    public String page(Model model, Usuario usuario) {
        model.addAttribute("errorLogin", "");
        return "login";
    }

    @PostMapping("/iniciar-sesion")
    public String iniciarSesion(Model model, @Valid Usuario usuario, BindingResult results) {
        log.info("inicio de sesion");

        if (results.hasErrors() && results.getErrorCount() > 2) {
            model.addAttribute("errorLogin", "");
            return "login";
        }
        if (service.findByEmailAndPass(usuario.getEmailUser(), usuario.getPassUser())) {
            return "redirect:inicio";
        }
        model.addAttribute("errorLogin", "Correo o Contraseña incorrectos.");
        return "login";
    }

    @GetMapping("/registro")
    public String registro(Model model, Usuario usuario) {
        return "registro";
    }

    @PostMapping("/registrar")
    public String registrarUser(Model model, @Valid Usuario usuario, BindingResult results) {
        log.info("Registro");

        if (results.hasErrors()) {
            return "registro";
        }
        service.save(usuario);
        return "redirect:";
    }

    @GetMapping("/recuperar-pass")
    public String recuperarPass(Model model, Usuario usuario) {
        model.addAttribute("errorEmail", "");
        model.addAttribute("nuevoPass", "close");
        return "recuperaPass";
    }

    @PostMapping("/validar-email")
    public String validarEmail(Model model, @Valid Usuario usuario, BindingResult results) {
        Usuario userIn = usuario;
        if (results.hasErrors() && results.getErrorCount() > 4) {
            model.addAttribute("errorEmail", "");
            model.addAttribute("nuevoPass", "close");
            return "recuperaPass";
        }
        Usuario userExist = service.findByEmail(usuario.getEmailUser());
        if (userExist != null) {
            model.addAttribute("nuevoPass", "open");
            model.addAttribute("errorEmail", "");
            model.addAttribute("usuario", userExist);
            return "recuperaPass";
        }
        model.addAttribute("usuario", userIn);
        model.addAttribute("nuevoPass", "close");
        model.addAttribute("errorEmail", "No existe un usuario con ese correo.");
        return "recuperaPass";
    }

    @PostMapping("/cambiar-pass")
    public String cambiarPass(Model model, @Valid Usuario usuario, BindingResult results) {
        log.info(usuario.toString());
        log.info(results.toString());
        if (results.hasErrors()) {
            model.addAttribute("nuevoPass", "open");
            model.addAttribute("errorEmail", "");
            return "recuperaPass";
        }
        service.save(usuario);
        return "redirect:";
    }

}
