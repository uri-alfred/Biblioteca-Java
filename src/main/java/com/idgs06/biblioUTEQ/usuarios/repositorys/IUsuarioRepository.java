/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.usuarios.repositorys;

import com.idgs06.biblioUTEQ.usuarios.entitys.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Uriel
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    @Query("SELECT u FROM Usuario u WHERE u.emailUser = :email AND u.passUser = :pass ")
    List<Usuario> findByEmailAndPass(@Param("email") String email, @Param("pass") String pass);
    
    @Query("SELECT u FROM Usuario u WHERE u.emailUser = :email ")
    List<Usuario> findByEmail(@Param("email") String email);
}
