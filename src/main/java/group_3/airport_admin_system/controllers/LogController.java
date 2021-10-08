package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Checklist;
import group_3.airport_admin_system.models.Log;
import group_3.airport_admin_system.services.ChecklistService;
import group_3.airport_admin_system.services.FlightService;
import group_3.airport_admin_system.services.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class LogController {

    LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }
    @GetMapping("/view_logs")
    public ResponseEntity<List<Log>> renderLogs(Model model) {

        logService.insertNewLog("Refuelling",Long.valueOf(1),new Date(),"Mechanic");
        List<Log> logs = logService.getAllLogs();

        return ResponseEntity.ok(logs);
    }

}
