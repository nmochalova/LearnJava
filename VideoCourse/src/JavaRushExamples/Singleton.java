package JavaRushExamples;
//Класс является синглтоном (реализует паттерн Singleton), если позволяет создать всего один объект своего типа.
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
