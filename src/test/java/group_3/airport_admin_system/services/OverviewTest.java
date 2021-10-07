package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.repositories.FlightRepository;
import group_3.airport_admin_system.repositories.GateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OverviewTest {

    @Autowired
    private FlightRepository fpRepo;
    @Autowired
    private GateRepository gRepo;

    @Test
    public void dataOverviewRenderingTest() {
        // Arrange
        int expectedSize = 9448;

        // Act
        Iterable<Flight> flightPlans = fpRepo.findAll();

        int actSize = 0;

        for (Flight flightplan : flightPlans) {
            System.out.println("Current fp is " + flightplan.getRouteNumber() + "\n\nId is " + flightplan.getId() + "\n\n");
            actSize++;
        }

        // Assert
        if (actSize!=0) {
            assertEquals(expectedSize,actSize);
        }

    }

}
