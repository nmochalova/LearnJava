package JavaRushExamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SortPuzirek {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        int counter = 1;
        int len = array.length;

        while (counter > 0) {
            counter=0;
            for (int i = 0; i < len-1; i++) {
                if(array[i] < array[i+1]) { //сортировка методом пузырька
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    counter++;
                }
            }
        }
    }
}
