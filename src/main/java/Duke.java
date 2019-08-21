import java.util.*;

public class Duke {

    private static String insertLines(String input) {
        return "    ____________________________________________________________" + "\n" + input + "\n"
                + "    ____________________________________________________________";
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> addedItems = new ArrayList<Task>();
        int numOfItems = 0;
        String input;

        System.out.println(insertLines("     Hello! I'm Duke\n" + "     What can I do for you?"));
        input = sc.nextLine();

        while (!input.equals("bye")) {

            // mark as done
            if (input.length() >= 6 && input.substring(0,4).equals("done")) {
                try {
                    int taskNum = Integer.parseInt(input.substring(5));
                    if (taskNum > numOfItems) {
                        System.out.println("List only has " + numOfItems + " items.");
                    } else {
                        Task curTask = addedItems.get(taskNum - 1);
                        curTask.markDone();
                        System.out.println(insertLines("     Nice! I've marked this task as done: \n     " + curTask));
                    }
                } catch (NumberFormatException e) {
                    addedItems.add(new Task(input));
                    numOfItems++;
                    System.out.println(insertLines("     added: " + input));
                }
            }

            // list added items
            else if (input.equals("list")) {
                StringBuilder stringOfItems = new StringBuilder("     Here are the tasks in your list:\n");
                for (int i = 0; i < numOfItems; i++) {
                    stringOfItems.append("     " + (i + 1) + ". " + addedItems.get(i)
                            + (i == numOfItems - 1 ? "" : "\n"));
                }
                System.out.println(insertLines(stringOfItems.toString()));
            }

            // add item to list
            else {
                addedItems.add(new Task(input));
                numOfItems++;
                System.out.println(insertLines("     added: " + input));
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