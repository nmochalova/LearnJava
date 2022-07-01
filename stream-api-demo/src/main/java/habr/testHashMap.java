package habr;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class testHashMap {
    public static void main(String[] args) {
        HashMap<String, Date> namesAndDateFormat = new HashMap<>();

        //Найти максимальную дату, где дата лежит в Value структуры HashMap
        Date maxDate = namesAndDateFormat.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getValue();

        //Выбрать массив строк (Key), который соответствует максимальной дате (Value)
        List<String> result = namesAndDateFormat.entrySet().stream()
                .filter(p -> p.getValue().equals(maxDate))
                .map(p -> p.getKey())
                .collect(Collectors.toList());
    }
}
