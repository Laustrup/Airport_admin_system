package group_3.airport_admin_system.model;

import javax.persistence.*;

@Entity
@Table( name = "aircraft_types")
public class AircraftType {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false )
    private String ICAOcode, model;

    @Column( nullable = false )
    private Wakecategory wake;


    public AircraftType(){ }


    public String getICAOcode() {
        return ICAOcode;
    }

    public void setICAOcode(String ICAOcode) {
        this.ICAOcode = ICAOcode;
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