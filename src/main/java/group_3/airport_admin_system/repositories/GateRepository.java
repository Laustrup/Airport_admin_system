package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.models.FlightPlan;
import group_3.airport_admin_system.models.Gate;
import org.springframework.data.repository.CrudRepository;

public interface GateRepository extends CrudRepository<Gate,Long> {

    public Gate findGateBy(int GateNumber);

}
