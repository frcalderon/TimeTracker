import java.util.ArrayList;

public class Task extends Component{
    // ----- ATTRIBUTES -----
    private ArrayList<Interval> intervals;

    // ----- CONSTRUCTOR -----
    public Task(String name, Component parent) {
        super(name, parent);
    }

    // ----- METHODS -----
    public void startInterval() {
        //TODO
    }

    public void endInterval() {
        //TODO
    }

    public void acceptVisitor(Visitor v) {
        //TODO;
    }
}
