package JavaRushExamples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Work\\JavaRush\\log.txt";
        try(FileOutputStream output = new FileOutputStream(path))
        {
            output.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
