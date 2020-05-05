package com.chaqui.easyflows.demo.controller;

import com.chaqui.easyflows.demo.dto.UsuarioDto;
import com.chaqui.easyflows.demo.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping(value="/")
    @ResponseStatus(HttpStatus.OK)
    public String crearUsuario(@RequestBody UsuarioDto usuarioDto){
        usuarioService.createUsuario(usuarioDto);
        return "correct";
    }
}