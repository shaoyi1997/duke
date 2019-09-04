/**
 * Class for a task in Duke.
 * Consists of the description of the task and a marker to indicate if it is done.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for the task.
     * Initializes the description and done marker for the task.
     * Task is initialized as not done by default.
     *
     * @param des the description of the task
     */
    public Task(String des) {
        this.description = des;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Returns whether the task is done or not.
     *
     * @return boolean flag indicating whether the task is done or not
     */
    public boolean getDoneStatus() {
        return isDone;
    }

    /**
     * Getter for the description of the task.
     *
     * @return the string of the description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the string representation of the task.
     *
     * @return string consisting of done marker and description of the task.
     */
    @Override
    public String toString() {
        return "[" + (isDone ? '\u2713' : '\u2718') + "] " + description;
    }
}