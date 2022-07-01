package JavaRushExamples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsFrequency {
    public static Map<String, String> createMap() {
        Map<String, String> names = new HashMap<>();
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        for (String name : copy.values()) {
            if (Collections.frequency(map.values(), name) > 1)
                removeItemFromMapByValue(map,name);
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> names = createMap();
        for(Map.Entry<String,String> n : names.entrySet()) {
            System.out.println(n.getKey()+" "+n.getValue());
        }

        removeTheFirstNameDuplicates(names);

        System.out.println();
        for(Map.Entry<String,String> n : names.entrySet()) {
            System.out.println(n.getKey()+" "+n.getValue());
        }
    }
}
