package group_3.airport_admin_system.Controllers;

import group_3.airport_admin_system.services.ATC_Service;
import group_3.airport_admin_system.services.Taxi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class ATC_Controller {

    private ATC_Service atc_service;
    private Taxi taxi_service;

    public ATC_Controller(ATC_Service as, Taxi ts) {
        this.atc_service = as;
        this.taxi_service = ts;
    }

    @GetMapping("/allGatesInformation")
    public ResponseEntity<List> getGateInformation() {
        //List<Gate> allGates = new ArrayList();
        //atcService.getAllGateInformation().findAll().forEach(gate -> allGates.add(gate));
        //return ResponseEntity.status(HttpStatus.OK).body(allGates);
        return null;
    }

    @GetMapping("/allAircraftsInformation")
    public ResponseEntity<List> getAircraftInformation() {
        //List<Gate> allaircraftInformation = new ArrayList();
        //atcService.getAllAircraftsInformation().findAll().forEach(aircraftinformation -> allAircraftInformation.add(aircraftinformation));
        //return ResponseEntity.status(HttpStatus.OK).body(allaircraftInformation);
        return null;
    }

    @GetMapping("/allTaxingAircrafts")
    public ResponseEntity<List> getTaxingAircraftsInformation() {
        //List<Gate> allTaxingAircraftInformation = new ArrayList();
        //atcService.getAllTaxingAircraftsInformation().findAll().forEach(taxingAircraftInformation -> allTaxingAircraftInformation.add(taxingAircraftInformation));
        //return ResponseEntity.status(HttpStatus.OK).body(allTaxingAircraftInformation);
        return null;
    }

}
