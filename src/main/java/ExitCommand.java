public class ExitCommand extends Command {

    public ExitCommand() {}

    public boolean isExit() {
        return true;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showResultOfCommand("     Bye. Hope to see you again soon!");
    }
}
