package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.FlightPlan;
import group_3.airport_admin_system.models.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaxiTest {

    @Autowired
    private FlightPlanRepository fpRepo;
    @Autowired
    private GateRepository gRepo;

    /*
    public TaxiTest(FlightPlanRepository fpRepo, GateRepository gRepo) {
        this.fpRepo = fpRepo;
        this.gRepo = gRepo;
    }
     */

    @ParameterizedTest
    @CsvSource(value = "26|1|false", delimiter = '|')
    public void movePlaneToGateTest(Long gateNumber, Long flightPlanId, boolean expectedAvailability) {

        // Arrange
        Taxi taxi = new Taxi(fpRepo,gRepo);


        // Act
        taxi.movePlaneToGate(gateNumber,flightPlanId);

        Optional<FlightPlan> flightPlan = fpRepo.findById(flightPlanId);
        Optional<Gate> gate = gRepo.findById(gateNumber);

        // Assert
        if (flightPlan.isPresent() && gate.isPresent()){
            assertEquals(expectedAvailability,gate.get().isAvailable());
        }
    }
}