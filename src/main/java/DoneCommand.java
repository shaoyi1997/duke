public class DoneCommand extends Command {

    private int taskNumber;

    public DoneCommand(int taskNum) {
        taskNumber = taskNum;
    }

    public boolean isExit() { return false; }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (taskNumber > tasks.getNumOfTask()) {
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
