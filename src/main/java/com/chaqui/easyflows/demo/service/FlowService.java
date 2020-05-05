package com.chaqui.easyflows.demo.service;

import com.chaqui.easyflows.demo.Utilidades;
import com.chaqui.easyflows.demo.models.Estado;
import com.chaqui.easyflows.demo.models.EstadoMaqueta;
import com.chaqui.easyflows.demo.models.Maqueta;
import com.chaqui.easyflows.demo.models.Usuario;
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

    @Autowired
    EstadoService estadoService; 

    @Autowired
    MaquetaService maquetaService; 
    
    public String realizarFlujo()
    {
        WorkFlowEngine workFlowEngine = WorkFlowEngineBuilder.aNewWorkFlowEngine().build();
        
        WorkFlow workFlow = flujoDeTrabajo.getFlujo();
        WorkContext workContext = new WorkContext(); 
        WorkReport workReport = workFlowEngine.run(workFlow, workContext);
        return workReport.toString();
    }

	public Integer iniciarFlujo(Integer maquetaId) {
        EstadoMaqueta estadoMaqueta = new EstadoMaqueta(); 
        Estado estado = estadoService.getIdByName("revisarExistentes");
        Maqueta maqueta = maquetaService.getMaqueta(maquetaId);
        Usuario usuarioAsignado = Utilidades.asignarUsuario(estado.getTipoAsignacion());
        estadoMaqueta.setEstado(estado);
        estadoMaqueta.setMaqueta(maqueta);
        estadoMaqueta.setUsuario(usuarioAsignado);
        return estadoMaqueta.getId();
        
	}

}