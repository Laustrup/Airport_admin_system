package group_3.airport_admin_system.utilities;

/*!!TEST CLASS!!*/
//Dummy class used to check if capture groups are caught
public class Airport
{

    private String cityAirport, country, iATACode;

    public Airport(String cityAirport, String country, String iATACode) {
        this.cityAirport = cityAirport;
        this.country = country;
        this.iATACode = iATACode;
    }

    @Override
    public String toString(){
        return "" + cityAirport + " " + country + " " + iATACode;
    }
}
