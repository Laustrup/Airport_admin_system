package group_3.airport_admin_system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "iata_origin", nullable = false)
    @JsonProperty("origin_airport")
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "iata_destination", nullable = false)
    @JsonProperty("destination_airport")
    private Airport destinationAirport;

    @OneToOne
    @JoinColumn(referencedColumnName= "gate_number", name="gate_id")
    @JsonProperty("gate")
    private Gate gate;

    @JsonProperty("flown_at")
    @Column(name = "date", nullable = false)
    private Date date;

    @JsonProperty("route_number")
    @Column(name = "route_number", nullable = false)
    private String routeNumber;

    @ManyToOne
    @JoinColumn(name = "iata_aircraft", nullable = false)
    @JsonProperty("aircraft_type")
    private AircraftType aircraftType;

    public Flight() { }

    public Flight(Airport originAirport, Airport destinationAirport, Date date, String routeNumber, AircraftType aircraftType) {
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
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

    public Airport getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(Airport origin) {
        this.originAirport = origin;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destination) {
        this.destinationAirport = destination;
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
