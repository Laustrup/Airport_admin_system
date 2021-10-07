package group_3.airport_admin_system.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "aircraft_types")
public class AircraftType {

    @Id
    @Column(name="iata_aircraft")
    private String id;

    @Column(name="icao_code")
    private String ICAOCode;

    @Column(name="model_name", nullable = false )
    private String modelName;

    @OneToMany(mappedBy = "aircraftType")
    private List<Flight> flightPlans;

    @Column(name="wake_category", nullable = false )
    private Wakecategory wake;


    public AircraftType(){ }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getICAOCode() {
        return ICAOCode;
    }

    public void setICAOCode(String ICAOCode) {
        this.ICAOCode = ICAOCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Wakecategory getWake() {
        return wake;
    }

    public void setWake(Wakecategory wake) {
        this.wake = wake;
    }
}
