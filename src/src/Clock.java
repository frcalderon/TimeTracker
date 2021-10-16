import java.time.LocalDateTime;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends java.util.Observable{

    private Long tick; //Precision in seconds
    private TimerTask timerTask;
    private Timer timer;
    private static Clock uniqueInstance;

    private Clock() {
        this.tick = 2000L;
        this.timer = new Timer("Timer");
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };
        timer.schedule(this.timerTask, this.tick);
    }

    //Singleton implementation
    public Clock getInstance() {
        if (uniqueInstance == null) {uniqueInstance = new Clock();}
        return uniqueInstance;
    }

    private void tick() {
        setChanged();
        notifyObservers(LocalDateTime.now());
    }
}
