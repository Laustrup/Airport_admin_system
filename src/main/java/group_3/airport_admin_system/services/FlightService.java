package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Checklist;
import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.repositories.ChecklistRepository;
import group_3.airport_admin_system.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> findAll() {
        return (List<Flight>) flightRepository.findAll();
    }

    public Flight findFlightById(Long id){
        return flightRepository.findById(id).orElse(null);
    }

    public Flight findFlightByRoute(String routeNumber){
        return flightRepository.findByRouteNumber(routeNumber).orElse(null);
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }
}
