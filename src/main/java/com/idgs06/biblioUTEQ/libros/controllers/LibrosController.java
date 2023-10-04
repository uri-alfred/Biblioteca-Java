/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.controllers;

import com.idgs06.biblioUTEQ.libros.entitys.Categoria;
import com.idgs06.biblioUTEQ.libros.entitys.Libro;
import com.idgs06.biblioUTEQ.libros.services.ICategoriasServices;
import com.idgs06.biblioUTEQ.libros.services.ILibrosService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Uriel
 */
@Slf4j
@Controller
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private ICategoriasServices catService;

    @Autowired
    private ILibrosService libService;

    @GetMapping("/categorias")
    public String pageCatalogos(Model model) {
        model.addAttribute("cats", catService.findAll());
        model.addAttribute("libros", new ArrayList<>());
        model.addAttribute("menuActive", "libros");
        return "libros/categorias";
    }

    @GetMapping("/categorias/{idCat}")
    public String paginaBuscarCategorias(Model model, Categoria categoria) {

        model.addAttribute("menuActive", "libros");
        model.addAttribute("cats", catService.findAll());
        model.addAttribute("active", String.valueOf(categoria.getIdCat()));
        model.addAttribute("libros", libService.searchByCategoria(categoria.getIdCat()));
        return "libros/categorias";
    }

    @GetMapping("/")
    public String pageLibros(Model model) {
        model.addAttribute("menuActive", "libros");
        model.addAttribute("tipo", "default");
        model.addAttribute("libros", libService.searchByNombre(""));
        return "libros/libros";
    }
    @GetMapping("/{tipo}")
    public String pageTiposBusqLibros(Model model, @PathVariable String tipo) {
        model.addAttribute("menuActive", "libros");
        model.addAttribute("tipo", tipo);
        return "libros/libros";
    }
    
    @PostMapping("/buscar-libros")
    public String pageBuscarLibros(Model model, @RequestParam("nombre") String nombre) {
        model.addAttribute("menuActive", "libros");
        model.addAttribute("tipo", "default");
        model.addAttribute("nombre", nombre);
        model.addAttribute("libros", libService.searchByNombre(nombre));
        return "libros/libros";
    }

    @GetMapping("/gestor-libros")
    public String pageGestorLibros(Model model) {
        model.addAttribute("menuActive", "libros");
        model.addAttribute("tituloOper", "Gestor de libros");
        model.addAttribute("libros", libService.findAll());
        return "libros/gestorLibros";
    }

    @GetMapping("/agregar-libros")
    public String pageAgregarLibros(Model model, Libro libro) {
        model.addAttribute("menuActive", "libros");
        model.addAttribute("operacion", "alta");
        model.addAttribute("tituloOper", "Agregar libro");
        model.addAttribute("textBtn", "Guardar nuevo libro");
        model.addAttribute("idCategoria", 0);
        model.addAttribute("cats", catService.findAll());
        return "libros/formLibros";
    }

    @GetMapping("/editar-libros/{idLib}")
    public String pageEditarLibros(Model model, Libro libro) {
        model.addAttribute("menuActive", "libros");
        model.addAttribute("operacion", "editar");
        model.addAttribute("tituloOper", "Editar libro");
        model.addAttribute("textBtn", "Guardar cambios");
        model.addAttribute("libro", libService.findById(libro.getIdLib()));
        model.addAttribute("cats", catService.findAll());
        return "libros/formLibros";
    }

    @PostMapping("/guardar-libro")
    public String guardarLibro(Model model, @Valid Libro libro, BindingResult results,
            @RequestParam("idCategoria") int idCategoria, @RequestParam("operacion") String operacion) {
        if (idCategoria == 0) {
            results.rejectValue("categoria", "error.categoria", "Debe seleccionar una categoría");
        }
        if (results.hasErrors()) {
            if ("alta".equals(operacion)) {
                model.addAttribute("tituloOper", "Agregar libro");
                model.addAttribute("textBtn", "Guardar nuevo libro");
            } else {
                model.addAttribute("tituloOper", "Editar libro");
                model.addAttribute("textBtn", "Guardar cambios");
            }
            model.addAttribute("menuActive", "libros");
            model.addAttribute("operacion", operacion);
            model.addAttribute("idCategoria", idCategoria);
            model.addAttribute("cats", catService.findAll());
            Categoria categoria = new Categoria();
            categoria.setIdCat(idCategoria);
            libro.setCategorias(categoria);
//            log.info(libro.toString());
            return "libros/formLibros";
        }
        libService.save(libro, idCategoria);
        return "redirect:gestor-libros";
    }

    @PostMapping("/eliminar-libros")
    public String pageEliminarLibros(Model model, @RequestParam("idLib") int idLib) {
        libService.delete(idLib);
        return "redirect:gestor-libros";
    }

}
