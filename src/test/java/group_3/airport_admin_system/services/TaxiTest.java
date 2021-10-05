package group_3.airport_admin_system.services;

import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxiTest {

    private FlightPlanRepository fpRepo;
    private GateRepository gRepo;

    public TaxiTest(FlightPlanRepository fpRepo, GateRepository gRepo) {
        this.fpRepo = fpRepo;
        this.gRepo = gRepo;
    }

    @ParameterizedTest
    @CsvSource(value = "27|D8 3563|Taxing to gate 27|false", delimiter = '|')
    public void movePlaneToGate(int gateNumber, String routeNumber,
                                String expectedGateInfo,boolean expectedAvailability) {
        // Arrange
        Taxi taxi = new Taxi(fpRepo,gRepo);
        if (expectedGateInfo.equals("null")) {
            expectedGateInfo = null;
        }

        // Act
        taxi.movePlaneToGate(gateNumber,routeNumber);

        List<FlightPlan> flightPlans = fpRepo.findByRouteNumber(routeNumber);
        List<Gate> gates = gRepo.findById(gateNumber);

        // Assert
        assertEquals(expectedGateInfo,flightPlans.get(0).getGateInfo());
        assertEquals(expectedAvailability,gates.get(0).isAvailable());
    }

}