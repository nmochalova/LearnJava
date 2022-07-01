package JavaRushExamples;

import java.util.Arrays;

public class TwiceArray {
    public static void main(String[] args) {
        // Инициализация зубчатого массива со строками разной длины
        int[][] matrixZub = new int[2][];
        matrixZub[0] = new int[10];
        matrixZub[1] = new int[50];

        TwiceMatrix();
        multiMatrix();
    }

    //Вывод на экран двумерного массива
    private static void TwiceMatrix() {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3, 4, 5, 6};
        matrix[1] = new int[]{1, 2, 3};
        matrix[2] = new int[]{1};
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print( matrix[i][j] + " " );
            System.out.println();
        }
    }

    //Создание многомерного массива
    private static void multiMatrix() {
        int[][][][] matrix = new int[2][3][4][5];

        int[][][][] matrix_4;
        matrix_4 = new int[2][][][];                   // создаем массив «ссылок на ссылки на ссылки» длины 2
        for (int i = 0; i < matrix_4.length; i++)
        {
            matrix_4[i] = new int[3][][];                // создаем массив «ссылок на ссылки» длины 3
            for (int j = 0; j < matrix_4[i].length; j++)
            {
                matrix_4[i][j] = new int[4][];             // создаем массив ссылок длины 4
                for (int k = 0; k < matrix_4[i][j].length; k++)
                    matrix_4[i][j][k] = new int[5];          // создаем массивы целых чисел длины 5
            }
        }

        System.out.println(Arrays.deepToString(matrix_4));
    }
}
