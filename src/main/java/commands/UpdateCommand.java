package commands;

import exception.DukeException;
import storage.Storage;
import tasks.Task;
import tasks.TaskList;
import tasks.TimeframedTask;
import ui.Ui;

import java.util.Scanner;

/**
 * Class for the command that updates a task based on the input fields.
 */
public class UpdateCommand extends IndexingCommand {

    private String commandInput;

    /**
     * Constructor for the update command.
     *
     * @param taskNum the index of the task to be updated.
     * @param commandInput the string of items to change.
     */
    public UpdateCommand(int taskNum, String commandInput) {
        super.taskNumber = taskNum;
        this.commandInput = commandInput;
    }

    /**
     * Indicates whether this is an exit command.
     *
     * @return false.
     */
    public boolean isExitCommand() {
        return false;
    }

    /**
     * Executes the update command.
     * Given task at the index position will be updated based on the given fields.
     * A completion message will be displayed after successful deletion.
     *
     * @param tasks tasklist that stores all the tasks
     * @param ui ui object that deals with user interaction
     * @param storage storage object that deals with writing into the text file
     * @return string representation of the command response
     * @throws DukeException exception is thrown when the index falls outside the number of tasks
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            if (isTaskNumOutOfRange(taskNumber, tasks.getNumOfTask())) {
                throw new DukeException("List only has " + tasks.getNumOfTask() + " items.");
            } else {
                Task curTask = tasks.getTaskByIndex(taskNumber - 1);
                Scanner commandDetailsParser = new Scanner(commandInput);
                String word = commandDetailsParser.next();
                while (commandDetailsParser.hasNext()) {
                    String nextWord = commandDetailsParser.next();

                    if (word.equals("/description")) {
                        String newDescription = "";
                        try {
                            while (!nextWord.contains("/")) {
                                newDescription += nextWord + " ";
                                if (commandDetailsParser.hasNext()) {
                                    nextWord = commandDetailsParser.next();
                                } else {
                                    break;
                                }
                            }
                        } catch (NullPointerException e) {
                            throw new DukeException("Description field cannot be empty");
                        }
                        curTask.setDescription(newDescription.trim());
                        word = nextWord;
                    } else if (word.equals("/datetime")) {
                        String newDateTime =
                                nextWord + " " + commandDetailsParser.next();
                        TimeframedTask curTimeframedTask = (TimeframedTask)curTask;
                        curTimeframedTask.setDateTime(newDateTime);
                    } else {
                        throw new DukeException("Please specify your field to change.");
                    }
                }
                return ui.showResultOfCommand("     Noted. I've updated this task:\n       "
                                                      + curTask);

            }
        } catch (DukeException e) {
            return ui.showError(e.getMessage());
        }
    }
}
