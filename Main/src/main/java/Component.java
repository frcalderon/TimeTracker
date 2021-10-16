import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        this.duration = Duration.ZERO;
        if (this.parent != null) this.parent.addChild(this);
    }

    // ----- METHODS -----
    public String getName() { return this.name; }
    public Component getParent() {
        return this.parent;
    }
    public Duration getDuration() { return this.duration; }
    public LocalDateTime getStartTime() { return this.startTime; }

    public void setStartTime(LocalDateTime startTime) {
        if (this.startTime == null) {
            this.startTime = startTime;
            if (parent != null) this.parent.setStartTime(startTime);
        }
    }
    public void setDuration(Duration duration) {
        this.duration = duration;
        if (this.parent != null) this.parent.componentDuration();
    }
    public abstract void componentDuration();
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        if (this.parent != null) this.parent.setEndTime(this.endTime);
    }

    public abstract void acceptVisitor(Visitor visitor);
    public abstract void addChild(Component component);

    public void endComponent() { this.endTime = this.startTime.plus(this.duration.getSeconds(), ChronoUnit.SECONDS); }

    @Override
    public String toString() {
        String parentName;
        if (this.parent == null) parentName = null;
        else parentName = this.parent.getName();
        return String.format("%-10s %-10s child of %-10s %-25s %-25s %-5d", this.getClass().getSimpleName(),
                this.name, parentName, Utils.formatTime(this.startTime),
                Utils.formatTime(this.endTime), this.duration.toSeconds());
    }
}
