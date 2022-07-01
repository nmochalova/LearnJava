package JavaRushExamples;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

public class Practic {

    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Ангелина", dateFormat.parse("JUL 23 2013"));
        map.put("Борис", dateFormat.parse("JUL 22 2013"));
        map.put("Наташа", dateFormat.parse("OCT 8 1980"));
        map.put("Гузаль", dateFormat.parse("JUL 17 1986"));
        map.put("Мария", dateFormat.parse("FEB 2 1987"));
        map.put("Надежда", dateFormat.parse("SEP 30 1991"));
        map.put("Дмитрий", dateFormat.parse("AUG 15 1986"));
        map.put("Наталья", dateFormat.parse("MAY 25 1981"));
        map.put("Рита", dateFormat.parse("OCT 15 2013"));

        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        ZoneId id = ZoneId.systemDefault();
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Date date = iterator.next().getValue();
            Month month = LocalDate.ofInstant(date.toInstant(), id).getMonth();
            if (month == Month.JUNE || month == Month.JULY || month == Month.AUGUST)
                iterator.remove();
        }
    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        for (Map.Entry<String,Date> m : map.entrySet()) {
            System.out.println(m.getKey() + " "+m.getValue());
        }

        removeAllSummerPeople(map);

        System.out.println();
        for (Map.Entry<String,Date> m : map.entrySet()) {
            System.out.println(m.getKey() + " "+m.getValue());
        }
    }
}
