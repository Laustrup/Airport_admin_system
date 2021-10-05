package group_3.airport_admin_system.models;

import javax.persistence.*;

@Entity
@Table(name = "flightPlanes")
public class FlightPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String routeNumber;

    public FlightPlan(){

    }

    public FlightPlan(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }
}
