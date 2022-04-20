package openhouse.ai.logsapi.Services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import openhouse.ai.logsapi.Models.Log;

@Repository
public interface LogRepository extends MongoRepository<Log, String>, LogCustomRepository {}