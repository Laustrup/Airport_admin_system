package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.AircraftType;
import group_3.airport_admin_system.models.FlightPlan;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Taxi {

    private FlightPlanRepository fpRepo;
    private GateRepository gRepo;

    public Taxi(){}

    public Taxi(FlightPlanRepository fpRepo, GateRepository gRepo) {
            this.fpRepo = fpRepo;
            this.gRepo = gRepo;
        }

    // Moves an airplane to the correct (open) gate
    public boolean movePlaneToGate(Long gateNumber, Long id) {

        // Get infos from db such as gate and flightPlan from parameters

            Optional<FlightPlan> flightPlan = fpRepo.findById(id);
            Optional<Gate> gate = gRepo.findById(gateNumber);

            // Is gate available, otherwise prompt for new (open)  gatenumber
            if (gate.get().isAvailable() && isGateWakeBigger(gate.get(), flightPlan.get().getAircraftType())) {
                flightPlan.get().setGateInfo("Taxiing to gate " + gateNumber);
                taxi(gate,flightPlan);
                return true;
            }
        return false;
    }

    // Allows the plane to taxi
    private void taxi(Optional<Gate> gate, Optional<FlightPlan> flightPlan) {

        // Put aircraftType in airport db. + // Change gate availability to occupied
        if (flightPlan.isPresent() && gate.isPresent()) {
            fpRepo.save(flightPlan.get());
            gate.get().setAvailable(false);
            gRepo.save(gate.get());
        }
    }

    private boolean isGateWakeBigger(Gate gate, AircraftType aircraftType) {

        int gateSize = 0;
        int aircraftSize = 0;

        switch (gate.getWake()) {
            case LIGHT: gateSize = 1;
                break;
            case MEDIUM: gateSize = 2;
                break;
            case HEAVY: gateSize = 3;
                break;
            case SUPER: gateSize = 4;
                break;
        }

        switch (aircraftType.getWake()) {
            case LIGHT: aircraftSize = 1;
                break;
            case MEDIUM: aircraftSize = 2;
                break;
            case HEAVY: aircraftSize = 3;
                break;
            case SUPER: aircraftSize = 4;
                break;
        }

        return gateSize >= aircraftSize;
    }
}
