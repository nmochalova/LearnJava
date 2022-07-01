package JavaRushExamples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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

    //Парсим строку (пример: "28 июня 10 месяцев№) в дату
    private Date parserDate(String StringDateFromSite) {
        int day;
        String month;
        if (!StringDateFromSite.equals("О дате старта будет объявлено позже")) {
            String[] paramAndValue = StringDateFromSite.split(" ");
            try {
                day = Integer.parseInt(paramAndValue[0]);
                month = paramAndValue[1];
            } catch (NumberFormatException e) {
                day = Integer.parseInt(paramAndValue[1]);
                month = paramAndValue[2];
            }
            return StringToDate(day, month);
        } else
            return null;
    }

    //Преобразование строки в дату
    public Date StringToDate(int day, String month) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);

        String monthNumber = getMonth(month);
        try {
            String str = String.format("%d/%s/%d", day, monthNumber, year);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            return formatter.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public String getMonth(String month) {
        String monthRUS = String.valueOf(month.toCharArray(), 0, 3);
        switch (monthRUS) {
            case "янв":
                return "01";
            case "фев":
                return "02";
            case "мар":
                return "03";
            case "апр":
                return "04";
            case "май":
                return "05";
            case "июн":
                return "06";
            case "июл":
                return "07";
            case "авг":
                return "08";
            case "сен":
                return "09";
            case "окт":
                return "10";
            case "ноя":
                return "11";
            case "дек":
                return "12";
            default:
                return null;
        }
    }
}
