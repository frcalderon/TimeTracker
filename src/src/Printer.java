public class Printer implements Visitor{

    // ----- METHODS -----
    public Printer(Component root) {
        //TODO
    }

    @Override
    public void visitProject(Project project) {
        System.out.println(project.toString());
    }

    @Override
    public void visitTask(Task task) {
        System.out.println(task.toString());
    }
}
