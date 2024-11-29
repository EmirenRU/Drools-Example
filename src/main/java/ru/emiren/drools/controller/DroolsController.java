package ru.emiren.drools.controller;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import ru.emiren.drools.model.Computer;

import ru.emiren.drools.service.DroolsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DroolsController {
    private DroolsService droolsService;

    public DroolsController(DroolsService droolsService) {
        this.droolsService = droolsService;
    }

    public void evaluateComputer(Computer computer) {
//        KieServices ks = KieServices.Factory.get();
//        KieContainer kc = ks.getKieClasspathContainer();
//        KieBase kieBase = kc.getKieBase();
//        KieSession kieSession = kieBase.newKieSession();
        computer.setProductionDate(LocalDate.now());
        droolsService.evaluateComputer(computer);
        System.out.println("Computer evaluated: " + computer);
    }




}
