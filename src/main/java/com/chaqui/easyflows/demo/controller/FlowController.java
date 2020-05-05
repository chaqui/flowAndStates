package com.chaqui.easyflows.demo.controller;

import com.chaqui.easyflows.demo.dto.FlujoIncialResponse;
import com.chaqui.easyflows.demo.service.FlowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/flowController")
public class FlowController {
    
    @Autowired
    private FlowService flowService;



    @GetMapping(value="/inciar/{maquetaId}")
    @ResponseStatus(HttpStatus.OK)
    public FlujoIncialResponse iniciarFlujo(@PathVariable Integer maquetaId) {
        FlujoIncialResponse flujoIncialResponse = new FlujoIncialResponse();
        Integer id = flowService.iniciarFlujo(maquetaId);
        flujoIncialResponse.setId(id);
        return flujoIncialResponse;
    }

    
    

}