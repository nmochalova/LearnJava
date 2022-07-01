package YandexPracticum.LearnJava;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class FullMoons {
    static int DAY_IM = 1000 * 60 * 60 * 24;

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

    //   c.set(Calendar.ZONE_OFFSET,60000);
       c.setTimeZone(TimeZone.getTimeZone(ZoneId.of("GMT")));

        c.set(2004,0,7,15,40,0);
       // System.out.println(String.format("Полнолуние было в %tc",c));

        long day1 = c.getTimeInMillis();
        for (int i=0; i < 30; i++) {
            day1 += (DAY_IM * 29.52);
            c.setTimeInMillis(day1);
            System.out.println(String.format("Полнолуние было в %tc", c));
        }
    }
}
