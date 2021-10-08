package group_3.airport_admin_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "gates")
public class Gate {

    @Id
    @JsonProperty("number")
    @Column(name = "gate_number")
    private Long number;

    @JsonProperty("wake_category")
    @Column(name = "wake_category", nullable = false)
    private WakeCategory wakeCategory;

    @JsonProperty("is_available")
    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;

    public Gate() { }

    public Gate(Long number, WakeCategory wakeCategory, boolean isAvailable){
        this.number = number;
        this.wakeCategory = wakeCategory;
        this.isAvailable = isAvailable;
    }

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
