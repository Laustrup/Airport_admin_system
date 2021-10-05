package group_3.airport_admin_system.model;


import javax.persistence.*;

@Entity
@Table( name="gates")
public class Gate {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    public Gate(){ }

}
