import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Component {
    // ----- ATTRIBUTES -----
    private String name;
    private Component parent;
    private Duration duration;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // ----- CONSTRUCTOR -----
    public Component(String name, Component parent) {
        this.name = name;
        this.parent = parent;
    }

    // ----- METHODS -----
    public String getName() { return this.name; }
    public Component getParent() {
        return this.parent;
    }
    public Duration getDuration() { return this.duration; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setDuration(Duration duration) { this.duration = duration; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public abstract void acceptVisitor(Visitor visitor);

    public abstract void computeDuration();

    public void endComponent() { this.endTime = this.startTime.plus(this.duration.getSeconds(), ChronoUnit.SECONDS); }

    @Override
    public String toString() {
        return this.getClass() + " " + this.name + "\tchild of " + this.parent.getName() + "\t" + this.startTime + "\t" + this.endTime + "\t" + this.duration.toSeconds();
    }
}
