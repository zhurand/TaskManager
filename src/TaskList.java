import java.util.HashMap;

public class TaskList{
    private HashMap<String, HashMap> taskList = new HashMap<>();
    private HashMap<Integer, String> taskInDict = new HashMap<>();;
    private HashMap<Integer, String> statusInDict = new HashMap<>();
    private HashMap<String, HashMap> status = new HashMap<>();
    private String name;
    private int taskPriority;
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
        if (taskList.isEmpty() || taskList.get(name) == null) {
            taskPriority = 1;
            taskInDict.clear();
        }
        else {
            HashMap tasks = taskList.get(name);
            taskPriority = tasks.size() + 1;
        }
        taskInDict.put(taskPriority, task.getName());
        taskList.put(name, (HashMap) taskInDict.clone());
        statusInDict.put(taskPriority, task.getStatus());
        status.put(name, (HashMap) statusInDict.clone());
    }
    public void printTaskList() {
        for (String key : taskList.keySet()) {
            System.out.print(key + "\n");
            int iter = 1;
            for (Object value : taskList.get(key).values()) {
                System.out.println(iter + " " + value + " [" +
                        status.get(key).get(iter) + "]");
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
    public String getTaskDescription(String nameOfList, int idTask) {
        return (String) taskList.get(nameOfList).get(idTask);
    }
    public void editTaskDescription(String nameOfList, int idTask, String newTaskDescription) {
        HashMap task = taskList.get(nameOfList);
        task.put(idTask, newTaskDescription);
    }
    public void editStatusTask(String nameOfList, int idTask, String newStatus) {
        HashMap task = status.get(nameOfList);
        task.put(idTask, newStatus);
    }
}
