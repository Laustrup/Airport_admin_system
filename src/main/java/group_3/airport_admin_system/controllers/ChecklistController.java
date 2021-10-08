package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Checklist;
import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.repositories.ChecklistRepository;
import group_3.airport_admin_system.repositories.FlightRepository;
import group_3.airport_admin_system.services.ChecklistService;
import group_3.airport_admin_system.services.FlightService;
import group_3.airport_admin_system.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/flights")
public class ChecklistController {

    FlightService flightService;
    ChecklistService checklistService;
    LogService logService;
    
    public ChecklistController(FlightService flightService, ChecklistService checklistService, LogService logService) {
        this.flightService = flightService;
        this.checklistService = checklistService;
        this.logService = logService;
    }

    @GetMapping("/{id}/checklist")
    public ResponseEntity<Checklist> getChecklist(@PathVariable("id") Long id) {

        Flight flight = flightService.findById(id);

        if (flight == null)
            return ResponseEntity.notFound().build();

        Checklist checklist = checklistService.findByFlight(flight);
        logService.insertNewLog("UpdateChecklist",id,new Date(),"Ground_Crew");
        return ResponseEntity.ok(checklist);
    }

    @PutMapping("/{id}/checklist")
    public ResponseEntity<String> updateChecklist(@PathVariable Long id,
                                                  @RequestBody Checklist modifiedChecklist) {

        Flight flight = flightService.findFlightById(id);
        Checklist checklist = checklistService.findByFlight(flight);

        if (checklist != null) {
            if (id.equals(checklist.getId())) {
                checklistService.save(modifiedChecklist);
                logService.insertNewLog("UpdateChecklist",id,new Date(),"Ground_Crew");
                return ResponseEntity.noContent().build();
            } else {
                logService.insertNewLog("UpdateChecklist_Failed",id,new Date(),"Ground_Crew");
                return ResponseEntity.badRequest().build();
                }
        } else {
            logService.insertNewLog("UpdateChecklist_Failed",id,new Date(),"Ground_Crew");
            return ResponseEntity.notFound().build();
        }
    }
}
