package JavaRushExamples;

import org.junit.Test;

public class ArrayUnitTest {
    @Test
    public void genDataBigChetnoe() {
        System.out.println("===== Тест: сумма четных больше =====");
        int[] testData = new int[15];
        for(int i=0; i<15; i++) {
            if (i % 2 == 0) {
                testData[i] = i+100; //если четное, то прибавляем 100
            } else {
                testData[i] = i; //если нечетное, то оставляем маленькое
            }
        }
        for(int i=0;i<testData.length;i++) {
            System.out.println(i+ " : "+testData[i]);
        }
       example(testData);

    }

    @Test
    public void genDataBigNechetnoe() {
        System.out.println("===== Тест: сумма нечетных больше =====");
        int[] testData = new int[15];
        for(int i=0; i<15; i++) {
            if (i % 2 == 0) {
                testData[i] = i; //если четное, то оставляем маленькое
            } else {
                testData[i] = i+100; //если нечетное, то прибавляем 100
            }
        }
        for(int i=0;i<testData.length;i++) {
            System.out.println(i+ " : "+testData[i]);
        }
        example(testData);
    }

    private void example(int[] testArray) {
        //Программа должна создавать массив и инициализировать его значением new int[15].
        int[] houses = new int[15];
       //  Scanner scanner = new Scanner(System.in);
        //Программа должна считывать числа для массива с клавиатуры.
        //Пускай индекс элемента массива является номером дома, а значение — числом жителей, проживающих в доме.
        for (int numberOfHouse = 0; numberOfHouse < houses.length; numberOfHouse++) {
           // houses[numberOfHouse] = scanner.nextInt();
           houses[numberOfHouse] = testArray[numberOfHouse];
        }
        //Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой.
        // Выяснить, на какой стороне улицы проживает больше жителей.
        int residentsOfEvenHouse = 0; //жители четных домов
        int residentsOfOddHouse = 0; //жители нечетных домов

        //дом с порядковым номером 0 считать четным.
        for (int numberOfHouse = 0; numberOfHouse < houses.length; numberOfHouse++) {
            //Если остаток от деления равен нулю, число четное, если равен единице — нечетное.
            if (numberOfHouse % 2 == 1) {
                residentsOfOddHouse = residentsOfOddHouse + houses[numberOfHouse]; //нечетное
            } else {
                residentsOfEvenHouse = residentsOfEvenHouse + houses[numberOfHouse]; //четное
            }
        }

        //Вывести на экран сообщение: "В домах с нечетными номерами проживает больше жителей."
        // или "В домах с четными номерами проживает больше жителей."
        //Программа не должна выводить текст в консоль, если количество жителей на каждой стороне - одинаковое.
        if (residentsOfOddHouse > residentsOfEvenHouse) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else if (residentsOfOddHouse < residentsOfEvenHouse) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
    }
}
