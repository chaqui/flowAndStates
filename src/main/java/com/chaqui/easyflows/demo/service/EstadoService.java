package com.chaqui.easyflows.demo.service;

import java.util.List;

import com.chaqui.easyflows.demo.models.Condicion;
import com.chaqui.easyflows.demo.models.Estado;
import com.chaqui.easyflows.demo.repositories.CondicionRepository;
import com.chaqui.easyflows.demo.repositories.EstadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    
    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CondicionRepository condicionRepository; 

	public List<Condicion> obtenerCondiciones(Integer idEstado) {
        Estado estado = estadoRepository.getOne(idEstado); 
		return condicionRepository.findByEstado(estado);
	}

	public Estado getIdByName(String nombreEstado) {
        return estadoRepository.findByNombre(nombreEstado);
	}


}