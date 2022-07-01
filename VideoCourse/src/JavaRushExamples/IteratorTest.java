package JavaRushExamples;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    /***
     *
     Класс Iterator отвечает за безопасный проход по списку элементов.

     Он достаточно прост, поскольку имеет всего 3 метода:
     hasNext() — возвращает true или false в зависимости от того, есть ли в списке следующий элемент, или мы уже дошли до последнего.
     next() — возвращает следующий элемент списка
     remove() — удаляет элемент из списка
     */
    public static void main(String[] args) {
            ArrayList<String> cats = new ArrayList<>();
            cats.add("Томас");
            cats.add("Бегемот");
            cats.add("Филипп Маркович");
            System.out.println(cats);

            Iterator<String> catIterator = cats.iterator();//создаем итератор
            while(catIterator.hasNext()) {//до тех пор, пока в списке есть элементы

            String nextCat = catIterator.next();//получаем следующий элемент
            if (nextCat.equals("Филипп Маркович")) {
                catIterator.remove();//удаляем кота с нужным именем
            }
        }

        System.out.println(cats);
    }


}
