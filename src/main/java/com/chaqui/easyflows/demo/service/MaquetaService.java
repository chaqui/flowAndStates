package com.chaqui.easyflows.demo.service;

import com.chaqui.easyflows.demo.dto.MaquetaDto;
import com.chaqui.easyflows.demo.models.Maqueta;
import com.chaqui.easyflows.demo.repositories.MaquetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquetaService {

    @Autowired 
    MaquetaRepository maquetaRepository;

	public String create(MaquetaDto maquetaDto) {
        Maqueta maqueta = new Maqueta();
        maqueta.setNombre(maquetaDto.getNombre());
        maquetaRepository.save(maqueta);
        return "correcto";
	}

	public Maqueta getMaqueta(Integer maquetaId) {
		return null;
	}

}