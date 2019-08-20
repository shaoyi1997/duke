public class Task {
    protected String description;

    public Task(String des) {
        this.description = des;
    }

    @Override
    public String toString() {
        return description;
    }
}