import java.util.HashMap;

public class Task {
    private String name;
    private String status;
    private String optionCreation;
    public Task(String name, String optionCreation) {
        this.name = name;
        this.status = "нет";
        this.optionCreation = optionCreation;
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
    public void setOptionCreation(String optionCreation) {
        this.optionCreation = optionCreation;
    }
    public String getOptionCreation() {
        return optionCreation;
    }
}
