package JavaRushExamples;

public class logging {
    public static void main(String[] args) {
        log("In method");
    }

    public static void log(String text) {
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        String className = element[2].getClassName(); //имя класса, из которого вызван метод
        String methodName = element[2].getMethodName(); //имя метода, в котором вызывается метод log
        int numberString = element[2].getLineNumber(); //номер строки, их которой вызывается метод log

        System.out.println(className + ": " + methodName + ": " + numberString  + ": " +  text);
    }
}
