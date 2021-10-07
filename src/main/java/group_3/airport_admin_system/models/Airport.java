package group_3.airport_admin_system.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport{


    @Column(name="city_name")
    private String cityName;

    @Column(name="country")
    private String country;

    @Id
    @Column(name="iata_airport")
    private String id;

    @OneToMany(mappedBy = "origin")
    private List<Flight> flightPlansAsOrigin;

    @OneToMany(mappedBy = "destination")
    private List<Flight> flightPlansAsDestination;

    public Airport(){ }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
