package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.repositories.FlightRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.springframework.stereotype.Service;

@Service
public class Taxi {

    private FlightRepository fpRepo;
    private GateRepository gRepo;

    /*

    Needs to check if size of flight fits gatesize.


     */

    public Taxi(FlightRepository fpRepo, GateRepository gRepo) {
        this.fpRepo = fpRepo;
        this.gRepo = gRepo;
    }

    public FlightRepository flightRepository(){
        return fpRepo;
    }

    public GateRepository gateRepository(){
        return gRepo;
    }

    // Moves an airplane to the correct (open) gate
    public boolean movePlaneToGate(Long gateNumber, Long id) {

        // Get infos from db such as gate and flightPlan from parameters
        Flight flight = fpRepo.findById(id).orElse(null);
        Gate gate = gRepo.findById(gateNumber).orElse(null);

        // Is gate available, otherwise prompt for new (open)  gatenumber
        try {
            assert gate != null;
            if (gate.isAvailable()) {
                taxi(gate, flight);
                return true;
            }
        }
        catch(Exception e) {
            System.out.println("Couldn't move plane to gate. An error occured, due to something being null. Error is: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Allows the plane to taxi
    private void taxi(Gate gate, Flight flight) {

        // Put aircraftType in airport db.
        fpRepo.save(flight);

        // Change gate availability to occupied
        gate.setAvailable(false);
        gRepo.save(gate);
    }

}
