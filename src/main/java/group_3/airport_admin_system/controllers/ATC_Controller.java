package group_3.airport_admin_system.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class ATC_Controller {



   // Getmapping for rendering taxi.html
    // Endpoint(/gatemanaging/)
    @GetMapping("/gates")
    public String renderTaxiHtml(){
        return "taxi";
    }

     // Postmapping gets gatenumber and routenumber from form and starts taxiservice, change flightplan info
    // Endpoint(/gatemanaging/taxi)
    @PostMapping("/gatemanaging/taxi")
    public String gateManagingTaxi(@RequestParam (name = "route_number") String routeNumber,
                                   @RequestParam (name = "gate_number") int gateNumber){

        if (2 < 1) {
            return "redirect:/gatemanaging/succes_taxi/" + gateNumber;
        }
        else{
            return "redirect:/gatemanaging/failure_taxi/" + gateNumber;
        }
    }

    // Getmapping for succes or failure of taxi
    // Endpoint(/gatemanaging/succes)
    @GetMapping("/gatemanaging/succes_taxi/gate_number")
    public String succesTaxi(@PathVariable ("gate_number") int gateNumber){
        return "succes_taxi.html";
    }

    // Endpoint(/gatemanaging/failure)
    @GetMapping("/gatemanaging/failure_taxi/gate_number")
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