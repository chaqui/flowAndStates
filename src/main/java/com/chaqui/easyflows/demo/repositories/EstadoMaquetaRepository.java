package com.chaqui.easyflows.demo.repositories;

import com.chaqui.easyflows.demo.models.EstadoMaqueta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoMaquetaRepository extends JpaRepository<EstadoMaqueta,Integer> {
    
}