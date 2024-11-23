import java.util.HashMap;

public class TaskList{
    private HashMap<String, HashMap> taskList = new HashMap<>();
    private HashMap<String, String> taskInDict = new HashMap<>();;
    private HashMap<String, String> statusInDict = new HashMap<>();
    private HashMap<String, HashMap> status = new HashMap<>();
    private String name;
    public TaskList(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addTask(Task task) {
        taskInDict.put(task.getPriority(), task.getName());
        taskList.put(name, (HashMap) taskInDict.clone());
        statusInDict.put(task.getPriority(), task.getStatus());
        status.put(name, (HashMap) statusInDict.clone());
    }
    public void printTaskList() {
        for (String key : taskList.keySet()) {
            System.out.print(key + "\n");
            int iter = 1;
            for (Object value : taskList.get(key).values()) {
                System.out.println(iter + " " + value + " [" +
                        status.get(key).get(Integer.toString(iter)) + "]");
                iter += 1;
            }
        }
    }
    public Boolean existsTaskList(String nameTaskList) {
        boolean exists = false;
        for (String key : taskList.keySet()) {
            if (key.equals(nameTaskList)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
    public String getTaskDescription(String nameOfList, String idTask) {
        return (String) taskList.get(nameOfList).get(idTask);
    }
    public void editTaskDescription(String nameOfList, String idTask, String newTaskDescription) {
        HashMap task = taskList.get(nameOfList);
        task.put(idTask, newTaskDescription);
    }
    public void editStatusTask(String nameOfList, String idTask, String newStatus) {
        HashMap task = status.get(nameOfList);
        task.put(idTask, newStatus);
    }
}
