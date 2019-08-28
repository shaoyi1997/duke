import java.util.*;

public class TaskList {

    private ArrayList<Task> addedItems;

    public TaskList() {
        addedItems = new ArrayList<>();
    }

    public TaskList (ArrayList<Task> ls) {
        addedItems = ls;
    }

    public int getNumOfTask() {
        return addedItems.size();
    }

    public Task getTaskByIndex(int idx) {
        return addedItems.get(idx);
    }

    public ArrayList<Task> getTaskList() {
        return addedItems;
    }

    public void deleteTaskByIdx(int idx) {
        addedItems.remove(idx);
    }

    public void addTask(Task tk) {
        addedItems.add(tk);
    }

}
