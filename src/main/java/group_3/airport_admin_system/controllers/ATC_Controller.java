package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.services.FlightService;
import group_3.airport_admin_system.services.LogService;
import group_3.airport_admin_system.services.Taxi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ATC_Controller {


    private Taxi taxi;
    private FlightService flightService;
    private LogService logService;

    public ATC_Controller(Taxi taxi, FlightService flightService,LogService logService){
        this.taxi = taxi;
        this.flightService = flightService;
        this.logService = logService;
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> renderFlight() {

        Iterable<Flight> flights = taxi.flightRepository().findAll();
        List<Flight> listOfFlights = new LinkedList<>();
        for (Flight flight : flights) {
            listOfFlights.add(flight);
        }
        return ResponseEntity.status(HttpStatus.OK).body(listOfFlights);
    }


    @PutMapping("/flights/{id}")
    public ResponseEntity<Flight> taxiing(@PathVariable (name = "id") Long id){

        Long gateNumber = new Long(0);
        for (Gate openGate : taxi.gateRepository().findAll()){
            if (openGate.isAvailable()){
                gateNumber = openGate.getNumber();
            }
        }

        taxi.movePlaneToGate(gateNumber,id);

        Flight flight = flightService.findFlightById(id);

        logService.insertNewLog("Taxi_aircraft_to_gate",id,new Date(),"ATC");

        System.err.println("Flight " + flight.getRouteNumber() + " is taxiing to gate " + gateNumber);
        System.err.println("The flight comes from " + flight.getOriginAirport() + " on the " + flight.getDate());


        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> taxiDone(@PathVariable(name = "id") Long id){

        Flight flight = flightService.findFlightById(id);

        return ResponseEntity.status(HttpStatus.OK).body(flight);
    }
}
