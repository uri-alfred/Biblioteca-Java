/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.services;

import com.idgs06.biblioUTEQ.libros.entitys.Libro;
import java.util.List;

/**
 *
 * @author Uriel
 */
public interface ILibrosService {
    public List<Libro> searchByCategoria(int idCat);
    public List<Libro> searchByNombre(String nombre);
    public List<Libro> findAll();
    public Libro findById(int id);
    public Libro save(Libro libro, int idCat);
    public void delete(int idLib); 
}
