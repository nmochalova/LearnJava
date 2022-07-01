package JavaRushExamples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:

Первая строка содержит только гласные буквы из введённой строки.
Вторая — только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
 */
public class SoglasnAndGlasn {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        String consonantsText = "";
        String vowelsText = "";

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (letter != ' ')
                if (isVowel(letter)) vowelsText += letter + " ";
                else consonantsText += letter + " ";
        }

        System.out.println(vowelsText);
        System.out.println(consonantsText);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}
