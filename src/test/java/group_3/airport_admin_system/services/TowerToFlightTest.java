package group_3.airport_admin_system.services;

import group_3.airport_admin_system.repositories.FlightPlanRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TowerToFlightTest {

    @ParameterizedTest
    @CsvSource(value = "", delimiter = '|')
    public void movePlaneToGate(int gateNumber, String routeNumber, FlightPlanRepository fpRepo, GateRepository gRepo) {
        // Arrange
        Taxi taxi = new Taxi(fpRepo,gRepo);


        // ACt


        // Assert
    }

}