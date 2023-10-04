/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.bibliotecas.repositorys;

import com.idgs06.biblioUTEQ.bibliotecas.entitys.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Uriel
 */
public interface IBibliotecaRepository extends JpaRepository<Biblioteca, Integer>{
    
}
