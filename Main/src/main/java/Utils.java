import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Utils {
    public static LocalDateTime formatTime(LocalDateTime time) {
        if (time != null) return time.truncatedTo(ChronoUnit.SECONDS);
        return null;
    }
}
