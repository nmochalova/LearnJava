package JavaRushExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomCount {

    //случайный элемент
    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    // ходим по кругу от 1 стола к 10
    public void getNextTable() {
        int currentIndex = 0;
        currentIndex = (currentIndex + 1) % 10;
        System.out.println(currentIndex);
    }

    //случайный элемент из коллекции
    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (DrugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(DrugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    public static class Drug {
        private String name;
        public void setName(String name) {
            this.name = name;
        }
    }

    public static class DrugsController {
        public static Map<Drug, Integer> allDrugs = new HashMap<Drug, Integer>();   // <Лекарство, Количество>

        static {
            Drug panadol = new Drug();
            panadol.setName("Панадол");
            allDrugs.put(panadol, 5);

            Drug analgin = new Drug();
            analgin.setName("Анальгин");
            allDrugs.put(analgin, 18);

            Drug placebo = new Drug();
            placebo.setName("Плацебо");
            allDrugs.put(placebo, 1);
        }
    }
    }
