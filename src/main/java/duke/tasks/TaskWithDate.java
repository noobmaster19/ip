package duke.tasks;
import duke.utils.DukeException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Is a special task with dates. Deadline and Event will inherit from this.
 */
public class TaskWithDate extends Task{
    private LocalDate date;

    public TaskWithDate(String description, String date) {
        super(description);
        this.date = LocalDate.parse(date);
    }

    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Extends the deadline/event
     *
     * @param  snoozeTime how many days to extend the deadline by.
     */
    public void snooze(Integer snoozeTime) {
        date = date.plusDays(snoozeTime);
    }

    public void printDate() {
        System.out.println(date.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
    }
}
