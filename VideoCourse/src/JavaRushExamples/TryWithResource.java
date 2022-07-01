package JavaRushExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Сокращаем try
*/
public class TryWithResource {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            System.out.println(line.toLowerCase());
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}
