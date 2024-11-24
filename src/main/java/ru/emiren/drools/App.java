package ru.emiren.drools;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import ru.emiren.drools.config.KieConfiguration;
import ru.emiren.drools.controller.DroolsController;
import ru.emiren.drools.model.Computer;
import ru.emiren.drools.service.DroolsService;

import java.io.IOException;
import java.time.LocalDate;

public class App {




    public static void main( String[] args ) {
        KieConfiguration config = new KieConfiguration();
        try {
            KieSession kieSession = config.getKieSession();
            DroolsService droolsService = new DroolsService(kieSession);
            DroolsController controller = new DroolsController(droolsService);
            Computer computer1 = new Computer("Type 1", "Gateway", null, null );
            Computer computer2 = new Computer("Type 2", "DNS Server", null, null );
            controller.evaluateComputer(computer1);
            controller.evaluateComputer(computer2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
