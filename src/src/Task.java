import java.time.Duration;
import java.util.ArrayList;

public class Task extends Component{
    // ----- ATTRIBUTES -----
    private ArrayList<Interval> intervals;

    // ----- CONSTRUCTOR -----
    public Task(String name, Component parent) {
        super(name, parent);
        this.intervals = new ArrayList<Interval>();
    }

    // ----- METHODS -----
    public void playTask() {
        this.intervals.add(new Interval(this));
    }

    public void pauseTask() {
        this.intervals.get(this.intervals.size() - 1).endInterval();
    }

    public void acceptVisitor(Visitor visitor) {
        visitor.visitTask(this);
    }

    @Override
    public void computeDuration() {
        for (Interval interval : this.intervals) {
            setDuration(getDuration().plus(interval.getDuration()));
        }
    }
}
