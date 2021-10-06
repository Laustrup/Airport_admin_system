package group_3.airport_admin_system.services;

import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.springframework.stereotype.Service;

@Service
public class Taxi {

    private FlightPlanRepository fpRepo;
    private GateRepository gRepo;

    /*

    Needs to check if size of flight fits gatesize.


     */

    public Taxi(FlightPlanRepository fpRepo, GateRepository gRepo) {
        this.fpRepo = fpRepo;
        this.gRepo = gRepo;
    }

    // Moves an airplane to the correct (open) gate
    public boolean movePlaneToGate(Long gateNumber, Long id) {

        // Get infos from db such as gate and flightPlan from parameters
        FlightPlan flightPlan = fpRepo.findById(id).orElse(null);
        Gate gate = gRepo.findById(gateNumber).orElse(null);

        // Is gate available, otherwise prompt for new (open)  gatenumber
        if (gate.isAvailable()) {
            //
            taxi(gate,flightPlan);
            return true;
        }
        return false;
    }

    // Allows the plane to taxi
    private void taxi(Gate gate, FlightPlan flightPlan) {

        // Put aircraftType in airport db.
        fpRepo.save(flightPlan);

        // Change gate availability to occupied
        gate.setAvailable(false);
        gRepo.save(gate);

        // Delete flight_plan
        fpRepo.delete(flightPlan);
    }

}
