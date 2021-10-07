package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.models.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends CrudRepository<Gate,Long> {

    //public Gate findGateBy(int GateNumber);

}
