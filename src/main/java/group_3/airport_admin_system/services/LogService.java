package group_3.airport_admin_system.services;

import group_3.airport_admin_system.models.Log;
import group_3.airport_admin_system.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRep;


    public void insertNewLog(String incidentName,
                             Long incidentFlight,
                             Time incidentTime,
                             Date incidentDate,
                             String incidentResponsible) {
        logRep.save(new Log(incidentName, incidentFlight,incidentTime,incidentDate, incidentResponsible));
    }

    public Iterable<Log> getAllLogs(){
        return logRep.findAll();
    }

    public List<Log> getAllLogsByincidentFlight(Long flight){
        List<Log> allLogsForFlight = new ArrayList<>();
        logRep.findAllByFlightId(flight).forEach(log -> allLogsForFlight.add(log));
        return allLogsForFlight;
    }

    public Optional<Log> getLogById(Long id){
        return logRep.findById(id);
    }
}
