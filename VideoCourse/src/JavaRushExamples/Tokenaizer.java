package JavaRushExamples;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Tokenaizer {
    public static void main(String[] args) {
        String string = "Кто желает поработать?";
        int getWordCount = getWordCount(string);
        System.out.println("Количество слов в строке \"" + string + "\" равно " + getWordCount);


        System.out.println(Arrays.toString(map("2001:db8:11a3:9d7:1f34:8a2e:7a0:765d")));
    }

    public static int getWordCount(String string) {
        int count=0;
        StringTokenizer tokenizer = new StringTokenizer(string," ");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
            count++;
        }
        return count;
    }

    public static String[] map(String ipv6) {
        StringTokenizer tokenizer = new StringTokenizer(ipv6,":");
        int i=0;
        String[] strings = new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()) {
            strings[i] = tokenizer.nextToken();
            i++;
        }
        return strings;
    }
}
