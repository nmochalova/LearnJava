package habr;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExampleFilterCollection {
    // filter - возвращает stream, в котором есть только элементы, соответствующие условию фильтра
    // count - возвращает количество элементов в стриме
    // collect - преобразует stream в коллекцию или другую структуру данных
    // mapToInt - преобразовать объект в числовой стрим (стрим, содержащий числа)
    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Vasya",16,Sex.MAN),
                new People("Petya",23,Sex.MAN),
                new People("Elena",42,Sex.WOMAN),
                new People("Ivan Ivanovich",69,Sex.MAN)
        );
        //Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        System.out.println(peoples.stream()
                .filter((p)-> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MAN)
                .collect(Collectors.toList())
        );

        //Найти средний возраст среди мужчин
        System.out.println(peoples.stream()
                .filter((p) -> p.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble());

        //Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет,
        // а мужчина в 60)
        System.out.println(peoples.stream()
                .filter((p) -> p.getAge() >= 18)
                .filter((p) -> (p.getSex() == Sex.WOMAN && p.getAge() < 55) || (p.getSex() == Sex.MAN && p.getAge() < 60))
                .count());
    }

    public enum Sex {
        MAN,
        WOMAN
    }

    public static class People {
        private final String name;
        private final int age;
        private final Sex sex;

        public People(String name, int age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return String.format("{name=%s, age=%d, sex=%s}",name,age,sex);
        }
    }


}
