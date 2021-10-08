package group_3.airport_admin_system.models;

import javax.persistence.*;

@Entity
@Table(name = "gates")
public class Gate {

    @Id
    @Column(name = "gate_number")
    private Long number;

    @Column(name="wake_category", nullable = false)
    private WakeCategory wakeCategory;

    @Column( name="is_available", nullable = false)
    private boolean isAvailable;

    public Gate() { }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public WakeCategory getWakeCategory() {
        return wakeCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
