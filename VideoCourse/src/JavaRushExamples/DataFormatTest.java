package JavaRushExamples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class DataFormatTest {
    //Выведи на экран текущую дату в таком формате: "21 02 2014".
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        System.out.println(date.format(formatter));

        System.out.println("===== DateFormatter ====");
        DateFormatter();
    }

    //Преобразование строки в дату
    public static void DateFromString() throws ParseException {
        String str = "15/04/1990";
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date bd = formatter.parse(str);
    }

    //Преобразовать дату в формат 15-Apr-1990 (часть 2)
    public static void DateFormatter() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
        String dateFormat = formatter.format(date);
        System.out.println(dateFormat);
    }
}
