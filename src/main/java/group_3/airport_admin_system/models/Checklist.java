package group_3.airport_admin_system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "is_boarded")
    private boolean isBoarded;

    @Column(name = "has_refueled")
    private boolean hasRefueled;

    @Column(name = "is_cargo_loaded")
    private boolean isCargoLoaded;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;

    protected Checklist() { }

    public Checklist(boolean isBoarded, boolean hasRefueled, boolean isCargoLoaded, Flight flight) {
        this.isBoarded = isBoarded;
        this.hasRefueled = hasRefueled;
        this.isCargoLoaded = isCargoLoaded;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBoarded() {
        return isBoarded;
    }

    public void setBoarded(boolean isBoarded) {
        this.isBoarded = isBoarded;
    }

    public boolean hasRefueled() {
        return hasRefueled;
    }

    public void setRefueled(boolean hasRefueled) {
        this.hasRefueled = hasRefueled;
    }

    public boolean isCargoLoaded() {
        return isCargoLoaded;
    }

    public void setCargoLoaded(boolean isCargoLoaded) {
        this.isCargoLoaded = isCargoLoaded;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Have passengers boarded: " + checkStatus(isBoarded()) +
                "\nIs cargo loaded: " + checkStatus(isCargoLoaded())  +
                "\nIs the plane refueled: " + checkStatus(hasRefueled());
    }

    private String checkStatus(boolean status) {
        return status ? "yes" : "no";
    }
}
