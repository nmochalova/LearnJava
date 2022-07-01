package JavaRushExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) throws IOException {
        arrayStringPrintRevert();
    }

    //Ввод 10 строк с клавиатуры
    private static void readLineString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[10];

        for (int i = 0; i < list.length; i++)
        {
            list[i] = reader.readLine();
        }
    }

    //Ввод 10 чисел с клавиатуры
    private static void readLineInt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[10];

        for (int i = 0; i < list.length; i++)
        {
            String s = reader.readLine();
            list[i] = Integer.parseInt(s);
        }
    }

    //Заполнение массива из 10 чисел, числами от 1 до 10:
    private static void arrayOneToTen() {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i + 1;
        }
    }

    //Заполнение массива из 10 чисел, числами от 10 до 1
    private static void arrayTenToOne() {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = 10 - i;
        }
    }

    //Заполнение массива из 10 чисел, числами от 0 до 9:
    private static void arrayZeroToNine() {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = i;
        }
    }

    //Заполнение массива из 10 чисел, числами от 9 до 0
    private static void arrayNineToZero() {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = 9 - i;
        }
    }

    //Вывод массива на экран
    private static void printArray() {
        {
            int[] list = new int[10];

            //заполнение массива
            for (int i = 0; i < list.length; i++) {
                list[i] = i;
            }

            //вывод на экран
            for (int i = 0; i < list.length; i++) {
                System.out.println(list[i]);
            }
        }
    }

    //Быстрая (статическая) инициализация. Сумма элементов массива:
    private static void sumArray() {
        //это статическая инициализация
        int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

        //подсчёт суммы элементов
        int sum = 0;
        for (int i = 0; i < list.length; i++)
        {
            sum += list[i];
        }

        System.out.println("Sum is " + sum);
    }

    //Поиск минимального элемента в массиве
    private static void minArray() {
        int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

        int min = Integer.MAX_VALUE; //list[0];
        for (int i = 1; i < list.length; i++)
        {
            if (list[i] < min)
            {
                min = list[i];
            }
        }

        System.out.println ("Min is " + min);
    }

    //Ввод и вывод массива
    private static void PutInputArray() {
        Scanner scanner = new Scanner(System.in);
        int personCount = 5;
        String[] person = new String[personCount];
        int[] salary = new int[personCount];

        for(int i = 0; i < person.length; i++) {
            person[i] = scanner.next();
        }

        for(int i = 0; i < salary.length; i++) {
            System.out.println("Input salary for " + person[i] + ":");
            salary[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(person));
        for (int value : salary) {
            System.out.print(value + ", ");
        }
        System.out.println();
    }

    /***
     * Создать массив на 10 строк.
     * Ввести с клавиатуры 8 строк и сохранить их в массив.
     * Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент — с новой строки.
     */
    private static void arrayStringPrintRevert() {
        //напишите тут ваш код
        String[] names = new String[10];

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<8;i++) {
            names[i] = scanner.next();
        }

        for(int i=9;i>=0;i--) {
            System.out.println(names[i]);
        }
    }

    /***
     *Один большой массив и два маленьких
     * Создать массив на 20 чисел.
     * Ввести в него значения с клавиатуры.
     * Создать два массива на 10 чисел каждый.
     * Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
     * Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
     */
    private static void oneBigArrayAndTwoSmall() {
        // Создать массив на 20 чисел.
        int[] longArray = new int[20];
        // Ввести в него значения с клавиатуры.
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<20;i++) {
            longArray[i] = scanner.nextInt();
        }
        //Создать два массива на 10 чисел каждый.
        int[] shortArrayFirst = new int[10];
        int[] shortArraySecond = new int[10];
        //Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
        for(int i=0;i<10;i++) {
            shortArrayFirst[i] = longArray[i];
        }
        for(int i=10;i<20;i++) {
            shortArraySecond[i-10] = longArray[i];
        }
        //Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
        for(int i=0;i<10;i++) {
            System.out.println(shortArraySecond[i]);
        }
    }
}
