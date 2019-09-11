package commands;

import exception.DukeException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

/**
 * Abstract class for a command to be executed when the user inputs a command.
 */
abstract public class Command {

    abstract public boolean isExitCommand();

    abstract public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

}
