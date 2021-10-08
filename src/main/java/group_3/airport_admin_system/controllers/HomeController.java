package group_3.airport_admin_system.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String flightPlans() {
        return "flightplans";
    }

    @GetMapping("/groundservices")
    public String groundServices() {
        return "groundservices";
    }
}
