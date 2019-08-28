import java.util.*;

public class Ui {

    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public static String insertLines(String input) {
        return "    ____________________________________________________________" + "\n" + input + "\n"
                + "    ____________________________________________________________";
    }

    public void showWelcome() {
        System.out.println(insertLines("     Hello! I'm Duke\n" + "     What can I do for you?"));
    }

    public Command readCommand() throws DukeException {
        String input = sc.nextLine().trim();
        if (input.equals("bye")) {
            return new ExitCommand();
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

    public void showResultOfCommand(String msg) {
        System.out.println(insertLines(msg));
    }

    public void showError(String msg) {
        System.out.println(insertLines("     ☹ OOPS!!! " + msg));
    }

    public void showLoadingError() {
        System.out.println(insertLines("     ☹ OOPS!!! The file cannot be opened"));
    }
}
