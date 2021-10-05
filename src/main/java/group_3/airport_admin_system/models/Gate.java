package group_3.airport_admin_system.models;

import javax.persistence.*;

@Entity
@Table(name = "gates")
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int gateNumber;
    private boolean isOccupied;

    public Gate(){

    }

    public Gate(int gateNumber, boolean isOccupied) {
        this.gateNumber = gateNumber;
        this.isOccupied = isOccupied;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void changeOccupiedStatus() {
        if (isOccupied) {
            isOccupied = false;
        }
        isOccupied = true;
    }
}
