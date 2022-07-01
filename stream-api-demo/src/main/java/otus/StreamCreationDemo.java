package otus;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreationDemo {
    public static void main(String[] args) {
        //из произвольных данных
        Stream<Object> integerStream = Stream.of("Hello", 1, new Object());

        //Стримы для классов оберток
        IntStream intStream = IntStream.of(1,2,3);
        DoubleStream doubleStream = DoubleStream.of(1.0,2.0,3.0);
        LongStream longStream = LongStream.of(1L,2L,3L);

        // From массивов
        Object[] objects = new Object[] {"Hello","World", new Object()};
        var arrayStream = Arrays.stream(objects);

        //Диапазоны [0,11) - открытый, где 11 не включено
        IntStream.range(0,11);

        //Диапазоны [0,10] - закрытый, где включены все значения
        IntStream.rangeClosed(0,10);

        //Последовательности. Пример: последовательность, кот. начинается с 100 и на каждом шагу прибавляется 5
        Stream.iterate(100, x -> x+5)
                .limit(5)                   //ограничение по кол-ву - первые пять.
                .forEach(it -> System.out.println(it));
    }
}
