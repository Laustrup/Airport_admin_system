package group_3.airport_admin_system.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class ATC_Controller {


    @GetMapping("/allGatesInformation")
    public ResponseEntity<List> getGateInformation(){
        //List<Gate> allGates = new ArrayList();
        //atcService.getAllGateInformation().findAll().forEach(gate -> allGates.add(gate));
        //return ResponseEntity.status(HttpStatus.OK).body(new );
        return null;
    }

    @GetMapping("/allAircraftsInformation")
    public ResponseEntity<List> getAircraftInformation(){
        //List<Gate> allGates = new ArrayList();
        //atcService.getAllAircraftsInformation().findAll().forEach(gate -> allGates.add(gate));
        //return ResponseEntity.status(HttpStatus.OK).body(new );
        return null;
    }

    @GetMapping("/allTaxingAircrafts")
    public ResponseEntity<List> getTaxingAircraftsInformation(){
        //List<Gate> allGates = new ArrayList();
        //atcService.getAllAircraftsInformation().findAll().forEach(gate -> allGates.add(gate));
        //return ResponseEntity.status(HttpStatus.OK).body(new );
        return null;
    }

}
