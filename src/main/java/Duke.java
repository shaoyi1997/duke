import commands.Command;
import exception.DukeException;
import parser.Parser;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

import java.io.FileNotFoundException;

/**
 * A program that tracks a lists of tasks.
 * Capable of adding, deleting and listing tasks.
 * Tasks can be marked done.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for Duke program.
     * Initializes the Ui, Storage and Tasklist.
     *
     * @see Ui
     * @see Storage
     * @see TaskList
     */
    public Duke() {
        ui = new Ui();
        try {
            storage = new Storage("./data/tasks.txt");
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }


    /**
     * Returns the response of Duke after executing the user command.
     *
     * @param input the string representation of the user command.
     * @return the string representation of the Duke response
     */
    protected String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            return ui.showError(e.getMessage());
        }
    }


}