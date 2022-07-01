package JavaRushTasks;

public class From10to2 {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        // int decimalNumber = -136;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        //  String binaryNumber = null;
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    /*** Один из алгоритмов перевода десятичного числа в представление двоичного числа следующий:
     while(десятичное число не равно 0) {
     двоичное представление = остаток от деления десятичного числа на 2 + двоичное представление
     десятичное число = десятичное число / 2
     }
     */
    public static String toBinary(int decimalNumber) {
        if (decimalNumber <= 0)  return "";
        String result = "";

        while(decimalNumber != 0) {
            result = (decimalNumber % 2) + result;
            decimalNumber = decimalNumber / 2;
        }
        return result;
    }

    /***
     Один из алгоритмов перевода представления двоичного числа в десятичное число следующий:
     for (int i = 0; i < длины двоичного представления; i++) {
     десятичное число = десятичное число + число из двоичного представления * на 2 в степени i
     }
     */
    public static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty()) return 0;

        int result = 0;
        char temp;
        int lenBinaryNumber = binaryNumber.length() - 1;
        for (int i = 0; i <= lenBinaryNumber; i++) {
            temp = binaryNumber.charAt(lenBinaryNumber - i);
            result = result + (temp == '0' ? 0 : 1) * (int) Math.pow(2,i);
        }
        return result;
    }
}
