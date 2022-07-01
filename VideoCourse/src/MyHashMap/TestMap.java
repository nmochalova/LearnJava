package MyHashMap;

import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String,Integer> scores = new HashMap<String, Integer>();

        scores.put("Кэти",42);
        scores.put("Берт",343);
        scores.put("Бетти",343); //отображение может иметь одинаковые значения для разных ключей, но дублирование ключей не допускается
        scores.put("Скайлер",420);

        System.out.println(scores);
        System.out.println(scores.get("Кэти"));

    }
}
