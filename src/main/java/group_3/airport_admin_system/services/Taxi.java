package group_3.airport_admin_system.services;

import group_3.airport_admin_system.model.AircraftType;
import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import group_3.airport_admin_system.model.Wakecategory;
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
        if (gate.isAvailable() && isGateWakeBigger(gate,flightPlan.getAircraftType())) {
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
        gate.setAvailable(false);
        gRepo.save(gate);

    }

    private boolean isGateWakeBigger(Gate gate, AircraftType aircraftType) {

        int gateSize = 0;
        int aircraftSize = 0;

        switch (gate.getWake()) {
            case s: gateSize = 1;
            break;
            case m: gateSize = 2;
            break;
            case l: gateSize = 3;
            break;
        }

        switch (aircraftType.getWake()) {
            case s: aircraftSize = 1;
                break;
            case m: aircraftSize = 2;
                break;
            case l: aircraftSize = 3;
                break;
        }

        return gateSize >= aircraftSize;
    }

}
