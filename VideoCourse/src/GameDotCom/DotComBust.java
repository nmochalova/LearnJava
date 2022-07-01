package GameDotCom;

import java.io.IOException;
import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private  ArrayList<DotCom> dotComList = new ArrayList<DotCom>(); //ArrayList ТОЛЬКО объектов  DotCom
    private int numOfGuesses = 0;

    //Создание объектов DotCom и присвоения им имен и адресов.
    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");

        DotCom two = new DotCom();
        two.setName("eToys.com");

        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComList.add(one);
        dotComList.add(two);
        dotComList.add(three);

        System.out.println("Игра Морской бой.");
        System.out.println("Ваша цель - потопить три сайта: Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество ходов. Каждый сайт занимает 3 координаты.");
        System.out.println("Допустимые значения (по горизонтале): 0, 1, 2, 3, 4, 5, 6.");
        System.out.println("Допустимые значения (по вертикале): A, B, C, D, E, F, G.");
        System.out.println("Пример хода: A1, G5, B0, a1, g5, b0");

        for(DotCom dotComToSet : dotComList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    //Метод запрашивает у пользвоателя ход и вызывает метод CheckUserGuess, пока все объекты DotCom не выведены из игры
    public void startPlaying() throws IOException {
        while(!dotComList.isEmpty()) { //До тех пор пока список объектов DotCom не станет пустым
            String userGuess = helper.getUserInput("Сделайте ход ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
       numOfGuesses++;
       String result = "Мимо";

       for (DotCom dotComToTest : dotComList) {
           result = dotComToTest.checkYourself(userGuess);

           if (result.equals("Попал") || result.equals("Мимо")) {
               System.out.println(result);
                break;
           }
           if (result.equals("Потопил")) {
                dotComList.remove(dotComToTest);
                System.out.println(result);
                break;
           }
       }
    }

    private void finishGame() {
        System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
        if(numOfGuesses <=18 ) {
            System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
            System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
        }

    }


    public static void main (String[] args) throws IOException {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
