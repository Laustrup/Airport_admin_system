package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Log;
import group_3.airport_admin_system.repositories.LogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@Service
class LogServiceTest {


    @Mock
    LogRepository logRep;

    @InjectMocks
    LogService logService;


    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);


        Log logTest = new Log("Taxi_To_Gate", Long.valueOf(420),  new Date(), "ATC");
        Log logTest2 = new Log("Taxi_To_Gate", Long.valueOf(1),  new Date(), "ATC");
        Log logTest3 = new Log("Refueling", Long.valueOf(1),  new Date(), "Mechanic");
        Log logTest4 = new Log("Board_aircraft", Long.valueOf(1), new Date(), "Flightcrew");

        List<Log> testList = new ArrayList<>();
        testList.add(logTest);
        testList.add(logTest2);
        testList.add(logTest3);
        testList.add(logTest4);
        Mockito.when(logRep.findById(Long.valueOf(420))).thenReturn(java.util.Optional.of(logTest));

        Mockito.when(logRep.findAllByFlightId(Long.valueOf(1))).thenReturn(testList.stream().filter(log -> log.getIncidentAircraft() == 1).collect(Collectors.toList()));

        Mockito.when(logRep.findAll()).thenReturn(testList);
    }

    @Test
    void insertNewLog() {

        LogService logS = new LogService();
        logS.insertNewLog("Text_Log", new Long(1), new Date(), "Test_person");


        assertEquals(1, 1);
    }

    @Test
    void getAllLogs() {
        List<Log> testList = logService.getAllLogs();

        assertEquals(4, testList.size());
    }

    @Test
    void getLogById() {

        String name = logService.getLogById(Long.valueOf(420)).get().getIncidentName();

        assertEquals("Taxi_To_Gate", name);


        Mockito.verify(logRep, times(1)).findById(Long.valueOf(420));
    }

    @Test
    void getAllLogsByincidentFlight() {

        List<Log> listOfLogs = logService.getAllLogsByincidentFlight(Long.valueOf(1));

        assertEquals(3, listOfLogs.size());

        Mockito.verify(logRep, times(1)).findAllByFlightId(Long.valueOf(1));
    }
}