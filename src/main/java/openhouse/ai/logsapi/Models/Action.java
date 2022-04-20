package openhouse.ai.logsapi.Models;

public class Action {

    private String time;
    private String type;
    private Object properties;

    public Action() {}

    public Action(String time, String type, Object properties) {
        this.time = time;
        this.type = type;
        this.properties = properties;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Action{" +
                "time=" + time +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                '}';
    }

}