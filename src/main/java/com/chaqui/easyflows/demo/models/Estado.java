package com.chaqui.easyflows.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Estados")
@Data
public  class Estado {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; 

    @Column(name="nombre")
    private String nombre; 

    //variable para ingresar el tipo de asignacion: aleatorio o por minimos
    @Column(name="tipoAsignacion")
    private String tipoAsignacion;
}