/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.services;

import com.idgs06.biblioUTEQ.libros.entitys.Categoria;
import com.idgs06.biblioUTEQ.libros.entitys.Libro;
import com.idgs06.biblioUTEQ.libros.repositorys.ILibrosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Uriel
 */
@Service
public class LibrosServiceImpl implements ILibrosService{
    
    @Autowired
    private ILibrosRepository repoLibs;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> searchByCategoria(int idCat) {
        return repoLibs.findByCategoryId(idCat);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> searchByNombre(String nombre) {
        return repoLibs.findByCadena(nombre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> findAll() {
        return repoLibs.findAll();
    }

    @Override
    @Transactional
    public Libro save(Libro libro, int idCat) {
        Categoria categoria = new Categoria();
        categoria.setIdCat(idCat);
        libro.setCategorias(categoria);
        return repoLibs.save(libro);
    }

    @Override
    @Transactional
    public void delete(int idLib) {
        repoLibs.deleteById(idLib);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro findById(int id) {
        return repoLibs.findById(id).orElse(null);
    }

    
    
}
