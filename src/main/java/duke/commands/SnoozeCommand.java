package duke.commands;

import com.google.common.eventbus.DeadEvent;
import duke.tasks.Deadline;
import duke.tasks.Event;
import duke.tasks.Task;
import duke.tasks.TaskWithDate;
import duke.utils.DukeException;
import duke.utils.Storage;
import duke.utils.TaskList;
import duke.utils.Ui;


public class SnoozeCommand extends Command{
    Integer extensionInDays;
    Integer index;

    /**
     * Generates a SnoozeCommand.
     *
     * @param input   Input should be in the format of `snooze taskNumber /by howLongToExtend`
     */
    public SnoozeCommand(String input) throws DukeException {
        String[] parsedInput = input.split("snooze ")[1].split(" /by ");
        index = Integer.parseInt(parsedInput[0]) - 1;
        extensionInDays = Integer.parseInt(parsedInput[1]);
        assert(index >= 0);
    }

    /**
     * Extends a task's deadline/date specified after the /by. Does not work on todo-type tasks.
     *
     * @param tasks    the tasklist
     * @param ui    the user-interface
     * @param storage Persistent storage for data
     * @return returns a string to signify success or failure.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
       Task task = tasks.getTask(index);
       if (task.getClass() == Event.class || task.getClass() == Deadline.class) {
           TaskWithDate datedTask = (TaskWithDate)task;
           datedTask.snooze(extensionInDays);
           return "Task successfully extended";
       } else {
           return "Oops, todo tasks have no date, try again with a different index!";
       }
    }

    @Override
    public boolean isExit(){
        return false;
    }
}
