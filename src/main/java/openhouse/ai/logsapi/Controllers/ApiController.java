package openhouse.ai.logsapi.Controllers;

import openhouse.ai.logsapi.Models.Log;
import openhouse.ai.logsapi.Models.Action;
import openhouse.ai.logsapi.Services.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/logs")
@CrossOrigin("*")
public class ApiController {
    
    @Autowired
    private LogService logService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Log>> findLogsByProperties(@RequestParam(required=false) String[] users, @RequestParam(required=false) String[] types, @RequestParam(required=false) String start, @RequestParam(required=false) String end) {
        
        //Return the filtered list of logs, all logs are returned if no filters are specified
        return new ResponseEntity<>(logService.findLogsByProperties(users, types, start, end), HttpStatus.OK);

    }

    @PostMapping(value="/{userId}/{sessionId}")
    public ResponseEntity<Log> addLogAction(@PathVariable String userId, @PathVariable String sessionId, @RequestBody Action action) {  

        //Return the updated log after adding the action
        return new ResponseEntity<>(logService.addLogAction(userId, sessionId, action), HttpStatus.OK);

    }

    @PostMapping(value="/{userId}/{sessionId}/batch")
    public ResponseEntity<Log> addLogActions(@PathVariable String userId, @PathVariable String sessionId, @RequestBody Map<String, List<Action>> actions) {  

        //Create a cached variable for the final result
        Log result = null;

        //For each action create a new action in the log
        for (Action action : actions.get("actions")) {
            result = logService.addLogAction(userId, sessionId, action);
        }

        //Return the final update
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    
}
