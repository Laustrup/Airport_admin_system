package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.services.FlightService;
import group_3.airport_admin_system.services.Taxi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ATC_Controller {


    private Taxi taxi;

    public ATC_Controller(Taxi taxi){
        this.taxi = taxi;
    }

    @GetMapping("/gates")
    public ResponseEntity<List<Gate>> rendergates(Model model){

        Iterable<Gate> gates = taxi.gateRepository().findAll();
        LinkedList<Gate> availableGates = new LinkedList<>();

        for (Gate gate : gates) {
            if (gate.isAvailable()) {
                availableGates.add(gate);
            }
        }

        model.addAttribute("gates",availableGates);

        //return ResponseEntity.ok(model);
        return ResponseEntity.status(HttpStatus.OK).body(availableGates);
    }

    // Postmapping gets gatenumber and routenumber from form and starts taxiservice, change flightplan info
    @PutMapping("/flights/{id}")
    public String taxiing(@PathVariable (name = "id") Long id,
                                            @RequestParam (name = "gate_number") Long gateNumber,
                                             FlightService flightservice){

        taxi.movePlaneToGate(gateNumber,id);

        Flight flight = new Flight();
        flightservice.findFlightById(id);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body();
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> renderFlight() {

        Iterable<Flight> flights = taxi.flightRepository().findAll();
        LinkedList<Flight> listOfFlights = new LinkedList<>();
        for (Flight flight : flights) {
            listOfFlights.add(flight);
        }
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
