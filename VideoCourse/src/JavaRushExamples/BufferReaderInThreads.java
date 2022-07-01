package JavaRushExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BufferReaderInThreads {
    public static volatile AtomicInteger readStringCount = new AtomicInteger(0);
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //read count of strings
        int count = Integer.parseInt(reader.readLine());

        //init threads
        ReaderThread consoleReader1 = new ReaderThread();
        ReaderThread consoleReader2 = new ReaderThread();
        ReaderThread consoleReader3 = new ReaderThread();

        consoleReader1.start();
        consoleReader2.start();
        consoleReader3.start();

        while (count > readStringCount.get()) {
        }

        consoleReader1.interrupt();
        consoleReader2.interrupt();
        consoleReader3.interrupt();
        System.out.println("#1:" + consoleReader1);
        System.out.println("#2:" + consoleReader2);
        System.out.println("#3:" + consoleReader3);

        reader.close();
    }

    public static class ReaderThread extends Thread {
        private List<String> result = new ArrayList<String>();

//        public void run() {
//            String newString;
//            try {
//                while (!Thread.currentThread().isInterrupted()) {
//                    newString = reader.readLine();
//                    if (!newString.isEmpty()) {
//                        result.add(newString);
//                        readStringCount.incrementAndGet();
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        //https://ru.stackoverflow.com/questions/732637/java-Как-правильно-использовать-bufferedreader-одновременно-несколькими-потока
        public void run() {
            while ( !Thread.currentThread().isInterrupted()){
                try {
                    synchronized (reader){                           //только для текущего потока
                        if (reader.ready()) {                       //готов ли поток к чтению
                            result.add(reader.readLine());          //если готов читаем
                            readStringCount.incrementAndGet();
                        }                                           //иначе уходим в while на проверку статуса isInterrupted
                    }
                }catch (IOException e){
                    System.out.println("*************error");
                }
            }
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}
