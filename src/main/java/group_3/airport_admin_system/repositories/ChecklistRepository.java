package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.models.Checklist;
import group_3.airport_admin_system.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChecklistRepository extends CrudRepository<Checklist, Long> {

    Optional<Checklist> findByFlightRouteNumber(String routeNumber);

    Optional<Checklist> findByFlight(Flight flight);
}