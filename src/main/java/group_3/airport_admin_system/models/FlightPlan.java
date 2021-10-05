package group_3.airport_admin_system.models;

import javax.persistence.*;

@Entity
@Table(name = "flightPlanes")
public class FlightPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String routeNumber,gateInfo;

    public FlightPlan(){

    }

    public FlightPlan(String routeNumber,String gateInfo) {
        this.routeNumber = routeNumber;
        this.gateInfo = gateInfo;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public String getGateInfo() {
        return gateInfo;
    }

    public void setGateInfo(String gateInfo) {
        this.gateInfo = gateInfo;
    }
}
