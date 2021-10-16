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

    @Override
    public void componentDuration() {
        Duration taskDuration = Duration.ZERO;
        for (Interval interval : this.intervals) {
            taskDuration = taskDuration.plus(interval.getDuration());
        }
        this.setDuration(taskDuration);
    }

    // ----- METHODS -----
    public void playTask() {
        this.intervals.add(new Interval(this));
    }

    public void pauseTask() {
        this.intervals.get(this.intervals.size() - 1).endInterval();
        this.setEndTime(this.intervals.get(this.intervals.size()-1).getEndTime());
        this.setDuration(this.intervals.get(this.intervals.size()-1).getDuration());
    }
    public void addChild(Component child) {}
    public void acceptVisitor(Visitor visitor) {
        visitor.visitTask(this);
        for(Interval interval : this.intervals){
            interval.acceptVisitor(visitor);
        }
    }

}
