package habr;

import java.util.Arrays;
import java.util.Collection;

// Метод anyMatch - возвращает true, если условие выполняется хотя бы для одного элемента
// Метод noneMatch - возвращает true, если условие не выполняется ни для одного элемента
// Метод allMatch - возвращает true, если условие выполняется для всех элементов
public class testMatch {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Test anyMatch, allMatch, noneMatch  start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // найти существуют ли хоть одно совпадение с шаблоном в коллекции
        boolean isAnyOneTrue = collection.stream().anyMatch("a1"::equals);
        System.out.println("anyOneTrue " + isAnyOneTrue); // напечатает true
        boolean isAnyOneFalse = collection.stream().anyMatch("a8"::equals);
        System.out.println("anyOneFlase " + isAnyOneFalse); // напечатает false

        // найти существуют ли все совпадения с шаблоном в коллекции
        boolean isAll = collection.stream().allMatch((s) -> s.contains("1"));
        System.out.println("isAll " + isAll); // напечатает false

        // сравнение на неравенство
        boolean isNotEquals = collection.stream().noneMatch("a7"::equals);
        System.out.println("isNotEquals " + isNotEquals); // напечатает true

    }
}
