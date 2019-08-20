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
            if (input.equals("list")) {
                StringBuilder stringOfItems = new StringBuilder();
                for (int i = 0; i < numOfItems; i++) {
                    stringOfItems.append("     " + (i + 1) + ". " + addedItems.get(i)
                            + (i == numOfItems - 1 ? "" : "\n"));
                }
                System.out.println(insertLines(stringOfItems.toString()));
            } else {
                addedItems.add(new Task(input));
                numOfItems++;
                System.out.println(insertLines("     added: " + input));
            }
            input = sc.nextLine();
        }

        System.out.println(insertLines("     Bye. Hope to see you again soon!"));
    }

    public static void main(String[] args) {
        run();
    }
}