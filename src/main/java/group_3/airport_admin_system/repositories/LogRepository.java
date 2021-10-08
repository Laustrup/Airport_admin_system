package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.models.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log,Long> {

    public Iterable<Log> findAllByFlightId(Long flightId);
}
