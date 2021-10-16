import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;

public class Interval implements java.util.Observer{
    // ----- ATTRIBUTES -----
    private LocalDateTime startTime; // Update double class to dateTime when CV is up
    private LocalDateTime endTime;
    private Duration duration;
    private Task task;

    public Interval(Task task) {
        this.task = task;
        if (task.getStartTime() == null) task.setStartTime(this.startTime);
        Clock.getInstance().addObserver(this);
    }

    public void endInterval() {
        //this.endTime = this.startTime.plus(this.duration.getSeconds(), ChronoUnit.SECONDS);
        this.duration = Duration.between(this.startTime, this.endTime);
        this.task.setDuration(this.duration);
        this.task.setEndTime(this.endTime);
        Clock.getInstance().deleteObserver(this);
    }

    public Duration getDuration() { return this.duration; }
    public LocalDateTime getEndTime() {return this.endTime; }

    @Override
    public void update(Observable o, Object arg) {
        LocalDateTime currentTime = (LocalDateTime) arg;
        if (this.startTime == null) {
            this.startTime = currentTime;
            task.setStartTime(this.startTime);
        }
        this.duration = Duration.between(this.startTime, currentTime);
        this.endTime = currentTime;
        this.task.componentDuration();
        this.task.setEndTime(this.endTime);
        Printer.getInstance(null).print();
    }

    @Override
    public String toString() {
        return String.format("%-21s child of %-10s %-30s %-30s %-5d", this.getClass().getSimpleName(), this.task.getName(),
                this.startTime, this.endTime, Utils.roundDuration(this.duration));
    }

    public void acceptVisitor(Visitor visitor) {
        visitor.visitInterval(this);
    }
}
