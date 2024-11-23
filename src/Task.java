import java.util.HashMap;

public class Task {
    private String priority, name;
    private String status;
    public Task(String priority, String name) {
        this.priority = priority;
        this.name = name;
        this.status = "нет";
    }
    public String getPriority() {
        return priority;
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
