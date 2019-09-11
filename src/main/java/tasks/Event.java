package tasks;

/**
 * Class for the event task.
 * Contains a description of the task and the datetime on which the event starts.
 */
public class Event extends Task {

    protected String at;

    /**
     * Constructor for the event task.
     * Initializes the description and datetime.
     *
     * @param description description of the event.
     * @param at date and time on which the event starts.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Getter for the description of the event task.
     *
     * @return the string of the description of the event.
     */
    @Override
    public String getDescription() {
        return description + " | " + at;
    }

    /**
     * Returns the string representation of the event.
     *
     * @return string consisting of the type of task (event), done marker, description and due date and time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}