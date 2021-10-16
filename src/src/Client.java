public class Client {


    public static void main(String[] args) throws
            InterruptedException {
        // create and start the clock
        //...

        // make a small tree of projects and tasks
        Project root = new Project("root", null);
        Project p1 = new Project("P1", root);
        Project p2 = new Project("P2", root);
        Task t1 = new Task("T1", root);
        Task t2 = new Task("T2", p1);
        Task t3 = new Task("T3", p2);

        // make the printer
        Printer printer = new Printer(root);

        // the printer will periodically print the whole tree
        // from now on
        // ...

        // test it
        Thread.sleep(4000);
        // this will make some intervals
        t1.start();
        Thread.sleep(4000);
        t2.start();
        Thread.sleep(2000);

        // optionally, stop the clock
        // ...
    }
}