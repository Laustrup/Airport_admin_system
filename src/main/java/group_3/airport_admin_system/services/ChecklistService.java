package group_3.airport_admin_system.services;

import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistService {

    private FlightPlanRepository fpRepo;



    public ChecklistService(FlightPlanRepository fpRepo) {
        this.fpRepo = fpRepo;
    }

}
