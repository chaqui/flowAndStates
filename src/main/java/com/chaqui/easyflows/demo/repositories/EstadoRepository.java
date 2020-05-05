package com.chaqui.easyflows.demo.repositories;

import com.chaqui.easyflows.demo.models.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Integer> {

	Estado findByNombre(String nombreEstado);

    
}