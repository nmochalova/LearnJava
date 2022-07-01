package JavaRushExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.
 */
public class FileInputStreamTest {
    public static List<String> lines = new ArrayList<String>();
    public static String FILE_NAME = "C:\\Work\\JavaRush\\log.txt";

    static {
        try(FileInputStream input = new FileInputStream(FILE_NAME);
            Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
