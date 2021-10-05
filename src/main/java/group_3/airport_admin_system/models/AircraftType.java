package group_3.airport_admin_system.models;

import javax.persistence.*;

@Entity
@Table(name = "aircraft_types")
public class AircraftType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int size;

    public AircraftType(){

    }

    public AircraftType(String model,int size) {
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public int getSize() {
        return size;
    }
}
