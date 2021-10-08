package group_3.airport_admin_system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aircraft_types")
public class AircraftType {

    @Id
    @Column(name = "iata_aircraft")
    @JsonProperty("iata_code")
    private String id;

    @Column(name = "icao_code")
    @JsonProperty("icao_code")
    private String ICAOCode;

    @Column(name = "model_name", nullable = false )
    @JsonProperty("model_name")
    private String modelName;

    @JsonIgnore
    @OneToMany(mappedBy = "aircraftType")
    private List<Flight> flightPlans;

    @Column(name = "wake_category", nullable = false )
    @JsonProperty("wake_category")
    private WakeCategory wakeCategory;

    public AircraftType() { }

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

    public WakeCategory getWakeCategory() {
        return wakeCategory;
    }

    public void setWakeCategory(WakeCategory wakeCategory) {
        this.wakeCategory = wakeCategory;
    }
}
