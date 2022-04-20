package openhouse.ai.logsapi.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import openhouse.ai.logsapi.Models.Log;
import openhouse.ai.logsapi.Models.Action;

public class LogCustomRepositoryImpl implements LogCustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Log> findLogsByProperties(String[] users, String[] types, String start, String end) {
        
        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();

        if(users != null) {
            criteria.add(Criteria.where("userId").in(users));
        }
        if(types != null) {
            criteria.add(Criteria.where("actions").elemMatch(Criteria.where("type").in(types)));
        }
        if(start != null) {
            criteria.add(Criteria.where("actions").elemMatch(Criteria.where("time").gte(start)));
        }
        if(end != null) {
            criteria.add(Criteria.where("actions").elemMatch(Criteria.where("time").lte(end)));
        }

        if (!criteria.isEmpty()) {
            
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
            
            List<Log> items = mongoTemplate.find(query, Log.class);

            //Loop through items and post process the nested documents
            for(int i = items.size() - 1; i >= 0; i--) {
                
                //Current item
                Log item = items.get(i);

                //Loop through actions and remove any that don't have the correct types
                for(int j = item.getActions().size() - 1; j >= 0; j--) {
                    
                    Action action = item.getActions().get(j);

                    if(types != null && Arrays.asList(types).contains(action.getType()) == false) {
                        item.getActions().remove(j);
                    }

                    if(start != null && action.getTime().compareTo(start) < 0) {
                        item.getActions().remove(j);
                    }

                    if(end != null && action.getTime().compareTo(end) > 0) {
                        item.getActions().remove(j);
                    }

                }
            }

            return items;

        }else{
            return mongoTemplate.findAll(Log.class);
        }

    }

}
    
