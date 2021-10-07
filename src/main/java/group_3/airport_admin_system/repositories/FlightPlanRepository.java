package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.models.FlightPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightPlanRepository extends CrudRepository<FlightPlan,Long> {
}
