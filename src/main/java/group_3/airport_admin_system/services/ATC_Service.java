package group_3.airport_admin_system.services;

import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATC_Service {

    @Autowired
    GateRepository gateRep;
    @Autowired
    FlightPlanRepository flightPlanRep;

    public ATC_Service() {
    }

    public Iterable<Gate> getAllGateInformation(){
        return gateRep.findAll();
    }

    public Iterable<FlightPlan> getAllAircraftsInformation(){
        return flightPlanRep.findAll();
    }


    //public AircraftRepository getAllTaxingAircraftsInformation(){}
}
