package YandexPracticum.LearnJava;

public class TestBox {
    Integer i; //null
    int j;     //0

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    public void go() {
        i=j;
        System.out.println(i);
        System.out.println(j);
    }
}
