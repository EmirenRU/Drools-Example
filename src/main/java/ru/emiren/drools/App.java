package ru.emiren.drools;


import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import ru.emiren.drools.config.KieConfiguration;
import ru.emiren.drools.controller.DroolsController;
import ru.emiren.drools.model.Computer;
import ru.emiren.drools.service.DroolsService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class App {




//        KieConfiguration config = new KieConfiguration();
//        DroolsService droolsService = new DroolsService();
//        DroolsController controller = new DroolsController(droolsService);
        public static void main(String[] args) {
            try {
                // Initialize KieServices, KieContainer, and KieSession
                KieServices kieServices = KieServices.Factory.get();
                KieContainer kieContainer = kieServices.getKieClasspathContainer();
                System.out.println("iididi");
                KieBase kieBase = kieContainer.getKieBase();
                KieSession kieSession = kieBase.newKieSession();

                // Create sample data
                Computer computer1 = new Computer("Type 1", "Gateway", LocalDate.now());
                Computer computer2 = new Computer("Type 2", "DNS Server", LocalDate.now().plus(3, ChronoUnit.DAYS));

                // Process data
                evaluateComputer(kieSession, computer1);
                evaluateComputer(kieSession, computer2);

                // Dispose the session to free resources
                kieSession.dispose();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        private static void evaluateComputer(KieSession kieSession, Computer computer) {
            try {
                kieSession.insert(computer);
                kieSession.fireAllRules();
                System.out.println("Computer evaluated: " + computer);
            } catch (Exception e) {
                System.out.println("Error while evaluating computer: " + e.getMessage());
            }
        }

}
