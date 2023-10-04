/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.usuarios.services;

import com.idgs06.biblioUTEQ.usuarios.entitys.Usuario;
import com.idgs06.biblioUTEQ.usuarios.repositorys.IUsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Uriel
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService{
    
    @Autowired
    private IUsuarioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(int idUsuario) {
        return repository.findById(idUsuario).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean findByEmailAndPass(String email, String pass) {
        List<Usuario> users = repository.findByEmailAndPass(email, pass);
        if(users.size() >= 1) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByEmail(String email) {
        List<Usuario> users = repository.findByEmail(email);
        if(users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void delete(int idUsuario) {
        repository.deleteById(idUsuario);
    }
    
}
