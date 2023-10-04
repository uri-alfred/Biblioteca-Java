/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.usuarios.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Uriel
 */
@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameUser;
    @NotEmpty
    @Size(min = 15, max = 40)
    @Email
    private String emailUser;
    @NotEmpty
    @Size(min = 8, max = 30)
    private String passUser;
    
}
