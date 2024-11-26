import java.util.HashMap;

public class Task {
    private String name;
    private String status;
    public Task(String name) {
        this.name = name;
        this.status = "нет";
    }
    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
