package JavaRushExamples;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
Читаем данные из двух файлов в двух потоках и выводим содержимое файлов на экран
Ввод:
C:\Work\JavaRush\firstfile.txt
C:\Work\JavaRush\secondfile.txt
Вывод:
a b c
e f g 
 */

public class FilesInTwoTreads {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String filename;
        private String contentFile = "";

        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return this.contentFile;
        }

        @Override
        public void run() {
            try(FileInputStream input = new FileInputStream(filename);
                Scanner scanner = new Scanner(input)) {
                while (scanner.hasNextLine()) {
                    contentFile += scanner.nextLine() + " ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
