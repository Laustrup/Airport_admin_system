package group_3.airport_admin_system.models;

import javax.persistence.*;

@Entity
@Table(name = "aircraft_types")
public class AircraftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    public AircraftType(){

    }

    public AircraftType(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
