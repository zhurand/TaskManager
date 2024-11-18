public class Task {
    private String priority, name;
    private Boolean status;
    public Task(String priority, String name) {
        this.priority = priority;
        this.name = name;
        this.status = false;
    }
    public String getPriority() {
        return priority;
    }
    public String getName() {
        return name;
    }
    public Boolean getStatus() {
        return status;
    }
    public String setPriority(String priority) {
        return this.priority;
    }
    public String setName(String name) {
        return this.name;
    }
    public Boolean setStatus(String status) {
        return this.status;
    }
    public String toString() {
        String checkbox = null;
        if (!status) {
            checkbox = "X";
        }
        else {
            checkbox = "V";
        }
        return "#" + priority + " " + name + " [" + checkbox + "]";
    }
}
