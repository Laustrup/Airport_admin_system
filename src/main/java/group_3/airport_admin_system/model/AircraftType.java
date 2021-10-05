package group_3.airport_admin_system.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "aircraft_types")
public class AircraftType {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String iCAOcode, model;

    @OneToMany
    private List<FlightPlan> iATAAirport;

    @Column( nullable = false, length = 1)
    private Wakecategory wake;


    public AircraftType(){ }


    public Long getId() {
        return id;
    }

    public String getiCAOcode() {
        return iCAOcode;
    }

    public List<FlightPlan> getiATAAirport() {
        return iATAAirport;
    }

    public void setiCAOcode(String iCAOcode) {
        this.iCAOcode = iCAOcode;
    }

    public void setiATAAirport(List<FlightPlan> iATAAirport) {
        this.iATAAirport = iATAAirport;
    }

    public String getICAOcode() {
        return iCAOcode;
    }

    public void setICAOcode(String ICAOcode) {
        this.iCAOcode = ICAOcode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Wakecategory getWake() {
        return wake;
    }

    public void setWake(Wakecategory wake) {
        this.wake = wake;
    }

}
