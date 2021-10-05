package group_3.airport_admin_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String IATAcode, model, wake;

    public Airport(){ }

}
