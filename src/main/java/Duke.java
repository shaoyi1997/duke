import java.util.*;

public class Duke {

    private static void addTaskToList(ArrayList<Task> list, String input) {
        Task tk;
        int idxOfSlash;

        if (input.length() >= 4) {

            try {
                // add Deadline
                if (input.length() >= 8 && input.substring(0,8).equals("deadline")) {
                    idxOfSlash = input.indexOf("/by");
                    tk = new Deadline(input.substring(9, idxOfSlash - 1), input.substring(idxOfSlash + 4));
                }

                // add Event
                else if (input.length() >= 5 && input.substring(0,5).equals("event")) {
                    idxOfSlash = input.indexOf("/at");
                    tk = new Event(input.substring(6, idxOfSlash - 1), input.substring(idxOfSlash + 4));
                }

                // add ToDos
                else if (input.substring(0,4).equals("todo")) {
                    tk = new ToDo(input.substring(5));
                } else {
                    System.out.println("Invalid Input");
                    return;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Invalid Input");
                return;
            }
        } else {
            System.out.println("Invalid Input");
            return;
        }
        list.add(tk);
        System.out.println(insertLines("     Got it. I've added this task: \n       "
                + tk + "\n     Now you have " + list.size() + " tasks in the list."));
    }

    private static String insertLines(String input) {
        return "    ____________________________________________________________" + "\n" + input + "\n"
                + "    ____________________________________________________________";
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> addedItems = new ArrayList<Task>();
        String input;

        System.out.println(insertLines("     Hello! I'm Duke\n" + "     What can I do for you?"));
        input = sc.nextLine();

        while (!input.equals("bye")) {

            // mark as done
            if (input.length() >= 6 && input.substring(0,4).equals("done")) {
                try {
                    int taskNum = Integer.parseInt(input.substring(5));
                    if (taskNum > addedItems.size()) {
                        System.out.println("List only has " + addedItems.size() + " items.");
                    } else {
                        Task curTask = addedItems.get(taskNum - 1);
                        curTask.markDone();
                        System.out.println(insertLines("     Nice! I've marked this task as done: \n     " + curTask));
                    }
                } catch (NumberFormatException e) {
                    addTaskToList(addedItems, input);
                }
            }

            // list added items
            else if (input.equals("list")) {
                StringBuilder stringOfItems = new StringBuilder("     Here are the tasks in your list:\n");
                int numOfItems = addedItems.size();
                for (int i = 0; i < numOfItems; i++) {
                    stringOfItems.append("     " + (i + 1) + ". " + addedItems.get(i)
                            + (i == numOfItems - 1 ? "" : "\n"));
                }
                System.out.println(insertLines(stringOfItems.toString()));
            }

            // add item to list
            else {
                addTaskToList(addedItems, input);
            }

            input = sc.nextLine();
        }

        // bye
        System.out.println(insertLines("     Bye. Hope to see you again soon!"));
    }

    public static void main(String[] args) {
        run();
    }
}