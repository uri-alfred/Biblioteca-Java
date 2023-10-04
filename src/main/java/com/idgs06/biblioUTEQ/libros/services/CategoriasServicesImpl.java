/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.services;

import com.idgs06.biblioUTEQ.libros.entitys.Categoria;
import com.idgs06.biblioUTEQ.libros.repositorys.ICategoriasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Uriel
 */
@Service
public class CategoriasServicesImpl implements ICategoriasServices {

    @Autowired
    private ICategoriasRepository repository;
    
    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }
    
}
