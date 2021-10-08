package group_3.airport_admin_system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport{

    @Id
    @JsonProperty("iata_code")
    @Column(name = "iata_airport", nullable = false, updatable = false)
    private String id;

    @JsonProperty("city_name")
    @Column(name = "city_name")
    private String cityName;

    @JsonProperty("country_name")
    @Column(name = "country_name")
    private String countryName;

    @JsonIgnore
    @OneToMany(mappedBy = "originAirport")
    private List<Flight> flightPlansAsOrigin;

    @JsonIgnore
    @OneToMany(mappedBy = "destinationAirport")
    private List<Flight> flightPlansAsDestination;

    public Airport() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String country) {
        this.countryName = country;
    }
}
