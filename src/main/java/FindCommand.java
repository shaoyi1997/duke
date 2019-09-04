import java.util.ArrayList;

/**
 * Class that represents the find command.
 */
public class FindCommand extends Command {

    private String input;

    /**
     * Constructor for the find command.
     *
     * @param ipt the string of search query.
     */
    public FindCommand(String ipt) {
        input = ipt;
    }

    /**
     * Indicates if the command is the exit command.
     *
     * @return false.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the find command.
     * Searches within the tasklist if any of the tasks match the search query.
     * Displays all tasks that matches.
     *
     * @param tasks tasklist that stores all the tasks
     * @param ui ui object that deals with user interaction
     * @param storage storage object that deals with writing into the text file
     * @throws DukeException exception is thrown when no task is found.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            ArrayList<Task> tasklist = tasks.getTaskList();
            StringBuilder stringOfTasksFound = new StringBuilder("     Here are the matching tasks in your list:\n");
            int counter = 0;
            for (Task tk : tasklist) {
                String curTaskDescription = tk.getDescription();
                if (curTaskDescription.contains(input)) {
                    stringOfTasksFound.append("     " + counter + "." + tk.toString() + "\n");
                    counter++;
                }
            }
            if (counter == 0) {
                throw new DukeException("No tasks found");
            }
            stringOfTasksFound.delete(stringOfTasksFound.length() - 1, stringOfTasksFound.length());
            return ui.showResultOfCommand(stringOfTasksFound.toString());
        } catch (DukeException e) {
            return ui.showError(e.getMessage());
        }
    }
}
