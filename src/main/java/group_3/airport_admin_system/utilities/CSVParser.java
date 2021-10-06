package group_3.airport_admin_system.utilities;


import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Class to parse content from CSV files
//and match string patterns to capture respective values
//of attributes that are relevant for schema/table columns
//in the repository and database storage

/**
 *
 * NOTE!! This ONLY takes into the account the CURRENT CSV data files we have been given
 * @method readCSVFile can be expanded and accommodated to additional CSV files
 * Should we receive more data files
 *
 */
public class CSVParser {

    //Strings for the individual CSV files: Airport names, Arrivals and departures, ICAO and IATA codes
    private String airportNamesCodesLine,
            arrivalsAndDeparturesLine ,
            iCAOiATACodesLine;

    //'Pattern' attributes that will be used to compile the above strings into
    //regex patterns to recognize recurring expressions
    //and capture them based on the formatted string
    private Pattern airportNamesCodesCheck,
            arrivalsAndDeparturesCheck ,
            iCAOiATACodesCheck;

    //Constructor with initialized attributes
    CSVParser(){

        //The strings for regex patterns
        //are initialized upon instantiation
        airportNamesCodesLine = "\"(?<CITYAIRPORT>[a-zA-ZÆØÅæøå_ /-]*?)\"," +
                "\"(?<COUNTRY>[a-zA-ZÆØÅæøå_ /-]*?)\"," +
                "\"(?<IATA>[a-zA-ZÆØÅæøå_ /-]*?)\"";
        arrivalsAndDeparturesLine ="\"(?<DATO>[0-9]{1}/[0-9]{2}/[0-9]{4}?)\"," +
                "\"(?<ARRDEP>[A-Z]{1}?)\"," +
                "\"(?<ROUTENUMBER>[A-Z 0-9]{8}?)\"," +
                "\"(?<STASTD>[0-9:]{4}?)\"," +
                "\"(?<AC>[0-9A-Z]{3}?)\",\"[A-Z ]{4}\"";
        iCAOiATACodesLine = "\"(?<IATACODE>[0-9A-Z]{3}?)\"," +
                "\"(?<ICAOCODE>([A-Z0-9/na ]{3,4}|[ ])?)\"," +
                "\"(?<AIRCRAFTMODEL>[A-Za-z- 0-9&/()]{5,40}?)\"," +
                "\"(?<WAKECATEGORY>[A-Zn/a]{1,3}?)\"";

        //The instantiated string are then compiled into Regex
        //for pattern checking later
        airportNamesCodesCheck = Pattern.compile(airportNamesCodesLine);
        arrivalsAndDeparturesCheck = Pattern.compile(arrivalsAndDeparturesLine);
        iCAOiATACodesCheck = Pattern.compile(iCAOiATACodesLine);


    }

    //Method that expects a path string to a CSV file as an argument
    //returns an Arraylist over local Entity objects
    //with the respective data extratced from the corresponding CSV files
    public ArrayList<Object> readCSVFile(String filePathString){

        //Local variable that is set up to return an ArrayList with
        //with the corresponding entity data
        ArrayList<Object> CSVDataList = new ArrayList<>();

        //StringBuilder class used to concat a string from
        //the scanner input
        StringBuilder CSVStringBuilder = new StringBuilder();

        try {

            Scanner scanner = new Scanner(new File(Paths.get("src/", "main/" + filePathString).toString()));
            while (scanner.hasNextLine()) {

                //a chevron (">") is added to be replaced by a 'new line' escape character later
                CSVStringBuilder.append(scanner.nextLine() + ">");

            }

            //The finished string object from the StringBuillder
            //The chevron is replaced with "\n" (new line escape character)
            //To form string rows
            String fileContent = CSVStringBuilder.toString().replace(">", "/n");

            //If statement evaulations that determine
            //what entity data we are given
            // and need to create based on the given CSV file
            if (filePathString.toLowerCase().contains("airport")) {

                //instatiate a Matcher for checking airport names
                Matcher patternTester = airportNamesCodesCheck.matcher(fileContent);

                //while a match is found...
                while (patternTester.find()) {

                    //... create an anonymous Airport instance
                    // attribautes values 'caught' by the
                    //capture groups from the compiled regex string
                    CSVDataList.add(new Airport(
                                    patternTester.group("CITYAIRPORT"),
                                    patternTester.group("COUNTRY"),
                                    patternTester.group("IATA")
                            )
                    );

                }

            }
            if (filePathString.toLowerCase().contains("icao")) {

                //instatiate a Matcher for checking ICAO and IATA code names
                Matcher patternTester = iCAOiATACodesCheck.matcher(fileContent);

                //while a match is found... (refere to previous 'if' block)
                while (patternTester.find()) {
                    CSVDataList.add(new IcaoIataCodes(
                                    patternTester.group("IATACODE"),
                                    patternTester.group("ICAOCODE"),
                                    patternTester.group("AIRCRAFTMODEL"),
                                    patternTester.group("WAKECATEGORY")
                            )
                    );
                }


            }
            if (filePathString.toLowerCase().contains("arrivals")) {

                //instatiate a Matcher for checking arrival and depatures
                Matcher patternTester = arrivalsAndDeparturesCheck.matcher(fileContent);

                //while a match is found... (refere to previous 'if' block)
                while (patternTester.find()) {
                    CSVDataList.add(new ArrivalsDepartures(
                                    patternTester.group("DATO"),
                                    patternTester.group("ARRDEP"),
                                    patternTester.group("ROUTENUMBER"),
                                    patternTester.group("STASTD"),
                                    patternTester.group("AC")
                            )
                    );

                }

            }

        }catch(Exception e){

            System.out.println(e.getMessage());

        }

        //Print methods to check if the regex compilation works
        //and data was captured
        CSVDataList.forEach(System.out::println);

        for(Object o : CSVDataList){
            System.out.println(o.toString());
        }

        //Returns an ArrayList with the corresponding entities
        return CSVDataList;
    }

}
