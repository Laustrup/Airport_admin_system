package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.FlightPlan;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import java.util.List;

public class Taxi {

    private FlightPlanRepository fpRepo;
    private GateRepository gRepo;

    public Taxi(FlightPlanRepository fpRepo, GateRepository gRepo) {
            this.fpRepo = fpRepo;
            this.gRepo = gRepo;
        }

    // Moves an airplane to the correct (open) gate
    public boolean movePlaneToGate(int gateNumber, String routeNumber) {

        // Get infos from db such as gate and flightPlan from parameters
        List<FlightPlan> flightPlans = fpRepo.findByRouteNumber(routeNumber);
        List<Gate> gates = gRepo.findByGateNumber(gateNumber);

        FlightPlan flightPlan = flightPlans.get(0);
        Gate gate = gates.get(0);

        // Is gate available, otherwise prompt for new (open)  gatenumber
        if (!gate.isOccupied() && gate.getSize() >= flightPlans.size()) {
            flightPlan.setGateInfo("Taxing to gate " + gateNumber);
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
        gate.changeOccupiedStatus();
        gRepo.save(gate);

    }

}
