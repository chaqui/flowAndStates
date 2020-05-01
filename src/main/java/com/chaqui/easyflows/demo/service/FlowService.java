package com.chaqui.easyflows.demo.service;

import com.chaqui.easyflows.demo.workflow.EstadoDuca;
import com.chaqui.easyflows.demo.workflow.FlujoDeTrabajo;

import org.jeasy.flows.engine.WorkFlowEngine;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;
import org.jeasy.flows.workflow.WorkFlow;
import org.jeasy.flows.engine.WorkFlowEngineBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowService {
    
    @Autowired
    FlujoDeTrabajo flujoDeTrabajo;
    
    public String realizarFlujo()
    {
        WorkFlowEngine workFlowEngine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
        
        WorkFlow workFlow = flujoDeTrabajo.getFlujo();
        WorkContext workContext = new WorkContext(); 
        WorkReport workReport = workFlowEngine.run(workFlow, workContext);
        return workReport.toString();
    }

}