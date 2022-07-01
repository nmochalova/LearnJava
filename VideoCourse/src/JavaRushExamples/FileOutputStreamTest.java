package JavaRushExamples;

import java.io.*;
import java.util.Scanner;

public class FileOutputStreamTest {
    public static void main(String[] args) throws Exception {
        readNextCharacter();
        readNextLine();
    }

    public static void readNextCharacter() throws Exception {
        BufferedReader pathReader = new BufferedReader(new InputStreamReader(System.in)); //поток для чтения данных с экрана

        String path = pathReader.readLine();                                //переменная для чтения данных с экрана

        FileInputStream inputStream = new FileInputStream(path);            //поток для чтения файла
        BufferedInputStream buffer = new BufferedInputStream(inputStream);  //запоминаем прочитанное в буфер
        while (buffer.available() > 0) {                                //пока в файле есть непрочитанные данные
            char c = (char) buffer.read();                              //читаем по символу преобразуем в char
            System.out.print(c);
        }
        inputStream.close();                                                //закрываем потоки
        buffer.close();
        pathReader.close();
    }

    public static void readNextLine() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        System.out.print(builder.toString());

        scanner.close();
        reader.close();
    }
}
