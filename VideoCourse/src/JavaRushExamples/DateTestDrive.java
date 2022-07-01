package JavaRushExamples;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateTestDrive {

    public static void main(String[] args) throws Exception
    {
        ////////////////////////////////////
        //Получение текущей даты:
        Date today = new Date();
        System.out.println("Current date: " + today);

        ////////////////////////////////////
        //Вычисление разницы между двумя датами:
        Date currentTime = new Date();           //получаем текущую дату и время
        Thread.sleep(3000);                      //ждём 3 секунды – 3000 миллисекунд
        Date newTime = new Date();               //получаем новое текущее время

        long msDelay = newTime.getTime() - currentTime.getTime(); //вычисляем разницу
        System.out.println("Time distance is: " + msDelay + " in ms");

        ////////////////////////////////////
        //Наступило ли уже некоторое время:
        Date startTime = new Date();

        long endTime = startTime.getTime() + 5000;   //    +5 секунд
        Date endDate = new Date(endTime);

        Thread.sleep(3000);              // ждем 3 секунды

        Date currentTime1 = new Date();
        if(currentTime1.after(endDate))//проверяем что время currentTime после endDate
        {
            System.out.println("End time!");
        }

        ////////////////////////////////////
        //Сколько прошло времени с начала сегодняшнего дня:
        //Date уже не очень свеж и был не очень хорошо разработан. Вместо него для новых программ рекомендуется использовать LocalDate.
        Date currentTime2 = new Date();
        int hours = currentTime2.getHours();
        int mins = currentTime2.getMinutes();
        int secs = currentTime2.getSeconds();

        System.out.println("Time from midnight " + hours + ":" + mins + ":" + secs);

        ////////////////////////////////////
        //Сколько дней прошло с начала года:
        Date yearStartTime = new Date();
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        yearStartTime.setDate(1);      // первое число
        yearStartTime.setMonth(0);     // месяц январь, нумерация для месяцев 0-11

        Date currentTime3 = new Date();
        long msTimeDistance = currentTime3.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
        System.out.println("Days from start of year: " + dayCount);

        ////////////////////////////////////
        //Получение года, месяца
        int Date;
        int Month;
        int Year;

        Calendar calendar = Calendar.getInstance();

        Date = calendar.get(Calendar.DAY_OF_MONTH);
        Month = calendar.get(Calendar.MONTH);
        Year = calendar.get(Calendar.YEAR);

        System.out.println(Date + " " + Month +" "+Year);

         ////////////////////////////////////
        //Взять текущий месяц
        ZoneId id = ZoneId.systemDefault();
        Instant instant = Instant.now();
        java.time.Month month = LocalDate.ofInstant(instant,id).getMonth();
        System.out.println(month);

        //Взять текущий месяц (2 вариант)
        Date date = new Date();
        java.time.Month month1 = LocalDate.ofInstant(date.toInstant(),id).getMonth();
        System.out.println(month1);
    }

}
