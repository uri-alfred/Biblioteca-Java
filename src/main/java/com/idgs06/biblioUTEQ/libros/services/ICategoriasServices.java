/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.services;

import com.idgs06.biblioUTEQ.libros.entitys.Categoria;
import java.util.List;

/**
 *
 * @author Uriel
 */
public interface ICategoriasServices {
    public List<Categoria> findAll();
}
