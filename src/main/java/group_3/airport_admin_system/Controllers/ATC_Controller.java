package group_3.airport_admin_system.Controllers;

import group_3.airport_admin_system.model.Checklist;
import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import group_3.airport_admin_system.services.ATC_Service;
import group_3.airport_admin_system.services.ChecklistService;
import group_3.airport_admin_system.services.Taxi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ATC_Controller {

    private ATC_Service atc_service;
    private Taxi taxi_service;
    private ChecklistService checklist_service;

    public ATC_Controller(ATC_Service as, Taxi ts, ChecklistService checklist_service) {
        this.atc_service = as;
        this.taxi_service = ts;
        this.checklist_service = checklist_service;
    }

    @GetMapping("/allGatesInformation")
    public ResponseEntity<List<Gate>> getGateInformation() {
        List<Gate> allGates = new ArrayList();
        atc_service.getAllGateInformation().forEach(gate -> allGates.add(gate));
        return ResponseEntity.status(HttpStatus.OK).body(allGates);
    }

    @GetMapping("/allAircraftsInformation")
    public ResponseEntity<List> getAircraftInformation() {
        List<FlightPlan> allAircraftInformation = new ArrayList();
        atc_service.getAllAircraftsInformation().forEach(aircraftinformation -> allAircraftInformation.add(aircraftinformation));
        return ResponseEntity.status(HttpStatus.OK).body(allAircraftInformation);
    }

    /*
    @GetMapping("/allTaxingAircrafts")
    public ResponseEntity<List> getTaxingAircraftsInformation() {
        List<Gate> allTaxingAircraftInformation = new ArrayList();
        atc_service.getAllTaxingAircraftsInformation().forEach(taxingAircraftInformation -> allTaxingAircraftInformation.add(taxingAircraftInformation));
        return ResponseEntity.status(HttpStatus.OK).body(allTaxingAircraftInformation);
        return null;
    }*/

    /*@GetMapping("/flightplans/{id}/checklist")
    public String groundCheck(@PathVariable("id") Model model) {
        //Checklist checklist = model.getAttribute("checklist",);
    }*/

}
