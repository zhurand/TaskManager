import java.util.HashMap;

public class TaskList{
    private HashMap<String, HashMap> taskList = new HashMap<>();
    private HashMap<String, HashMap> status = new HashMap<>();
    private HashMap<Integer, String> taskInDict = new HashMap<>();;
    private HashMap<Integer, String> statusInDict = new HashMap<>();
    private String nameTaskList;
    private int taskID;
    public TaskList(String nameTaskList) {
        this.nameTaskList = nameTaskList;
        taskList.put(this.nameTaskList, taskInDict);
//        status.put(this.nameTaskList, statusInDict);
    }
    public String getNameTaskList() {
        return nameTaskList;
    }
    public void setNameTaskList(String nameTaskList) {
        this.nameTaskList = nameTaskList;
    }
    public void addTask(Task task) {
        if (taskList.isEmpty() || taskList.get(task.getNameTaskList()) == null) {
            taskID = 1;
            taskInDict.clear();
            statusInDict.clear();
        }
        else {
            taskID = taskList.get(task.getNameTaskList()).size() + 1;
        }
        if (task.getTaskMakeOption().equals("2")) {
            taskList.get(task.getNameTaskList()).put(
                    taskList.get(task.getNameTaskList()).size() + 1, task.getTaskDescription());
            status.get(task.getNameTaskList()).put(
                    taskList.get(task.getNameTaskList()).size(), task.getTaskStatus());
        }
        else {
            taskInDict.put(taskID, task.getTaskDescription());
            taskList.put(nameTaskList, (HashMap) taskInDict.clone());
            statusInDict.put(taskID, task.getTaskStatus());
            status.put(nameTaskList, (HashMap) statusInDict.clone());
        }
    }
    public void printTaskList() {
        for (String key : taskList.keySet()) {
            System.out.print("\n### " + key + " ###\n");
            int iter = 1;
            for (Object value : taskList.get(key).values()) {
                System.out.println(iter + " " + value + " [" +
                        status.get(key).get(iter) + "]");
                iter += 1;
            }
            System.out.print("----------\n");
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
    public String getTaskDescription(String nameTaskList, int taskID) {
        return (String) taskList.get(nameTaskList).get(taskID);
    }
    public void editTaskDescription(String nameTaskList, int taskID, String newTaskDescription) {
        HashMap task = taskList.get(nameTaskList);
        task.put(taskID, newTaskDescription);
    }
    public void editStatusTask(String nameTaskList, int taskID, String newStatus) {
        HashMap task = status.get(nameTaskList);
        task.put(taskID, newStatus);
    }
    public void deleteStatusList(String nameTaskList) {
        status.remove(nameTaskList);
    }
    public void deleteTaskList(String nameTaskList) {
        taskList.remove(nameTaskList);
        deleteStatusList(nameTaskList);
    }
    public void deleteTask(String nameTaskList, int taskID) {
        int idTaskForMapTasks = taskID;
        int idTaskForMapStatus = taskID;

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
    public int sizeTaskList(String nameTaskList) {
        return taskList.get(nameTaskList).size();
    }
}
