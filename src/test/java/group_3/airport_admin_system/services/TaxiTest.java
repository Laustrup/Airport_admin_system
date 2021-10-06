package group_3.airport_admin_system.services;

import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    @CsvSource(value = "27|1|Taxing to gate 27|false", delimiter = '|')
    public void movePlaneToGateTest(int gateNumber, int flightPlanId, String expectedGateInfo, boolean expectedAvailability) {

        // Arrange
        Taxi taxi = new Taxi(fpRepo,gRepo);
        if (expectedGateInfo.equals("null")) {
            expectedGateInfo = null;
        }

        // Act
        taxi.movePlaneToGate(gateNumber,flightPlanId);

        FlightPlan flightPlan = fpRepo.findById(flightPlanId);
        Gate gate = gRepo.findById(gateNumber);

        // Assert
        assertEquals(expectedGateInfo,flightPlan.getGateInfo());
        assertEquals(expectedAvailability,gate.isAvailable());
    }

}