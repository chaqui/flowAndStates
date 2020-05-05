package com.chaqui.easyflows.demo.service;

import com.chaqui.easyflows.demo.dto.UsuarioDto;
import com.chaqui.easyflows.demo.models.Usuario;
import com.chaqui.easyflows.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

	public void createUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(); 
        usuario.setNombre(usuarioDto.getNombre());
        usuarioRepository.save(usuario);
	} 

    
}