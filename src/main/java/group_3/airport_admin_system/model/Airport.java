package group_3.airport_admin_system.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cityName, country;

    @Column( nullable = false, length = 10)
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "flightplan")
    private List<FlightPlan> iATAairports;

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
