/**
 * Class for the command that marks a given task done given its index.
 */
public class DoneCommand extends Command {

    private int taskNumber;

    /**
     * Constructor for the done command.
     *
     * @param taskNum the index of the task to be marked done.
     */
    public DoneCommand(int taskNum) {
        this.taskNumber = taskNum;
    }

    /**
     * Indicates whether this is an exit command.
     *
     * @return false.
     */
    public boolean isExit() { return false; }

    /**
     * Executes the done command.
     * Given task will be marked done from the tasklist at the index position.
     * A completion message will be displayed after successful deletion.
     *
     * @param tasks tasklist that stores all the tasks
     * @param ui ui object that deals with user interaction
     * @param storage storage object that deals with writing into the text file
     * @throws DukeException exception is thrown when the index falls outside the number of tasks
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (taskNumber > tasks.getNumOfTask() || taskNumber < 1) {
                throw new DukeException("List only has " + tasks.getNumOfTask() + " items.");
            } else {
                Task curTask = tasks.getTaskByIndex(taskNumber - 1);
                curTask.markDone();
                ui.showResultOfCommand("     Nice! I've marked this task as done: \n     " + curTask);
                storage.updateFile(tasks);
            }
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }
}
