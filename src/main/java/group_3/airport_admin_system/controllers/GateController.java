package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.repositories.GateRepository;
import group_3.airport_admin_system.services.Taxi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
@CrossOrigin(origins = "*")
public class GateController {

    Taxi taxi;

    public GateController(Taxi taxi) {
        this.taxi = taxi;
    }

    @GetMapping("/gates")
    public ResponseEntity<List<Gate>> getGates() {

        List<Gate> gates = (List<Gate>) taxi.gateRepository().findAll();

        return ResponseEntity.ok(gates);
    }

    @PutMapping("/gates/{id}")
    public ResponseEntity<Gate> saveGate(@PathVariable Long id,
                                         @RequestBody Gate modifiedGate) {

        taxi.gateRepository().save(modifiedGate);

        return ResponseEntity.noContent().build();
    }
}
