/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.idgs06.biblioUTEQ.usuarios.services;

import com.idgs06.biblioUTEQ.usuarios.entitys.Usuario;
import java.util.List;

/**
 *
 * @author Uriel
 */
public interface IUsuarioService {
    List<Usuario> findAll();
    Usuario findById(int idUsuario);
    boolean findByEmailAndPass(String email, String pass);
    Usuario findByEmail(String email);
    Usuario save(Usuario usuario);
    void delete(int idUsuario);
}
