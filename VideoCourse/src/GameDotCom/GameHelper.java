package GameDotCom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLenght = 7;
    private int gridSize = 49;
    private  int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) throws IOException {

        String inputLine = null;
        System.out.println(prompt + " ");

        BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));

        inputLine = is.readLine();

        if (inputLine.length() == 0) {
            return null;
        }
        return inputLine.toLowerCase();
        }


    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoors = new String[comSize];              //хранит координаты тип f6
        String temp = null;                                     //временная строка для конкатенации
        int[] coords = new int[comSize];                        //координаты текущего сайта
        int attempts = 0;                                       //счетчик текущих попыток
        boolean success = false;                                //нашли подходящее местоположение?
        int location = 0;                                       //текущее начальное положение

        comCount++;
        int incr = 1;                                           //устанавливаем горизонатльный инкремент
        if ((comCount % 2) == 1) {                              //если нечетный (размещаем вертикально)
            incr = gridLenght;                                  //устанавливаем вертикальный инкремент
        }

        //главный поисковый цикл
        while ( !success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
        //    System.out.print(" Пробуем " + location);
            int x = 0;
            success = true;

            while (success && x < comSize) {                    //ищем соседнюю неиспользованную ячейку
                if (grid[location] == 0) {                      //еще не используется
                    coords[x++] = location;                     //сохраняем местоположение
                    location += incr;                           //пробуем следующую соседнюю ячейку
                    if (location >= gridSize) {                 //вышли за рамки - низ
                        success = false;                        //неудача
                    }
                    if (x>0 && (location % gridLenght == 0)) {  //Вышли за рамки - правый край
                        success = false;                        //неудача
                    }
                } else {                                        //нашли уже использующееся местоположение
            //        System.out.print("Используется " + location);
                    success = false;                            //неудача
                }
            }
        }

        //Переводим местоположение в символьные координаты
        int x = 0;
        int row = 0;
        int column = 0;
    //    System.out.println("\n");

        while (x < comSize) {
            grid[coords[x]] = 1;                                //Помечаем ячейки на главной сетке как "Использованные"
            row = (int) (coords[x] / gridLenght);               //Получаем значение строки
            column = coords[x] % gridLenght;                    //Получаем числовое значение стобца
            temp = String.valueOf(alphabet.charAt(row));     //Преобразуем его в строковый символ

            alphaCells.add(temp.concat(Integer.toString(column)));
            x++;
           // System.out.print("  coord_" + x + "=" + alphaCells.get(x-1));
        }

        System.out.println("  " + alphaCells);
        return alphaCells;
    }

}

