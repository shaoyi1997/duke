import java.util.Scanner;

public class Duke {

    private static String insertIndentation(String input) {
        return "    ____________________________________________________________" + "\n     " + input + "\n"
                + "    ____________________________________________________________";
    }

    public static void main(String[] args) {
        System.out.println(insertIndentation("Hello! I'm Duke\n" +
                "     What can I do for you?"));
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("bye")) {
            System.out.println(insertIndentation(input));
            input = sc.nextLine();
        }
        if (input.equals("bye")) {
            System.out.println(insertIndentation("Bye. Hope to see you again soon!"));
        }
    }
}
