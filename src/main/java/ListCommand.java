public class ListCommand extends Command {

    public ListCommand() {}

    public boolean isExit() { return false; }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder stringOfItems = new StringBuilder("     Here are the tasks in your list:\n");
        int numOfItems = tasks.getNumOfTask();
        for (int i = 0; i < numOfItems; i++) {
            stringOfItems.append("     " + (i + 1) + ". " + tasks.getTaskByIndex(i)
                    + (i == numOfItems - 1 ? "" : "\n"));
        }
        ui.showResultOfCommand(stringOfItems.toString());
    }
}
