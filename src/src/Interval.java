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
    }

    public void endInterval() {
        this.endTime = this.startTime.plus(this.duration.getSeconds(), ChronoUnit.SECONDS);
    }

    public Duration getDuration() { return this.duration; }

    @Override
    public void update(Observable o, Object arg) {
        LocalDateTime currentTime = (LocalDateTime) arg;
        if (this.startTime == null) {
            this.startTime = currentTime;
            task.setStartTime(currentTime);
        }
        this.duration = Duration.between(this.startTime, currentTime);
    }
}
