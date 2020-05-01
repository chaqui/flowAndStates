package com.chaqui.easyflows.demo.workflow;

import org.jeasy.flows.workflow.SequentialFlow;
import org.jeasy.flows.workflow.WorkFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.jeasy.flows.workflow.SequentialFlow.Builder.aNewSequentialFlow;

import org.jeasy.flows.work.WorkReportPredicate;

import static org.jeasy.flows.workflow.ConditionalFlow.Builder.aNewConditionalFlow;
import static org.jeasy.flows.workflow.RepeatFlow.Builder.aNewRepeatFlow;

import org.jeasy.flows.workflow.ConditionalFlow;
import org.jeasy.flows.workflow.RepeatFlow;

@Repository
public class FlujoDeTrabajo  {
    

 

    public WorkFlow getFlujo()
    {
        EstadoDuca revisarExistentes = new EstadoDuca("revisar existenntes"); 
        EstadoDuca clonarExistente = new EstadoDuca("clonar Existente"); 
        EstadoDuca crearMaqueta = new EstadoDuca("crear Maqueta");
        EstadoDuca ajustarMaqueta = new EstadoDuca("ajustar Maqueta");
        EstadoDuca revisarMaqueta = new EstadoDuca("revisar Maqueta");
        EstadoDuca aprobarMaqueta = new EstadoDuca("aprobar Maqueta");

        SequentialFlow revisarMaquetaFlow = aNewSequentialFlow()
            .named("flujo para revisar maqueta")
            .execute(ajustarMaqueta)
            .then(revisarMaqueta)
            .build();
        
        RepeatFlow revisarAjusteFlow = aNewRepeatFlow()
            .named("flujo para ciclo para revisar ajuste de maqueta")
            .repeat(revisarMaquetaFlow)
            .until(WorkReportPredicate.FAILED)
            .build();
        
        SequentialFlow revisaryFinalizar = aNewSequentialFlow()
            .named("flujo para revisar y finalizar flujo")
            .execute(revisarAjusteFlow)
            .then(aprobarMaqueta)
            .build();


        ConditionalFlow revisarCreacionFlow = aNewConditionalFlow()
            .named("flujo para condicion para revisar la creacion de la maqueta")
            .execute(revisarMaqueta)
            .when(WorkReportPredicate.COMPLETED)
            .then(aprobarMaqueta)
            .otherwise(revisaryFinalizar)
            .build();

        
        SequentialFlow  clonarMaquetaFlow = aNewSequentialFlow()
            .named("flujo para clonar maqueta")
            .execute(clonarExistente)
            .then(revisaryFinalizar)
            .build();
        
        SequentialFlow crearMaquetaFlow = aNewSequentialFlow()
            .named("flujo para crear maqueta")
            .execute(crearMaqueta)
            .then(revisarCreacionFlow)
            .build();

        ConditionalFlow maquetaAplica =  aNewConditionalFlow()
                        .named("flujo para revisar estado de la maqueta")
                        .execute(revisarExistentes)
                        .when(WorkReportPredicate.ALWAYS_FALSE)
                        .then(crearMaquetaFlow)
                        .otherwise(clonarMaquetaFlow)
                        .build();

        return maquetaAplica;


    }
}