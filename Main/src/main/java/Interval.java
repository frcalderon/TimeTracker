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
        this.startTime = LocalDateTime.now();
        task.setStartTime(this.startTime);
        Clock.getInstance().addObserver(this);
    }

    public void endInterval() {
        this.endTime = this.startTime.plus(this.duration.getSeconds(), ChronoUnit.SECONDS);
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
        this.duration = Duration.between(this.startTime, currentTime);
        this.task.componentDuration();
        this.task.setEndTime(this.endTime);
        Printer.getInstance(null).print();
    }

    @Override
    public String toString() {
        return String.format("%-21s child of %-10s %-25s %-25s %-5d", this.getClass().getSimpleName(), this.task.getName(),
                Utils.formatTime(this.startTime), Utils.formatTime(this.endTime), this.duration.toSeconds());
    }

    public void acceptVisitor(Visitor visitor) {
        visitor.visitInterval(this);
    }
}
