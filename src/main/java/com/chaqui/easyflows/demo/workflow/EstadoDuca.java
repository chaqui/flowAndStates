package com.chaqui.easyflows.demo.workflow;

import java.util.List;

import com.chaqui.easyflows.demo.models.Condicion;
import com.chaqui.easyflows.demo.models.Estado;
import com.chaqui.easyflows.demo.service.EstadoService;

import org.jeasy.flows.work.DefaultWorkReport;
import org.jeasy.flows.work.Work;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;
import org.jeasy.flows.work.WorkStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @see Work
 */
@Component
public class EstadoDuca implements Work {
    private String nombreEstado;
    private Integer idEstado;
    public EstadoDuca() {
    }

    @Autowired
    EstadoService estadoService;





    public EstadoDuca(String nombreEstado) {
        Estado estado = estadoService.getIdByName(nombreEstado);
        this.idEstado = estado.getId();
        this.nombreEstado = nombreEstado;
    }
    
    /** 
     * @return String
     */
    public String getNombreEstado() {
        return this.nombreEstado;
    }


    
    /** 
     * @param workContext
     * @return WorkReport
     */
    @Override
    public WorkReport call(WorkContext workContext) {
        List<Condicion> condiciones = estadoService.obtenerCondiciones(idEstado);
        return new DefaultWorkReport(WorkStatus.COMPLETED, workContext);
    }
}