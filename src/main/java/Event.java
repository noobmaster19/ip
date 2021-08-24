public class Event extends TaskWithDate{
    public Event(String description, String at) {
        super(description,at);
    }
    
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + this.date + ")";
    }
}