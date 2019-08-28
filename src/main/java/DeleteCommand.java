public class DeleteCommand extends Command {

    private int taskNumber;

    public DeleteCommand(int taskNum) {
        taskNumber = taskNum;
    }

    public boolean isExit() { return false; }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (taskNumber > tasks.getNumOfTask()) {
                throw new DukeException("List only has " + tasks.getNumOfTask() + " items.");
            } else {
                Task curTask = tasks.getTaskByIndex(taskNumber - 1);
                tasks.deleteTaskByIdx(taskNumber - 1);
                ui.showResultOfCommand("     Noted. I've removed this task:\n       " + curTask
                        + "\n     Now you have " + tasks.getNumOfTask() + " tasks in the list.");
                storage.updateFile(tasks);
            }
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        }
    }
}
