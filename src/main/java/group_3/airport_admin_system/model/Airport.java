package group_3.airport_admin_system.model;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String IATAcode, model, wake;

    public Airport(){ }

    

}
