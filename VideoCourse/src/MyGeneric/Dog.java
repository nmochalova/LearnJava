package MyGeneric;

public class Dog extends Animal implements Pet{
    public void bark() {
        System.out.println("Гав-гав");
    }

    @Override
    public void beFriendly() {
        System.out.println("Вилять хвостом");
    }
}
