/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idgs06.biblioUTEQ.libros.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Uriel
 */
@Entity
@Data
@Table(name = "libros")
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLib;
    @NotEmpty
    @Size(min = 3, max = 40)
    private String tituloLib;
    @Digits(integer = 4, fraction = 0)
    @Min(value = 1000)
    @Max(value = 2023)
    private int anioLib;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String autorLib;
    @NotEmpty
    @Size(min = 3, max = 50)
    private String editorialLib;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CAT")
    private Categoria categorias;
    
    public Categoria getCategoria() {
        return categorias;
    }

    public void setCategoria(Categoria categoria) {
        this.categorias = categoria;
    }
}
