package com.chaqui.easyflows.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chaqui.easyflows.demo.dto.MaquetaDto;
import com.chaqui.easyflows.demo.service.MaquetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/maqueta")
public class MaquetaController {

    @Autowired
    private MaquetaService maquetaService;
    
    @PostMapping(value="/")
    @ResponseStatus(HttpStatus.OK)
    public String crearMaqueta(@RequestBody MaquetaDto naqueta) {
        return maquetaService.create(naqueta);
    }
    
}