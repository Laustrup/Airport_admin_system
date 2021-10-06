package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.model.FlightPlan;
import group_3.airport_admin_system.model.Gate;
import org.springframework.data.repository.CrudRepository;

public interface GateRepository extends CrudRepository<Gate,Long> {

    //public Gate findGateBy(int GateNumber);

}
