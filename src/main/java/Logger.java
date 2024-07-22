import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static int num = 1;
    private static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private static Logger logger;

    private Logger() {}

    public static Logger getInstance() {
        return logger == null ? new Logger() : logger;
    }

    public void log(String msg) {
        System.out.println("["+ dateFormat.format(new Date()) + " " + num++ + "] " + msg);
    }
}
