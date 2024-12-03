public class Task {
    private String nameTaskList, taskDescription, taskMakeOption, taskStatus;
    public Task(String nameTaskList, String taskDescription, String taskMakeOption) {
        this.nameTaskList = nameTaskList;
        this.taskDescription = taskDescription;
        this.taskMakeOption = taskMakeOption;
        this.taskStatus = "нет";
    }
    public String getNameTaskList() {
        return nameTaskList;
    }
    public void setNameTaskList(String nameTaskList) {
        this.nameTaskList = nameTaskList;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public void setTaskMakeOption(String taskMakeOption) {
        this.taskMakeOption = taskMakeOption;
    }
    public String getTaskMakeOption() {
        return taskMakeOption;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
