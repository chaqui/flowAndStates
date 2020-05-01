package com.chaqui.easyflows.demo.controller;

import com.chaqui.easyflows.demo.service.FlowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
public class FlowController {
    
    @Autowired
    private FlowService flowService;


    @GetMapping(value="/inciar")
    @ResponseStatus(HttpStatus.OK)
    public String iniciarFlujo() {

        return flowService.realizarFlujo();
    }
    

}