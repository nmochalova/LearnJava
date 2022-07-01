package JavaRushExamples;

import java.io.*;

public class BufferWriterTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //поток для чтения данных с экрана

        String reader = bufferedReader.readLine();
        String path = reader;   //C:\Work\JavaRush\log.txt

        BufferedWriter writter = new BufferedWriter(new FileWriter(path));

        while (!reader.equals("exit")) {
            reader = bufferedReader.readLine();
            writter.write(reader + "\n");
        }

        writter.close();
        bufferedReader.close();
    }
}
