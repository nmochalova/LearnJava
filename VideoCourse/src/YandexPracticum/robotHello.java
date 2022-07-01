package YandexPracticum;

import java.util.Scanner;

public class robotHello {
    public static void main(String[] args) {
       // printRobotHello();
       System.out.println(searchMax());
    }

    public static String searchMax() {
        String film1 = "Титаник";
        int income1 = 4194;

        String film2 = "Аватар";
        int income2 = 4194;

        String film3 = "Тёмный рыцарь";
        int income3 = 3084;

        // Напишите реализацию нового метода ниже
        if (income1 > income2) {
            if (income1 > income3) {
                return film1;
            } else if (income3 > income2) {
                return film3;
            } else {
                return film2;
            }
        } else if (income3 > income2) {
            return film3;
        } else {
            return film2;
        }
    }

    public static void printRobotHello() {
        Scanner scanner = new Scanner(System.in); // Спросите у пользователя "Который час?" и сохраните ответ в переменную currentHour
        System.out.println("Который час? Нажмите 33 для выхода.   "); // В зависимости от времени предусмотрите печать приветствий

        while (true) {
            int currentHour = scanner.nextInt();
            if (currentHour == 33) {
                break;
            }

            if (currentHour <= 0) {
                System.out.println("Такого времени нет");
                break;
            } else if (currentHour > 24) {
                System.out.println("Такого времени нет");
                break;
            }

            if (currentHour < 6) {
                System.out.println("Доброй ночи!");
            } else if (currentHour < 12) {
                System.out.println("Доброе утро!");
            } else if (currentHour < 18) {
                System.out.println("Добрый день!");
            } else if (currentHour > 22) {
                System.out.println("Доброй ночи!");
            } else {
                System.out.println("Добрый вечер!");
            }
        }
    }

}
