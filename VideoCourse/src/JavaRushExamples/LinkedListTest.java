package JavaRushExamples;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/*
Измерить сколько времени занимает 10 тысяч вызовов get для каждого списка
*/
public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println(getGetTimeInMs(fill(new ArrayList<>())));
        System.out.println(getGetTimeInMs(fill(new LinkedList<>())));
    }

    public static List<Object> fill(List<Object> list) {
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        return list;
    }

    public static long getGetTimeInMs(List<Object> list) {
        Date before = new Date();

        get10000(list);

        Date after = new Date();
        long result = after.getTime() - before.getTime();
        return result;
    }

    public static void get10000(List<Object> list) {
        if (list.isEmpty()) {
            return;
        }
        int x = list.size() / 2;

        for (int i = 0; i < 10000; i++) {
            list.get(x);
        }
    }
}
