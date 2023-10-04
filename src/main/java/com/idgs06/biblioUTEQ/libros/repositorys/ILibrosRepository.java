/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.repositorys;

import com.idgs06.biblioUTEQ.libros.entitys.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Uriel
 */
public interface ILibrosRepository extends JpaRepository<Libro, Integer>{
    
    @Query("SELECT l FROM Libro l WHERE l.categorias.idCat = :idCat")
    List<Libro> findByCategoryId(@Param("idCat") int idCat);
//    tambien se puede poniendo atributoClase_atributo
    
    @Query("SELECT l FROM Libro l WHERE l.tituloLib LIKE %:cadena% OR l.autorLib LIKE %:cadena% OR l.editorialLib LIKE %:cadena%")
    List<Libro> findByCadena(@Param("cadena") String nombre);

}
