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
        sc = new Scanner(System.in);
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
    public void showWelcome() {
        System.out.println(insertLines("     Hello! I'm Duke\n" + "     What can I do for you?"));
    }

    /**
     * Parses the command given by the user.
     *
     * @return Command object that specifies what command the user has given.
     * @throws DukeException exception is thrown when the command cannot be found or does not meet its specifications.
     */
    public Command readCommand() throws DukeException {
        String input = sc.nextLine().trim();
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.substring(0, 4).equals("find")) {
            return new FindCommand(input.substring(5));
        } else if (input.length() >= 6 && input.substring(0,4).equals("done")) {
            return new DoneCommand(Integer.parseInt(input.substring(5)));
        } else if ((input.length() >= 7 && input.substring(0,6).equals("delete"))) {
            return new DeleteCommand(Integer.parseInt(input.substring(7)));
        } else if (input.equals("list")) {
            return new ListCommand();
        } else {
            return new AddCommand(input);
        }
    }

    /**
     * Displays the successful completion message after the completion of a command.
     *
     * @param msg completion message to be printed
     */
    public void showResultOfCommand(String msg) {
        System.out.println(insertLines(msg));
    }

    /**
     * Displays the error message whenever a error is found.
     *
     * @param msg error message to be printed.
     */
    public void showError(String msg) {
        System.out.println(insertLines("     ☹ OOPS!!! " + msg));
    }

    /**
     * Displays the loading error whenever the text file in which Duke reads and writes from cannot be opened.
     */
    public void showLoadingError() {
        System.out.println(insertLines("     ☹ OOPS!!! The file cannot be opened"));
    }
}
