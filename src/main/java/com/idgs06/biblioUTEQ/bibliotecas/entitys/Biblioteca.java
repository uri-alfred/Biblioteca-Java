/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.bibliotecas.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Uriel
 */
@Entity
@Data
@Table(name = "bibliotecas")
public class Biblioteca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBibl;
    @NotEmpty
    @Size(min = 3, max = 40)
    private String nameBibl;
    @NotEmpty
    @Size(min = 3, max = 150)
    private String addressBibl;
}
