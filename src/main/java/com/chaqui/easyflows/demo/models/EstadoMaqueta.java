package com.chaqui.easyflows.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "estadosMaqueta")
@Data
public class EstadoMaqueta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; 

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private Usuario usuario;
   
    @ManyToOne
    private Maqueta maqueta;  
}