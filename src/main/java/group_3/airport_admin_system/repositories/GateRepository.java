package group_3.airport_admin_system.repositories;

import group_3.airport_admin_system.model.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface GateRepository extends CrudRepository<Gate,Long> {

    ArrayList<Gate> findById(long gateNumber);

}
