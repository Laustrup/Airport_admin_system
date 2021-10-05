package group_3.airport_admin_system.model;


import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table( name="gates")
public class Gate {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1)
    private Wakecategory wake;

    @Column( nullable = false)
    private boolean isAvailable;

    public Gate(){ }


    public Wakecategory getWake() {
        return wake;
    }

    public void setWake(Wakecategory wake) {
        this.wake = wake;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
