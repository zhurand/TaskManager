import java.util.ArrayList;
public class TaskList{
    private ArrayList<Task> tasks;
    private String name;
    public TaskList(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
    public void printTaskList() {
        System.out.println(name);
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
