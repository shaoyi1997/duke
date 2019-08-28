/**
 * Class for the deadline task.
 * Contains a description of the task and the datetime for which it is due.
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Constructor for Deadline task.
     * Initializes the description and due datetime.
     *
     * @param des description of the deadline.
     * @param by datetime for which the deadline is due.
     */
    public Deadline(String des, String by) {
        super(des);
        this.by = by;
    }

    /**
     * Getter for the description of the deadline task.
     *
     * @return the string of the description of the deadline.
     */
    @Override
    public String getDescription() {
        return description + " | " + by;
    }

    /**
     * Returns the string representation of the deadline task.
     *
     * @return string consisting of the type of task (deadline), done marker, description and due date and time.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}