package com.chaqui.easyflows.demo.repositories;

import com.chaqui.easyflows.demo.models.Maqueta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquetaRepository extends JpaRepository<Maqueta, Integer> {
    
}