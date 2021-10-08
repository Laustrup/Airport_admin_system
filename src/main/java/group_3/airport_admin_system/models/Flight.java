package group_3.airport_admin_system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iata_origin", nullable = false)
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "iata_destination", nullable = false)
    private Airport destination;

    @OneToOne
    @JoinColumn(referencedColumnName= "gate_number", name="gate_id")
    private Gate gate;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "route_number", nullable = false)
    private String routeNumber;

    @ManyToOne
    @JoinColumn(name = "iata_aircraft", nullable = false)
    private AircraftType aircraftType;

    protected Flight() { }
    
    public Flight(Airport origin, Airport destination, Date date, String routeNumber, AircraftType aircraftType) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.routeNumber = routeNumber;
        this.aircraftType = aircraftType;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }
}
