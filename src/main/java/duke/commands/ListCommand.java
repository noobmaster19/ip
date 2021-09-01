package duke.commands;

import java.util.*;

import duke.tasks.Task;
import duke.utils.*;

/**
 * Represent an listing/enumeration action to be executed.
 */
public class ListCommand extends Command {
    /**
     * prints out all tasks in memory.
     *
     * @param tasks    the tasklist
     * @param ui    the user-interface
     * @param storage Persistent storage for data
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> userInputs = tasks.getTasks();
        String tasksToPrint = "";
        for (int i = 0; i < userInputs.size(); i++) {
            Task task = userInputs.get(i);
            tasksToPrint += (task + " ");
        }
        return tasksToPrint;
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
