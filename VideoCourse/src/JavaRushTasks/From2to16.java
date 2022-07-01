package JavaRushTasks;

import java.util.HashMap;
import java.util.regex.Pattern;

public class From2to16 {
    public static final HashMap<Character,String> hexToBinary = new HashMap<>();
    public static final HashMap<String,String> binaryToHex = new HashMap<>();

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    /***
     Один из алгоритмов перевода строкового представления двоичного числа в строковое представление шестнадцатеричного числа следующий:

     Проверяем длину строки, полученной входящим параметром. Она должна быть кратна 4.
     Если это не так, то добавляем нужное количество 0 в начало строки.
     Берем каждые четыре символа (бита) и проверяем, какому символу шестнадцатеричной кодировки он соответствует.
     */
    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty() || !Pattern.matches("[0-1]+", binaryNumber)) return "";

        getBinaryToHex();

        String hexNumber = "";
        while (binaryNumber.length() % 4 != 0) {
            binaryNumber = "0" + binaryNumber;
        }
        int len = binaryNumber.length();

        for (int i = 0; i < len; i+=4) {
            hexNumber += binaryToHex.get(binaryNumber.substring(i,i+4));
        }

        return hexNumber;
    }

    /***
     * Один из алгоритмов перевода строкового представления шестнадцатеричного числа в строковое представление двоичного числа следующий:
     * Берем каждый символ и проверяем какому двоичному числу (4 бита) он соответствует.
     */
    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.isEmpty() || !Pattern.matches("[0-9a-f]+", hexNumber)) return "";

        getHexToBinary();

        String binaryNumber = "";
        for (int i = 0; i < hexNumber.length(); i++) {
            binaryNumber += hexToBinary.get(hexNumber.charAt(i));
        }
        return binaryNumber;
    }

    private static void getHexToBinary() {
        hexToBinary.put('0',"0000");
        hexToBinary.put('1',"0001");
        hexToBinary.put('2',"0010");
        hexToBinary.put('3',"0011");
        hexToBinary.put('4',"0100");
        hexToBinary.put('5',"0101");
        hexToBinary.put('6',"0110");
        hexToBinary.put('7',"0111");
        hexToBinary.put('8',"1000");
        hexToBinary.put('9',"1001");
        hexToBinary.put('a',"1010");
        hexToBinary.put('b',"1011");
        hexToBinary.put('c',"1100");
        hexToBinary.put('d',"1101");
        hexToBinary.put('e',"1110");
        hexToBinary.put('f',"1111");
    }

    private static void getBinaryToHex() {
        binaryToHex.put("0000","0");
        binaryToHex.put("0001","1");
        binaryToHex.put("0010","2");
        binaryToHex.put("0011","3");
        binaryToHex.put("0100","4");
        binaryToHex.put("0101","5");
        binaryToHex.put("0110","6");
        binaryToHex.put("0111","7");
        binaryToHex.put("1000","8");
        binaryToHex.put("1001","9");
        binaryToHex.put("1010","a");
        binaryToHex.put("1011","b");
        binaryToHex.put("1100","c");
        binaryToHex.put("1101","d");
        binaryToHex.put("1110","e");
        binaryToHex.put("1111","f");
    }
}
