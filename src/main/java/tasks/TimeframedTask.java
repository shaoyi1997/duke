package tasks;

/**
 * Class that represents tasks with a dateTime field;
 */
abstract public class TimeframedTask extends Task {

    public TimeframedTask(String des) {
        super(des);
    }

    /**
     * Updates dateTime to the new dateTime given.
     *
     * @param newDateTime updated dateTime.
     */
    abstract public void setDateTime(String newDateTime);
}
