package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.models.Log;
import group_3.airport_admin_system.repositories.FlightRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import group_3.airport_admin_system.services.LogService;
import group_3.airport_admin_system.services.Taxi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class ATC_Controller {

   private Taxi taxi;
   private LogService logService;

    public ATC_Controller(GateRepository gateRepository, FlightRepository flightRepository, Taxi taxi, LogService logService){
        this.taxi = taxi;
        //this.gateRepository = gateRepository;
       // this.flightRepository = flightRepository;
        this.logService = logService;
    }

    @GetMapping("/gates")
    public ResponseEntity<Model> rendergates(Model model){

        Iterable<Gate> gates = taxi.gateRepository().findAll();
        LinkedList<Gate> availableGates = new LinkedList<>();

        for (Gate gate : gates) {
            if (gate.isAvailable()) {
                availableGates.add(gate);
            }
        }

        model.addAttribute("gates",availableGates);

        return ResponseEntity.ok(model);
    }

    // TODO Is fixed with responseentity in master branch
    @PutMapping("/flightplans/{id}")
    public String taxiing(@PathVariable (name = "id") Long id, @RequestParam (name = "gate_number") Long gateNumber){

        taxi.movePlaneToGate(gateNumber,id);
        Optional<Flight> tmpFlight = taxi.flightRepository().findById(id);
        //logService.insertNewLog("Taxi_To_Gate" , Long.valueOf(tmpFlight.get().getRouteNumber()),new Date(), "ATC");

        return "redirect:/gates";
    }

    @GetMapping("/flightplans")
    public ResponseEntity<List<Flight>> renderFlightplans() {

        Iterable<Flight> flightPlans = taxi.flightRepository().findAll();
        LinkedList<Flight> listOfFlights = new LinkedList<>();
        for (Flight flightplan : flightPlans) {
            listOfFlights.add(flightplan);
        }
        //Small testing of the log system
        logService.insertNewLog("Test1010",new Long(2),Time.valueOf(LocalTime.now()), new Date(),"test");
        logService.getAllLogs().forEach(log -> System.out.println(log.getIncidentDateAndTime()));
        return ResponseEntity.status(HttpStatus.OK).body(listOfFlights);
    }

}