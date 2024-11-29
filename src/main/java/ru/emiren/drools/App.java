package ru.emiren.drools;


import ru.emiren.drools.config.KieConfiguration;
import ru.emiren.drools.controller.DroolsController;
import ru.emiren.drools.model.Computer;
import ru.emiren.drools.service.DroolsService;

import java.time.LocalDate;

public class App {
    private static KieConfiguration config = new KieConfiguration();
    private static DroolsService droolsService = new DroolsService(config.getKieSession());
    private static DroolsController controller = new DroolsController(droolsService);
    public static void main(String[] args) {
        try {
            // Create sample data
            Computer computer1 = new Computer("Type 1", "Gateway", LocalDate.now());
            controller.evaluateComputer(computer1);
            Computer computer2 = new Computer("Type 2", "DNS Server", LocalDate.now().plusDays(3));
            controller.evaluateComputer(computer2);
            Computer computer3 = new Computer("Type 2", "DDNS Server", LocalDate.now().plusDays(3));
            controller.evaluateComputer(computer3);
            Computer computer4 = new Computer("Type 2", "Gateway", LocalDate.now().plusDays(3));
            controller.evaluateComputer(computer4);
            Computer computer5 = new Computer("Type 2", "Router", LocalDate.now().plusDays(3));
            controller.evaluateComputer(computer5);
            Computer computer6 = new Computer("Type 3", "Router", LocalDate.now().plusDays(3));
            controller.evaluateComputer(computer6);


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            droolsService.destroySession();
        }
    }
}
