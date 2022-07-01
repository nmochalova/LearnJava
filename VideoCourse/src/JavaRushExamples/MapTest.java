package JavaRushExamples;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static Map<String, String> createMap() {
        Map<String,String> names = new HashMap<>();
        names.put("Иванов","Петр");
        names.put("Левочкин","Петр");
        names.put("Вещий","Олег");
        names.put("Коптян","Амир");
        names.put("Железный","Василий");
        names.put("Распутин","Григорий");
        names.put("Маяковский","Владимир");
        names.put("Соловьев","Николай");
        names.put("Путин","Владимир");
        names.put("Шукшин","Василий");
        return names;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int counter = 0;
        for(Map.Entry<String,String> m : map.entrySet()) {
            if (m.getValue().equals(name))
                counter++;
        }
        return counter;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int counter = 0;
        for(Map.Entry<String,String> m : map.entrySet()) {
            if (m.getKey().equals(lastName))
                counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Map<String, String> names = createMap();
        for(Map.Entry<String,String> n : names.entrySet()) {
            System.out.println(n.getKey()+" "+n.getValue());
        }

        System.out.println(getCountTheSameFirstName(names,"Василий"));
        System.out.println(getCountTheSameLastName(names,"Шукшин"));
    }
}
