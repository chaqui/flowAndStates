package com.chaqui.easyflows.demo.repositories;

import com.chaqui.easyflows.demo.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}