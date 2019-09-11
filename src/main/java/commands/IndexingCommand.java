package commands;

/**
 * Abstract class that represents commands requiring access to a certain task in the tasklist.
 */
abstract public class IndexingCommand extends Command {

    /**
     * Checks if the task's index given is out of range.
     *
     * @param taskNumber the input index of the intended task.
     * @param listSize the total number of tasks in the tasklist.
     * @return true if the input index falls out of range.
     */
    protected static boolean isTaskNumOutOfRange(int taskNumber, int listSize) {
        return taskNumber > listSize || taskNumber < 1;
    }

}
