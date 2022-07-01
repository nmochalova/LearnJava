package YandexPracticum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
Массив из чисел в обратном порядке
*/

public class JavaRush {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] numbers = new int[20];
        Scanner scanner = new Scanner(System.in);

        for (int i=0;i<numbers.length;i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] arrayOne = new int[10];
        int[] arrayTwo = new int[10];

        for (int k=0;k<numbers.length;k++) {
            if(k < 10 ) {
                arrayOne[k] = numbers[k];
            } else {
                arrayTwo[k-10] = numbers[k];
            }
        }

        for (int j=0;j<arrayTwo.length;j++) {
            System.out.println(arrayTwo[j]);
        }

    }
}