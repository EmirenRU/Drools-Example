package ru.emiren.drools.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.io.IOException;

public class KieConfiguration {
    private final KieServices kieServices = KieServices.Factory.get();
    private final KieContainer kieContainer = kieServices.getKieClasspathContainer();
    private final KieBase kieBase = kieContainer.getKieBase();


    public KieSession getKieSession(){
        return kieContainer.newKieSession();
    }
}
