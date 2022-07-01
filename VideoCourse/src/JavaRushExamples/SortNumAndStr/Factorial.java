package JavaRushExamples.SortNumAndStr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/*
Факториал
Напиши метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа, включая его.

Пример вычислений: 4! = factorial(4) = 1*2*3*4
Пример вывода: 24
 */
public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if (n < 0) return "0";
        if (n == 0) return "1";
        BigDecimal bd = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            bd = bd.multiply(new BigDecimal(i));
        }

        return bd.toString();
    }
}
