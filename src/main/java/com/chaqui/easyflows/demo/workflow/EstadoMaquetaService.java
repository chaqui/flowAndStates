package com.chaqui.easyflows.demo.workflow;

import com.chaqui.easyflows.demo.repositories.EstadoMaquetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoMaquetaService {
    
    @Autowired
    EstadoMaquetaRepository estadoMaquetaRepository;
}