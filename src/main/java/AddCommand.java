import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class for the command that adds a task into the tasklist.
 */
public class AddCommand extends Command {

    private String input;

    /**
     * Constructor for the AddCommand object.
     *
     * @param ipt the string representation of the command input.
     */
    public AddCommand(String ipt) {
        this.input = ipt;
    }

    /**
     * Indicates whether this is an exit command.
     *
     * @return false.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the add command.
     * The task will be parsed from the input string representation and added into the task list.
     * The text file will be updated with the given task.
     * A completion message will be displayed after successful execution.
     *
     * @param tasks tasklist that stores all the tasks
     * @param ui ui object that deals with user interaction
     * @param storage storage object that deals with writing into the text file
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        try {
            Task tk = Parser.parseAddCommand(input);
            tasks.addTask(tk);
            storage.updateFile(tasks);
            ui.showResultOfCommand("     Got it. I've added this task: \n       "
                                           + tk + "\n     Now you have " + tasks.getNumOfTask()
                                           + " tasks in the list.");
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        } catch (ParseException e) {
            ui.showError("I'm sorry, but the datetime format is incorrect :-(");
        }

    }
}
