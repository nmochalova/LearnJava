package otus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateTestDataDemo {
    public static void main(String[] args) throws IOException {
   //      generateTestUsers();
         readUsers();
    }

//    void testSample() throws IOException {
//        //генерим юзеров и сохраняем в базу
//        var users = generateTestUsers();
//
//        //отсечь все id
//        var usersIds = users.stream().map(it -> it.getId()).collect(Collectors.toList());
//
//        //выполняем тест - отправляем все id в запрос на получение юзеров по id
//        var response = httpClient.sendRequest(usersIds);
//
//        Assertions.assertEquals(users, response.getBody());
//    }

    //читаем данные из файла
    private static void readUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        var testData = readFromDisk(objectMapper);
        System.out.println(1);
    }

    private static List<Student> readFromDisk(ObjectMapper objectMapper) throws IOException {
        return objectMapper.readValue(new File("./students-data.json"), new TypeReference<List<Student>>() {});
    }

    //нагенерим пользователей
    private static List<Student> generateTestUsers() throws IOException {
        List<Student> studentList =
                IntStream.range(100,200).mapToObj(x -> {               //сгенерить 100 пользователей, мапим на ссылочный объект
                    Course course;

                    if (x % 3 == 0) { //если х делится без остатка на 3, то будет JAVA_QA
                        course = Course.JAVA_QA;
                    } else {
                        if (x > 150) {
                            course = Course.PYTHON_QA;
                        } else {
                            course = Course.MANUAL_QA;
                        }
                    }

                    var age = (int) (Math.random() * (80 - 15) + 15); //генерим возраст от 15 до 80 лет
                    return new Student(x, "Student_" + x, age,course);
                     }).collect(Collectors.toList());

        //Генерация в файл. С помощью библиотеки Jackson Databind 2.13.1 (см.зависимости)
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./students-data.json"),studentList);

        return studentList;
    }
}
