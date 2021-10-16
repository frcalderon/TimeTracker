public interface Visitor {
    void visitProject(Project project);
    void visitTask(Task task);
    void visitInterval(Interval interval);
}
