package com.chaqui.easyflows.demo.workflow;

import java.util.List;

import com.chaqui.easyflows.demo.enums.Condicion;

import org.jeasy.flows.work.DefaultWorkReport;
import org.jeasy.flows.work.Work;
import org.jeasy.flows.work.WorkContext;
import org.jeasy.flows.work.WorkReport;
import org.jeasy.flows.work.WorkStatus;

/**
 * @see Work
 */
public class EstadoDuca implements Work {
    private String nombreEstado;
    private List<Condicion> condiciones; 

    public EstadoDuca() {
    }

    public EstadoDuca(String nombreEstado, List<Condicion> condicions) {
        this.nombreEstado = nombreEstado;
        this.condiciones =condicions;
    }

    public EstadoDuca(String nombreEstado) {
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
        

        return new DefaultWorkReport(WorkStatus.COMPLETED, workContext);
    }

}