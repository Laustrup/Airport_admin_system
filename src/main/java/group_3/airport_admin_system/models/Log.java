package group_3.airport_admin_system.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="logs_table")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="incident_name")
    private String incidentName;

    @Column(name= "incidentflight")
    private Long flightId;

    @Column(name= "time")
    private Time incidentTime;

    @Column(name= "date")
    private Date incidentDate;

    @Column(name= "responsible")
    private String incidentResponsible;

    public Log(String incidentName, Long flightId, Time incidentTime, Date incidentDate, String incidentResponsible) {
        this.incidentName = incidentName;
        this.flightId = flightId;
        this.incidentTime = incidentTime;
        this.incidentDate = incidentDate;
        this.incidentResponsible = incidentResponsible;
    }

    public Log() {
    }

    public String getIncidentName() {
        return incidentName;
    }

    public void setIncidentName(String incidentName) {
        this.incidentName = incidentName;
    }

    public Long getIncidentAircraft() {
        return flightId;
    }

    public void setIncidentAircraft(Long incidentAircraft) {
        this.flightId = incidentAircraft;
    }

    public Time getIncidentTime() {
        return incidentTime;
    }

    public void setIncidentTime(Time incidentTime) {
        this.incidentTime = incidentTime;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentResponsible() {
        return incidentResponsible;
    }

    public void setIncidentResponsible(String incidentResponsible) {
        this.incidentResponsible = incidentResponsible;
    }
}