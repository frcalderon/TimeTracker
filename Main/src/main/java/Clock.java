import java.time.LocalDateTime;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends java.util.Observable{

    private TimerTask timerTask;
    private Timer timer;
    private static Clock uniqueInstance;

    private Clock() {
        this.timer = new Timer("Timer");
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };
        timer.scheduleAtFixedRate(this.timerTask, 0, 1000);
    }

    //Singleton implementation
    public static Clock getInstance() {
        if (uniqueInstance == null) {uniqueInstance = new Clock();}
        return uniqueInstance;
    }

    private void tick() {
        setChanged();
        notifyObservers(LocalDateTime.now());
    }
}
