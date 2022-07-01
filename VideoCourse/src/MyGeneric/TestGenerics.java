package MyGeneric;

import java.util.ArrayList;

public class TestGenerics {
    public static void main(String[] args) {
        new TestGenerics().go();
    }

    private void go() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        takeAnimals(animals);

        System.out.println();
        ArrayList<Dog> dogArrayList = new ArrayList<Dog>();
        dogArrayList.add(new Dog());
        dogArrayList.add(new Dog());
        makeAnimals(dogArrayList);
        PetAnimals(dogArrayList);

        System.out.println();
        ArrayList<Cat> catArrayList = new ArrayList<Cat>();
        catArrayList.add(new Cat());
        catArrayList.add(new Cat());
        catArrayList.add(new Cat());
        newMakeAnimals(dogArrayList, catArrayList);
    }

    //<?> - это заполнитель, он ограничивает действия с ArrayList для всех полиморфных типов Animal
    //<? extends Animal> - означает, что метод принимает тип Animal и всех его потомков и разрешает манипуляцию с ними (просмотр списка, вызов методов)
    //кроме добавления нового элемента (add не допустим)
    private void takeAnimals(ArrayList<? extends Animal> animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }

    private <T extends Animal> void makeAnimals(ArrayList<T> one) {
       for (Animal d : one) {
            if (d instanceof Dog) {
                ((Dog) d).bark();
            } else {
                d.eat();
            }
        }
    }

  // private <T extends Animal> void newMakeAnimals(ArrayList<T> one, ArrayList<T> two) {
   private void newMakeAnimals(ArrayList<? extends Animal> one, ArrayList<? extends Animal> two) {
        for (Animal d : one) {
            d.eat();
        }
        for (Animal c : two) {
            c.eat();
        }
    }

    //для интерфейса Pet
    private <T extends Pet> void PetAnimals(ArrayList<T> one) {
        for (Pet d : one) {
            d.beFriendly();
        }
    }
}
