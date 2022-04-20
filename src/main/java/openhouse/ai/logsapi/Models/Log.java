package openhouse.ai.logsapi.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "logs")
public class Log {

    @Id
    private String id;

    private String userId;
    private String sessionId;
    private List<Action> actions;

    public Log() {}

    public Log(String userId, String sessionId, List<Action> actions) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.actions = actions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        
        System.out.println(action);

        //Add the action to the list of actions
        this.actions.add(action);

    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", actions=" + actions +
                '}';
    }

}
