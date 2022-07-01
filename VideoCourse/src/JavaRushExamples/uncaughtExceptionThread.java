package JavaRushExamples;

public class uncaughtExceptionThread {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {

        //обработка runtime исключений в конструкторе. Настройка поведения обработчика для выбранного потока.
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler); //прописываем в переменную uncaughtExceptionHandler явный обработчик не перехваченных исключений этого потока.
            start(); //запускаем поток
        }

        public void run() {
            Thread.setDefaultUncaughtExceptionHandler(handler);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) { //кидаем исключение типа RuntimeException, которые не требуют чтобы их обрабатывали, но мы обработаем
                throw new RuntimeException("My exception message");
            }
        }
    }

    //UncaughtExceptionHandler - интерфейс для перехвата необработанных исключений возникающих в потоке.
    //Вызывается, когда поток внезапно завершается из-за не перехваченного исключения.
    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        //Реализуем обработчик в методе uncaughtException. Срабатывает перехватчик из переменной uncaughtExceptionHandler.
        @Override
        public void uncaughtException(Thread t, Throwable e) { //параметры: исключение и поток, в котором оно возникло.
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
