package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.models.Gate;
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
//TODO:
//Brug ResponseEntity i stedet for String.
// Evt. tilføj en RequestMapping over RestController i stedet for "gatemanaging" flere steder.

   // private GateRepository gateRepository;
   // private FlightRepository flightRepository;
   Taxi taxi;
   LogService logService;
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

    // Postmapping gets gatenumber and routenumber from form and starts taxiservice, change flightplan info
    @PutMapping("/flightplans/{id}")
    public String taxiing(@PathVariable (name = "id") Long id, @RequestParam (name = "gate_number") Long gateNumber){


        taxi.movePlaneToGate(gateNumber,id);
        Optional<Flight> tmpFlight = taxi.flightRepository().findById(id);
        logService.insertNewLog("Taxi_To_Gate" , Long.valueOf(id),Time.valueOf(LocalTime.now()),new Date(2021,10,10), "ATC");

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
        logService.getAllLogs().forEach(log -> System.out.println(log.getIncidentTime()));
        return ResponseEntity.status(HttpStatus.OK).body(listOfFlights);
    }


    // TODO Do we need the rest?

    /*
    // Getmapping for succes or failure of taxi
    // Endpoint(/gatemanaging/succes)
    @GetMapping("/gates/succes_taxi/gate_number")
    public String succesTaxi(@PathVariable ("gate_number") int gateNumber){
        return "succes_taxi.html";
    }

    // Endpoint(/gatemanaging/failure)
    @GetMapping("/gates/failure_taxi/gate_number")
    public String failureTaxi(@PathVariable ("gate_number") int gateNumber){
        return "failure_taxi.html";
    }


    @GetMapping("/")
    public ResponseEntity<List> getGateInformation(){
        //List<Gate> allGates = new ArrayList();
        //atcService.getAllGateInformation().findAll().forEach(gate -> allGates.add(gate));
        //return ResponseEntity.status(HttpStatus.OK).body(new );
        return null;
    }

    /*
    @GetMapping("/gatemanaging/")
    public String renderGateManaging() {

        // Perhaps index.html with taxi fragment thymeleaf
         // Put available gates into model with key gates
        // return "taxi.html";
    }
     */

    /*
    @PostMapping("/gatemanaging/taxi")
    public String renderGateManaging(parameters) {

        // taxi.movePlaneToGate(gateNumber, routeNumber)

        // Needs to make sure from boolean return if action is allowed

        // return "/gatemanaging/succes   or   failure";
    }
     */

    /*
    @GetMapping("/gatemanaging/succes")
    public String gateSucces() {

        // Add succes to model
        // return "taxi.html";
    }
     */

        /*
    @GetMapping("/gatemanaging/failure")
    public String gateFailure() {

        // Add failure to model
        // return "taxi.html";
    }
     */

}