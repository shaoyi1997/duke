import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class for the Ui (User Interaction) object.
 * Handles all user input and program output to the user.
 */
public class Ui {

    private Scanner sc;

    /**
     * Constructor for Ui.
     * Initializes the Scanner object.
     */
    public Ui() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Inserts a line above and below the input string.
     *
     * @param input input string to be sandwiched by lines.
     * @return string consisting of the input and two lines, above and below the string
     */
    public static String insertLines(String input) {
        return "    ____________________________________________________________" + "\n" + input + "\n"
                + "    ____________________________________________________________";
    }

    /**
     * Prints the welcome message to the user.
     */
    public String showWelcome() {
        return "     Hello! I'm Duke\n" + "     What can I do for you?";
    }

    /**
     * Parses the command given by the user.
     *
     * @return Command object that specifies what command the user has given.
     * @throws DukeException exception is thrown when the command cannot be found or does not meet its specifications.
     */
    public String readCommand() throws DukeException {
        try {
            return sc.nextLine().trim();
        } catch (NoSuchElementException e) {
            throw new DukeException("Please input your next command.");
        }
    }

    /**
     * Displays the successful completion message after the completion of a command.
     *
     * @param msg completion message to be printed
     */
    public String showResultOfCommand(String msg) {
        return msg;
    }

    /**
     * Displays the error message whenever a error is found.
     *
     * @param msg error message to be printed.
     */
    public String showError(String msg) {
        return "     ☹ OOPS!!! " + msg;
    }

    /**
     * Displays the loading error whenever the text file in which Duke reads and writes from cannot be opened.
     */
    public String showLoadingError() {
        return "     ☹ OOPS!!! The file cannot be opened";
    }
}
