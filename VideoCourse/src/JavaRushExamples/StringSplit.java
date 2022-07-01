package JavaRushExamples;

import java.util.Arrays;

public class StringSplit {
    public static void main(String[] args) {
        String string = "Кто желает поработать?";
        int getWordCount = getWordCount(string);
        System.out.println("Количество слов в строке \"" + string + "\" равно " + getWordCount);
    }

    public static int getWordCount(String string) {
        String[] strings = string.split(" ");
        System.out.println(Arrays.toString(strings));
        return strings.length;
    }
}
