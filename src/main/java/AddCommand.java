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
        input = ipt;
    }

    /**
     * Indicates whether this is an exit command.
     *
     * @return false.
     */
    public boolean isExit() { return false; }

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
        Task tk;
        int idxOfSlash;

        try {
            if (input.length() >= 4) {

                // add Deadline
                if (input.length() >= 8 && input.substring(0, 8).equals("deadline")) {
                    idxOfSlash = input.indexOf("/by ");
                    if (idxOfSlash == -1 || input.split(" ")[1].contains("/")) {
                        throw new DukeException("The description of the deadline is incorrect.");
                    }
                    tk = new Deadline(input.substring(9, idxOfSlash - 1),
                            format.format(format.parse(input.substring(idxOfSlash + 4))));
                }

                // add Event
                else if (input.length() >= 5 && input.substring(0, 5).equals("event")) {
                    idxOfSlash = input.indexOf("/at ");
                    if (idxOfSlash == -1 || input.split(" ")[1].contains("/")) {
                        throw new DukeException("The description of the event is incorrect.");
                    }
                    tk = new Event(input.substring(6, idxOfSlash - 1),
                            format.format(format.parse(input.substring(idxOfSlash + 4))));
                }

                // add ToDos
                else if (input.substring(0, 4).equals("todo")) {
                    try {
                        tk = new ToDo(input.substring(5));
                    } catch (StringIndexOutOfBoundsException e) {
                        throw new DukeException("The description of a todo cannot be empty.");
                    }
                } else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
                tasks.addTask(tk);
                storage.updateFile(tasks);
                ui.showResultOfCommand("     Got it. I've added this task: \n       "
                        + tk + "\n     Now you have " + tasks.getNumOfTask() + " tasks in the list.");
            } else {
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
            }
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        } catch (ParseException e) {
            ui.showError("I'm sorry, but the datetime format is incorrect :-(");
        }
    }
}
