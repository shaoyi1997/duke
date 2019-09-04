/**
 * Class for the command that prompts the program to terminate.
 */
public class ExitCommand extends Command {

    /**
     * Constructor for the exit command.
     */
    public ExitCommand() {
    }

    /**
     * Indicates whether this is an exit command.
     *
     * @return true.
     */
    public boolean isExit() {
        return true;
    }

    /**
     * Prints the bye message through the Ui object.
     *
     * @param tasks tasklist that stores all the tasks
     * @param ui ui object that deals with user interaction
     * @param storage storage object that deals with writing into the text file
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.showResultOfCommand("     Bye. Hope to see you again soon!");
    }
}
