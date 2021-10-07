package group_3.airport_admin_system.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "checklists")
public class Checklist {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long checklistId;

    @Column( name = "is_boarding")
    private boolean isBoarding;

    @Column( name = "is_refilling")
    private boolean isRefilling;

    @Column( name= "is_luggage_packing")
    private boolean isLuggagePacking;

    @Column( name = "flight_plan")
    @ManyToOne()
    private FlightPlan flightPlan;


    public Checklist() {

    }

    public Long getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Long checklistId) {
        this.checklistId = checklistId;
    }

    public boolean getIsBoarding() {
        return isBoarding;
    }

    public void setIsBoarding(boolean passengers) {
        this.isBoarding = passengers;
    }

    public boolean getIsRefilling() {
        return isRefilling;
    }

    public void setIsRefilling(boolean fuel) {
        this.isRefilling = fuel;
    }

    public boolean getIsLuggagePacking() {
        return isLuggagePacking;
    }

    public void setIsLuggagePacking(boolean luggage) {
        this.isLuggagePacking = luggage;
    }

    @Override
    public String toString() {
        return "Is passengers boarding: "+ getIsBoarding()
                + " Is luggage boarding: " + getIsLuggagePacking()
                + " Is fuel refilled: " + getIsRefilling();
    }
}
