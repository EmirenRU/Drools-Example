package ru.emiren.drools.service;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import ru.emiren.drools.model.Computer;

public class DroolsService {


    KieSession kieSession;


    public DroolsService() {
        try {
            KieServices kieServices = KieServices.Factory.get();
            KieContainer kieContainer = kieServices.getKieClasspathContainer();
            this.kieSession = kieContainer.newKieSession("point-rulesKS");
        } catch (Exception e) {
            System.out.println("Error initializing KieSession: " + e.getMessage());
        }
    }

    public DroolsService(KieSession kieSession) {

        KieServices kieServices = KieServices.Factory.get();
    }

    public void evaluateComputer(Computer computer) {
        try {
            kieSession.insert(computer);
            kieSession.fireAllRules();
            kieSession.dispose();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {

        }
    }
}
