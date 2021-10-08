package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

    Optional<Flight> findByRouteNumber(String routeNumber);
}
