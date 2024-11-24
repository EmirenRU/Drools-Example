package ru.emiren.drools.service;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import ru.emiren.drools.model.Computer;

public class DroolsService {

    private KieSession kieSession;

    public DroolsService(KieSession kieSession) {

        KieServices kieServices = KieServices.Factory.get();
    }

    public void evaluateComputer(Computer computer) {
//        KieBase kBase = kieContainer.getKieBase("rulesBase");
//        System.out.println(kieContainer.toString());
//        KieSession kieSession = kBase.newKieSession();
        kieSession.insert(computer);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
