package openhouse.ai.logsapi.Services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import openhouse.ai.logsapi.Models.Log;

import java.util.List;

public interface LogCustomRepository {

    public List<Log> findLogsByProperties(String[] users, String[] types, String start, String end);

}
