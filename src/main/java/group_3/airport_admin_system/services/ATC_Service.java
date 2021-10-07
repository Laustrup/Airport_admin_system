package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.repositories.FlightRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATC_Service {

    @Autowired
    GateRepository gateRep;
    @Autowired
    FlightRepository flightRep;

    public ATC_Service() {
    }

    public Iterable<Gate> getAllGateInformation(){
        return gateRep.findAll();
    }

    public Iterable<Flight> getAllAircraftsInformation(){
        return flightRep.findAll();
    }


    //public AircraftRepository getAllTaxingAircraftsInformation(){}
}
