package group_3.airport_admin_system.model;

import javax.persistence.*;

@Entity
@Table( name="gates")
public class Gate {

    @Id
    private int gateNumber;

    @Column(nullable = false, length = 1)
    private Wakecategory wake;

    @Column( nullable = false)
    private boolean isAvailable;

    public Gate(){ }

    public int getGateNumber() {
        return gateNumber;
    }

    public Wakecategory getWake() {
        return wake;
    }

    public void setWake(Wakecategory wake) {
        this.wake = wake;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}