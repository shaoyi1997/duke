import java.io.FileNotFoundException;

/**
 * A CLI program that tracks a lists of tasks.
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
     * @param filePath The file path of the txt file Duke loads and writes the task lists to.
     * @see Ui
     * @see Storage
     * @see TaskList
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Executes the Duke program.
     * It successively reads the command input given by the user until the exit command is given.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                Command c = ui.readCommand();
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        new Duke("../../../data/tasks.txt").run();
    }
}