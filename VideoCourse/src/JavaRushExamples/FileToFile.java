package JavaRushExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Работа с несколькими внешними ресурсами одновременно
 */
public class FileToFile {
    public static void main(String[] args) throws IOException {
        copyFileToFileByByte();
        copyFileToFileByByteArray();
    }

    //Копирование из файла в файл по одному байту.
    public static void copyFileToFileByByte() {
        String src = "c:\\projects\\log.txt";
        String dest = "c:\\projects\\copy.txt";

        try(FileInputStream input = new FileInputStream(src);

            FileOutputStream output = new FileOutputStream(dest))
        {
            byte[] buffer = input.readAllBytes();
            output.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Копирование из файла в файл одним куском.
    public static void copyFileToFileByByteArray() throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/Work/JavaRush/log.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/Work/JavaRush/result.txt");

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[1000];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}
