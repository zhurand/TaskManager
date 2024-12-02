import java.util.HashMap;
import java.util.HashSet;

public class TaskList{
    private HashMap<String, HashMap> taskList = new HashMap<>();
    private HashMap<Integer, String> taskInDict = new HashMap<>();;
    private HashMap<Integer, String> statusInDict = new HashMap<>();
    private HashMap<String, HashMap> status = new HashMap<>();
    private String name;
    private int taskPriority;
    public TaskList(String name) {
        this.name = name;
        taskList.put(this.name, taskInDict);
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
            statusInDict.clear();
        }
        else {
            taskPriority = taskList.get(name).size() + 1;
        }
        if (task.getOptionCreation().equals("2")) {
            System.out.println("2");
            HashMap tasks = taskList.get(name);
            System.out.println(tasks);
            tasks.put(tasks.size() + 1, task.getName());
            HashMap statusTasks = status.get(name);
            System.out.println(statusTasks);
            statusTasks.put(tasks.size(), task.getStatus());
            System.out.println(statusTasks);
        }
        taskInDict.put(taskPriority, task.getName());
        taskList.put(name, (HashMap) taskInDict.clone());
        statusInDict.put(taskPriority, task.getStatus());
        status.put(name, (HashMap) statusInDict.clone());
    }
    public void printTaskList() {
        System.out.println(taskList);
        System.out.println(status);
        for (String key : taskList.keySet()) {
            System.out.print("\n### " + key + " ###\n");
            int iter = 1;
            if (taskList.get(key).values().isEmpty()) {
                System.out.print("Список пуст\n" + "----------");
                break;
            }
            for (Object value : taskList.get(key).values()) {
                System.out.println(iter + " " + value + " [" +
                        status.get(key).get(iter) + "]");
                iter += 1;
            }
            System.out.print("----------");
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
    public void deleteStatusList(String nameTaskList) {
        status.remove(nameTaskList);
    }
    public void deleteTaskList(String nameTaskList) {
        taskList.remove(nameTaskList);
        deleteStatusList(nameTaskList);
    }
    public void deleteTask(String nameTaskList, int idTask) {
        int idTaskForMapTasks = idTask;
        int idTaskForMapStatus = idTask;

        HashMap mapTasks = taskList.get(nameTaskList);
        HashMap mapTasksCopy = (HashMap) mapTasks.clone();
        for (int iter = idTaskForMapTasks + 1; iter <= mapTasks.size(); iter++) {
            mapTasks.put(idTaskForMapTasks, mapTasksCopy.get(iter));
            idTaskForMapTasks += 1;
        }
        mapTasks.remove(mapTasks.size());
        mapTasksCopy.clear();

        HashMap mapStatus = status.get(nameTaskList);
        HashMap mapStatusCopy = (HashMap) mapStatus.clone();
        for (int iter = idTaskForMapStatus + 1; iter <= mapStatus.size(); iter++) {
            mapStatus.put(idTaskForMapStatus, mapStatusCopy.get(iter));
            idTaskForMapStatus += 1;
        }
        mapStatus.remove(mapStatus.size());
        mapStatusCopy.clear();
    }
}
