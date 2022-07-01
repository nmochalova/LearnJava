package otus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiDemo {
    private static List<Student> getStudentList() {
        return new ArrayList<>(Arrays.asList(
                new Student(1,"Ola",20,Course.JAVA_QA),
                new Student(2,"Pety",30,Course.PYTHON_QA),
                new Student(3,"Masha",40,Course.MANUAL_QA),
                new Student(4,"Misha",50,Course.MANUAL_QA),
                new Student(5,"Dasha",33,Course.JAVA_QA),
                new Student(6,"Ola",27,Course.JAVA_QA),
                new Student(7,"Vasja",41,Course.PYTHON_QA),
                new Student(8,"Dima",38,Course.JAVA_QA),
                new Student(9,"Ola",19,Course.JAVA_QA),
                new Student(10,"Evlampii",34,Course.MANUAL_QA)
        ));
    }

    public static void main(String[] args) {
        //Уникальные имена студентов которые учатся на курсе Java, отсортированные по возрасту
        var names = getStudentList().stream()
                .filter(student -> student.getCourse().equals(Course.JAVA_QA)) //отфильтровали всех студентов, кот.не учатся на JAVA_QA
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())                 //отсортировали по убыванию
                .map(student -> student.getName())                            //берем имена
                .distinct()                                                   //получение уникальных имен
                .limit(10)                                              //берем первые 10 из выборки
                .filter(it -> it.length() > 3)                                 //отсекаем все имена длиной меньше 3 букв
                .collect(Collectors.toList());                                //Упаковываем в коллектор для List

        System.out.println(names);

        //Терминальный оператор .findFirst() - найди первого, кто удовлетв.условию. Для параллельных стримо лучше использовать .findAny()
        var nameParallel = getStudentList().parallelStream()        //параллельные стримы
                .filter(student -> student.getCourse().equals(Course.JAVA_QA))
                .sorted((s1, s2) -> s2.getAge() - s1.getAge())
                .map(student -> student.getName())
                .distinct()
                .limit(10)
                .filter(it -> it.length() > 3)
                .findAny();                                                   //любой эл-т который удовлетв.условиях

    }
}
