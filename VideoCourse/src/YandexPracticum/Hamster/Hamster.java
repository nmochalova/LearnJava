package YandexPracticum.Hamster;

public class Hamster {

    String name;  // Имя
    int age;      // Возраст
    int weight;   // Вес в граммах
    String color; // Цвет

    Hamster(String hamsterName, int hamsterAge, int hamsterWeight, String hamsterColor) {
        name = hamsterName;
        age = hamsterAge;
        weight = hamsterWeight;
        color = hamsterColor;
    }

    // Методы
    void eat(int foodWeight) {
        weight = weight + foodWeight;
    }

    // Бегать в колесе
    void runInWheel() {
        System.out.println("Бегу-бегу-бегу!");
        weight = weight - 5;
    }

    // Прятать семечки
    void hideSeeds(int seedWeight) {
        System.out.println("Зимой не заголодаю.");
        weight = weight + seedWeight;
    }
}