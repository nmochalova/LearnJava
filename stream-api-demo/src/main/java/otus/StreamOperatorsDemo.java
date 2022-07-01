package otus;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLOutput;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperatorsDemo {
    public static void main(String[] args) throws UserPrincipalNotFoundException {
        Integer[][] arr = new Integer[][] {{1,2,3,4,5},{10,20,30,40},{100,200}};

        //Распаковать двумерный массив в плоскую структуру, чтобы все эл-ты были в одном потоке
        Stream.of(arr)
                .flatMap(it -> Stream.of(it))
                .forEach(it -> System.out.println(it));

        //peek позволяет проделать с эл-тами что-либо и дальше пустить их без изменений. Удобно для дебага.
        //В примере мы взяли массив распоковали его, распечатали и дальше собрали все в список.
        var list = Stream.of(arr)
                .flatMap(it -> Stream.of(it))
                .peek(it -> System.out.println(it))
                .collect(Collectors.toList());

        System.out.println("===========================");
        //Получить результат суммы от стрима который получается через последовательность от 0 с шагом 5.
        //reduce - первый параметр аккумулятор (х), то что пришло в параметре - (у)
        var sum = Stream.iterate(0,x->x+5)
                .skip(10)                     //пропустить первые 10
                .limit(10)                //взять следующие 10
                .reduce(0, (x,y) -> x+y); //прибавляем у к аккумулятору x
        System.out.println(sum);

        System.out.println("===========================");
        //Добавить фильтр: просуммировать только те значения которые больше 50 (порядок фильтров имеет значение!!!)
        var sum1 = Stream.iterate(0,x->x+5)
                .filter(x -> x > 50)
                .limit(10)
                .reduce(0, (x,y) -> x+y);
        System.out.println(sum1);


        //Optional имеет метод value.
        var optionalInteger = Stream.of(arr)
                .flatMap(it -> Stream.of(it))
                .findFirst();
        //Если есть значение, то напечатать
        optionalInteger.ifPresent(System.out::println);

        //если null, то верни 0.
        var optionalInteger1 = Stream.of(arr)
                .flatMap(it -> Stream.of(it))
                .findFirst().orElseGet(()->0);

        //если null, то брось исключение.
        var optionalInteger2 = Stream.of(arr)
                .flatMap(it -> Stream.of(it))
                .findFirst().orElseThrow(()-> new UserPrincipalNotFoundException("msg"));


    }

}
