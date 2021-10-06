package group_3.airport_admin_system.utilities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {

    @Test
    void readCSVFile() {
        //Arrange
        String fileNameAirports ="resources\\Airport_Name-Codes.csv";
        String fileNameArrivals = "resources\\Arrivals_and_Departures_KEA_sep2019.csv";
        String fileNameICAO = "resources\\ICAO_IATA_Codes.csv";

        CSVParser CSVTest = new CSVParser();

        //Act
        //CSVTest.readCSVFile(fileNameAirports);
        //CSVTest.readCSVFile(fileNameArrivals);
        CSVTest.readCSVFile(fileNameICAO);

        //Assert

    }
}