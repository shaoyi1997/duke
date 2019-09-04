import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Class for the Parser which parsers commands.
 */
public class Parser {

    /**
     * Parses the command given by the user.
     *
     * @param input the string representation of the command input by the user.
     * @return the command object given by the input.
     * @throws DukeException thrown when comm
     */
    public static Command parse(String input) throws DukeException {
        if (input.equals("bye")) {
            return new ExitCommand();
        } else if (input.length() <= 3) {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
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
     * Parses the add command.
     *
     * @param input the string representation of the add command.
     *              Format: type | description /(by||at) datetime.
     * @return the type of task to be added.
     * @throws DukeException thrown when input length is less than 4
     * @throws ParseException thrown when datetime is in incorrect format
     */
    protected static Task parseAddCommand(String input) throws DukeException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        int idxOfSlash;
        if (input.length() >= 8 && input.substring(0, 8).equals("deadline")) { // add Deadline
            idxOfSlash = input.indexOf("/by ");
            if (idxOfSlash == -1 || input.split(" ")[1].contains("/")) {
                throw new DukeException("The description of the deadline is incorrect.");
            }
            return new Deadline(input.substring(9, idxOfSlash - 1),
                                format.format(format.parse(input.substring(idxOfSlash + 4))));
        } else if (input.length() >= 5 && input.substring(0, 5).equals("event")) { // add Event
            idxOfSlash = input.indexOf("/at ");
            if (idxOfSlash == -1 || input.split(" ")[1].contains("/")) {
                throw new DukeException("The description of the event is incorrect.");
            }
            return new Event(input.substring(6, idxOfSlash - 1),
                             format.format(format.parse(input.substring(idxOfSlash + 4))));
        } else if (input.substring(0, 4).equals("todo")) { // add ToDos
            try {
                return new ToDo(input.substring(5));
            } catch (StringIndexOutOfBoundsException e) {
                throw new DukeException("The description of a todo cannot be empty.");
            }
        } else {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }

}
