package JavaRushTasks;

public class From10to16 {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        int decimalNumber = 1256;
        System.out.println("Десятичное число " + decimalNumber + " равно шестнадцатеричному числу " + toHex(decimalNumber));
        String hexNumber =  "4e8";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно десятичному числу " + toDecimal(hexNumber));
    }

    /***
     Один из алгоритмов перевода десятичного числа в шестнадцатеричное следующий:
     while(десятичное число не равно 0) {
     представление шестнадцатеричного числа = символ из строки HEX с индексом, равным остатку от деления десятичного числа на 16
     + представление шестнадцатеричного числа
     десятичное число = десятичное число / 16
     }
     */
    public static String toHex(int decimalNumber) {
        if (decimalNumber <= 0)  return "";
        String hexNumber = "";   //представление шестнадцатеричного числа
        int remainder;           //остаток от деления
        char symbolHEX;          //символ из строки HEX

        while (decimalNumber != 0) {
            remainder = (decimalNumber % 16);
            symbolHEX = HEX.charAt(remainder);
            hexNumber = symbolHEX + hexNumber;
            decimalNumber = decimalNumber / 16;
        }
        return hexNumber;
    }

    /***
     Один из алгоритмов перевода шестнадцатеричного числа в десятичное следующий:
     for (int i = 0; i < длина входящей строки; i++) {
     десятичное число = 16 * десятичное число + индекс символа из строки HEX, равного символу из входящей строки с индексом i
     }
     */
    public static int toDecimal(String hexNumber) {
        if (hexNumber == null || hexNumber.isEmpty()) return 0;
        int decimalNumber = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            int hexIndex = Character.getNumericValue(hexNumber.charAt(i));
            decimalNumber = 16 * decimalNumber + hexIndex;
        }
        return decimalNumber;
    }
}
