package otus;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* Функциональные интерфейсы из java.util.function
Predicate<T> - Функция, принимающая тип Т и возвращающая boolean.
Supplier<T> - Функция, которая ничего не принимает, но возвращает тип Т.
Consumer<T> - Функция, которая принимает объект типа Т, но ничего не возвращает.
Function<T,U> - Функция, которая принимает тип Т, но возвращает тип U.
UnaryOperator<T> - Функция, принимающая тип Т и возвращающая тип Т.
 */
public class FunctionalDemo {
    public static class Person {
        public int age;

        public Person(int age) {
            this.age = age;
        }
    }

/* //До преобразования в лямбду вызов функционального интерфейса выглядило бы так:
    public static Predicate<Person> canPersonGoToBar =
            new Predicate<Person>() {
                @Override
                public boolean test(Person person) {
                    return person.age >= 18;
                }
            };
 */
    public static Predicate<Person> canPersonGoToBar =
                  p -> p.age >= 18;

    /* //До преобразования в лямбду вызов функционального интерфейса выглядило бы так:
    public static Function<Person,Integer> getPersonAge =
            new Function<Person, Integer>() {
                @Override
                public Integer apply(Person person) {
                    return person.age;
                }
            };
     */
    public static Function<Person,Integer> getPersonAge =
            person -> {
                System.out.println("123");
                return person.age;
            };

    public static Supplier<String> getSomeString = () -> "Hello";

    public static void main(String[] args) {
        //можно ли пускать человека в бар или нельзя?
        var person = new Person(18);
        checkPerson(person,canPersonGoToBar);
    }

    public static void checkPerson (Person person, Predicate<Person> checker) {
        System.out.println(checker.test(person));
    }
}
