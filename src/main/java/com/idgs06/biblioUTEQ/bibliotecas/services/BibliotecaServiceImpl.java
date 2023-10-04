/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.bibliotecas.services;

import com.idgs06.biblioUTEQ.bibliotecas.entitys.Biblioteca;
import com.idgs06.biblioUTEQ.bibliotecas.repositorys.IBibliotecaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Uriel
 */
@Service
public class BibliotecaServiceImpl implements IBibliotecaService{

    @Autowired
    private IBibliotecaRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Biblioteca> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Biblioteca findById(int idBibl) {
        return repository.findById(idBibl).orElse(null);
    }

    @Override
    @Transactional
    public Biblioteca save(Biblioteca biblioteca) {
        return repository.save(biblioteca);
    }

    @Override
    @Transactional
    public void delete(int idBibl) {
        repository.deleteById(idBibl);
    }
    
}
