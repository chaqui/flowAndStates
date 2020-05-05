package com.chaqui.easyflows.demo.repositories;

import java.util.List;

import com.chaqui.easyflows.demo.models.Condicion;
import com.chaqui.easyflows.demo.models.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionRepository extends JpaRepository<Condicion, Integer>{

	List<Condicion> findByEstado(Estado estado);
    
}