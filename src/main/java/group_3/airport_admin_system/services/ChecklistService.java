package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Checklist;
import group_3.airport_admin_system.models.Flight;
import group_3.airport_admin_system.repositories.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecklistService {

    private ChecklistRepository checklistRepository;

    @Autowired
    public ChecklistService(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    public Checklist findByFlight(Flight flight){
        return checklistRepository.findByFlight(flight).orElse(null);
    }

    public Checklist findById(Long id){
        return checklistRepository.findById(id).orElse(null);
    }

    public void save(Checklist checklist){
        checklistRepository.save(checklist);
    }
}
