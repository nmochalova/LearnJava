package habr;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// Метод distinct возвращает stream без дубликатов, при этом для упорядоченного стрима (например, коллекция на основе list) порядок стабилен , для неупорядоченного - порядок не гарантируется
// Метод collect преобразует stream в коллекцию или другую структуру данных
public class testDistinct {
    public static void main(String[] args) {
        System.out.println("Test buildStream start");
        System.out.println("Test distinct start");
        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);

        // Получение коллекции без дубликатов
        List<String> distinct = nonOrdered.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct = " + distinct); // напечатает distinct = [a1, a2, a3] - порядок не гарантируется

        List<String> distinctOrdered = ordered.stream().distinct().collect(Collectors.toList());
        System.out.println("distinctOrdered = " + distinctOrdered); // напечатает distinct = [a1, a2, a3] - порядок гарантируется
    }

}
