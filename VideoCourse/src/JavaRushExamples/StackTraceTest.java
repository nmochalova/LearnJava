package JavaRushExamples;

public class StackTraceTest {
    public static void main(String[] args)
    {
        method1();

        System.out.println("*****************");

        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
    }

    public static void method1()
    {
        method2();
    }

    public static void method2()
    {
        method3();
    }

    public static void method3()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            System.out.println(element.getMethodName());
        }
    }

}
