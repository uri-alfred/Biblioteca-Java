/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.bibliotecas.services;

import com.idgs06.biblioUTEQ.bibliotecas.entitys.Biblioteca;
import java.util.List;

/**
 *
 * @author Uriel
 */
public interface IBibliotecaService {
    List<Biblioteca> findAll();
    Biblioteca findById(int idBibl);
    Biblioteca save(Biblioteca biblioteca);
    void delete(int idBibl);
    
}
