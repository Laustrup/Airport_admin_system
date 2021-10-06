package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.model.FlightPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FlightPlanRepository extends CrudRepository<FlightPlan,Long> {

    List<FlightPlan> findByRouteNumber(String routeNumber);

}
