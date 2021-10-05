package group_3.airport_admin_system.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="flight_plans")
public class FlightPlan {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    @OneToOne
    private Airport origin, destination;

    @Column( nullable = false)
    //private LocalDate date; ?
    private Date date;

    @Column( nullable = false, length = 10)
    private int routeNumber;

    @Column( nullable = false)
    private Time time;

    @JsonIgnore
    @Column( nullable = false, length = 10)
    @ManyToOne
    @JoinColumn( name = "aircraft_type_id")
    private AircraftType aircraftType;

    @JsonIgnore
    @Column( nullable = false, length = 10)
    @ManyToOne
    @JoinColumn( name = "airport_id")
    private Airport airport;


    public FlightPlan(){ }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
