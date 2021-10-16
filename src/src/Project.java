import java.util.ArrayList;

public class Project extends Component {
    // ----- ATTRIBUTES -----
    private ArrayList<Component> components;

    // ----- CONSTRUCTOR -----
    public Project(String name, Component parent) {
        super(name, parent);
    }

    // ----- METHODS -----
    public ArrayList<Component> getChildren() {
        return this.components;
    }

    public void addChild(Component child) {
        this.components.add(child);
    }

    public void removeChild(Component child) {
        this.components.remove(child);
    }

    public void acceptVisitor(Visitor v) {
        //TODO;
    }
}
