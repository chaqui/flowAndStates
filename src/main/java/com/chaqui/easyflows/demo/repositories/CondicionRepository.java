package com.chaqui.easyflows.demo.repositories;

import com.chaqui.easyflows.demo.models.Condicion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionRepository extends JpaRepository<Condicion, Integer>{
    
}