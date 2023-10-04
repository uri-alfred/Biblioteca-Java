/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.repositorys;

import com.idgs06.biblioUTEQ.libros.entitys.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Uriel
 */
public interface ICategoriasRepository extends JpaRepository<Categoria, Integer>{
    
}
