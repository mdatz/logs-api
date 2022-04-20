package openhouse.ai.logsapi.Controllers;

import openhouse.ai.logsapi.*;
import openhouse.ai.logsapi.Models.Log;
import openhouse.ai.logsapi.Services.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@CrossOrigin("*")
public class ApiController {
    
    @Autowired
    private LogService logService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Log>> findLogsByProperties(@RequestParam(required=false) String[] users, @RequestParam(required=false) String[] types, @RequestParam(required=false) String start, @RequestParam(required=false) String end) {
        return new ResponseEntity<>(logService.findLogsByProperties(users, types, start, end), HttpStatus.OK);
    }

}
