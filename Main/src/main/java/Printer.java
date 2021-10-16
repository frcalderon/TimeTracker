import java.util.Timer;
import java.util.TimerTask;

public class Printer implements Visitor{
    private static Printer uniqueInstance;
    private Component root;
    public static Printer getInstance(Component root) {
        if (uniqueInstance == null) {uniqueInstance = new Printer(root);}
        return uniqueInstance;
    }

    // ----- METHODS -----
    private Printer(Component root) {
        this.root = root;
        root.acceptVisitor(this);
    }

    public void print() {
        this.root.acceptVisitor(this);
        System.out.println("\n");
    }

    @Override
    public void visitProject(Project project) {
        System.out.println(project.toString());
    }

    @Override
    public void visitTask(Task task) {
        System.out.println(task.toString());
    }

    @Override
    public void visitInterval(Interval interval) {
        System.out.println(interval.toString());
    }
}
