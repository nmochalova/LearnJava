package JavaRushExamples;

import java.util.Scanner;

public class NOD {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if ((a<0) || (b<0))
            throw new IllegalArgumentException();

        while (a!=b) {
            if (a > b) a = a-b;
            else b=b-a;
        }

        System.out.println(a);
    }
}
