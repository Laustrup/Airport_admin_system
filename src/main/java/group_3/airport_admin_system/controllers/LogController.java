package group_3.airport_admin_system.controllers;

import group_3.airport_admin_system.models.Log;
import group_3.airport_admin_system.services.LogService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.LinkedList;

public class LogController {

    @GetMapping("/view_logs")
    public String renderLogs(Model model) {

        Iterable<Log> unorderedLogs = new LogService().getAllLogs();
        ArrayList<Log> logs = new ArrayList<>();
        LinkedList<Log> logsInOrder = new LinkedList();

        for (Log log : unorderedLogs) {
            logs.add(log);
        }
        for (int i = logsInOrder.size(); i > 0;i--) {
            logsInOrder.add(logs.get(i));
        }

        model.addAttribute("logs",logsInOrder);
        model.addAttribute("situation","log");

        return "index.html";
    }

}
