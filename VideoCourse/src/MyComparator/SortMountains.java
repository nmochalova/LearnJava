package MyComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountains {
    LinkedList<Mountain> mtn = new LinkedList<Mountain>(); //разновидность ArrayList, который имеет преимущества при вставке эл-тов с середину коллекции

    //Встроенный класс. Компоратор. Перегружаем метод compare() в классе Comparator. Реализует сортировку по имени.
    class NameCompare implements Comparator<Mountain> {
        @Override
        public int compare(Mountain one, Mountain two) {
            return one.name.compareTo(two.name); //сравнивает текущее имя со следующим по алфавиту (метод compareTo для String)
        }
    }

    //Встроенный класс. Компоратор. Реализует сортировку по высоте.
    class HeightCompare implements Comparator<Mountain> {
        @Override
        public int compare(Mountain one, Mountain two) {
            return (two.height - one.height); //если = 0, то элементы на одном уровне, если значение больше 0, то второй элемент располагается выше первого, если меньше нуля, то - второй элемент ниже первого
        }
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }

    public void go() {
        mtn.add(new Mountain("Лонг-Рейндж",14255));
        mtn.add(new Mountain("Эльберт",14433));
        mtn.add(new Mountain("Марун",14156));
        mtn.add(new Mountain("Касл",14265));

        System.out.println("В порядке добавления:\n" + mtn);

        NameCompare nc = new NameCompare();
        Collections.sort(mtn,nc); //перегруженный метод sort, в который нужно передавать компоратор для явного указания поля для сортировки
        System.out.println("По названию:\n" + mtn);

        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn,hc);
        System.out.println("По высоте:\n" + mtn);

        Collections.sort(mtn); //для метода sort(list) нужно перегружать метод compareTo() в классе, объекты которого хранятся в list
        System.out.println("По названию (Comparable):\n" + mtn);

        // List<Mountain> sorted = mtn.stream().sorted(Comparator.comparing(v->v.name)).collect(toList());
    }
}
