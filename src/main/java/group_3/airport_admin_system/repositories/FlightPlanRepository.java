package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.model.FlightPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightPlanRepository extends CrudRepository<FlightPlan,Long> {

    List<FlightPlan> findByRouteNumber(String routeNumber);

}
