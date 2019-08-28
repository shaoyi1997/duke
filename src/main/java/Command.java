abstract public class Command {

    abstract public boolean isExit();

    abstract public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
