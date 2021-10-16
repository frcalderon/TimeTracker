import java.time.Duration;

public abstract class Component {
    // ----- ATTRIBUTES -----
    private String name;
    private Component parent;
    private Duration componentDuration;

    // ----- CONSTRUCTOR -----
    public Component(String name, Component parent) {
        this.name = name;
        this.parent = parent;
    }

    // ----- METHODS -----
    public Duration computeComponentDuration() {
        //TODO
        return this.componentDuration;
    }

    public Component getParent() {
        return this.parent;
    }

    public abstract void start();
}
