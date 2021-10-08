package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Log;
import group_3.airport_admin_system.repositories.LogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LogServiceTest {

    @Autowired
    private LogRepository logRep;

    @Test
    void insertNewLog() {

        LogService logS = new LogService();
         logS.insertNewLog("Text_Log",new Long(1), Time.valueOf(LocalTime.now()),new Date(),"Test_person");


         assertEquals(1,1);
    }

    @Test
    void getAllLogs() {
        //Arrange
        ArrayList<Log> test = new ArrayList<>();
        //Act
        //logS.getAllLogs().forEach(test::add);
        //Assert
        assertEquals(5,test.size());
    }

    @Test
    void getAllLogsByincidentFlight() {
    }
}