import java.util.HashMap;

public class Task {
    private String name, status, optionCreation, nameTaskList;
    public Task(String nameTaskList, String name, String optionCreation) {
        this.nameTaskList = nameTaskList;
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
    public String getNameTaskList() { return nameTaskList; }
    public void setNameTaskList(String nameTaskList) { this.nameTaskList = nameTaskList; }
}
