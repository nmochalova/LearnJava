package habr;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleFilter {
    public static void main(String[] args) {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3","a1");

        System.out.println("Вернуть первый элемент коллекции или 0, если коллекция пуста: " +
                collection.stream().findFirst().orElse("0"));

        System.out.println("Найти элемент в коллекции равный «a3» или кинуть ошибку: " +
                collection.stream().filter("a3"::equals).findFirst().get()); //boolean func(s) { return «a3».equals(s);},

        System.out.println("Вернуть третий элемент коллекции по порядку: " +
                collection.stream().skip(2).findFirst().get());


        // Вернуть первые два элемента
        List<String> limit = collection.stream().limit(2).collect(Collectors.toList());
        System.out.println("limit = " + limit); // напечатает limit = [a1, a2]

        // Вернуть два элемента начиная со второго
        List<String> fromTo = collection.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println("fromTo = " + fromTo); // напечатает fromTo = [a2, a3]

        // вернуть последний элемент коллекции
        String last = collection.stream().skip(collection.size() - 1).findAny().orElse("1");
        System.out.println("last = " + last ); // напечатает last = a1

        // Вернуть количество вхождений объекта
        long count = collection.stream().filter("a1"::equals).count();
        System.out.println("count = " + count); // напечатает count = 2

        // Выбрать все элементы по шаблону
        List<String> select = collection.stream().filter((s) -> s.contains("1")).collect(Collectors.toList());
        System.out.println("select = " + select); // напечатает select = [a1, a1]
    }
}

/*
Обратите внимание, что методы findFirst и findAny возвращают новый тип Optional, появившийся в Java 8,
для того чтобы избежать NullPointerException. Метод filter удобно использовать
 для выборки лишь определенного множества значений, а метод skip позволяет пропускать определенное количество элементов.
 */
