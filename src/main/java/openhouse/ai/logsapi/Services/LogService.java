package openhouse.ai.logsapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import openhouse.ai.logsapi.Models.Log;
import openhouse.ai.logsapi.Models.Action;

@Service
public class LogService {
    
        @Autowired
        private LogRepository logRepository;
    
        public List<Log> findLogsByProperties(String[] users, String[] types, String start, String end) {
            return logRepository.findLogsByProperties(users, types, start, end);
        }

        public Log addLogAction(String userId, String sessionId, Action action) {
            return logRepository.addLogAction(userId, sessionId, action);
        }
}
