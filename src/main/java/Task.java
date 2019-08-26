public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String des) {
        this.description = des;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public boolean getDoneStatus() {
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[" + (isDone ? '\u2713' : '\u2718') + "] " + description;
    }
}