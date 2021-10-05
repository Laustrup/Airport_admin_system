package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.model.Gate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GateRepository extends CrudRepository<Gate,Long> {

    List<Gate> findByGateNumber(int gateNumber);

}
