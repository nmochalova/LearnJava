package JavaRushTasks;

public class From8to10 {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    /***Один из алгоритмов перевода десятичного числа в восьмеричное следующий:
     * i равно 0
     * while(десятичное число не равно 0) {
     * восьмеричное число = восьмеричное число + (остаток от деления десятичного числа на 8) * на 10 в степени i
     * десятичное число = десятичное число / 8
     * i увеличиваем на 1
     * }
     */
    public static int toOctal(int decimalNumber) {
        if (decimalNumber <= 0) return 0;

        int i=0;
        int octalNumber = 0;
        while(decimalNumber != 0) {
            octalNumber = octalNumber + (decimalNumber % 8) * (int) Math.pow(10 ,i);
            decimalNumber = decimalNumber / 8;
            i++;
        }
        return octalNumber;
    }

    /***
     *Один из алгоритмов перевода восьмеричного числа в десятичное следующий:
     i равно 0
     while(восьмеричное число не равно 0) {
     десятичное число = десятичное число + (остаток от деления восьмеричного числа на 10) * на 8 в степени i
     восьмеричное число = восьмеричное число / 10
     i увеличиваем на 1
     }
     */
    public static int toDecimal(int octalNumber) {
        if (octalNumber <= 0) return 0;

        int i=0;
        int decimalNumber = 0;
        while(octalNumber != 0) {
            decimalNumber = decimalNumber + (octalNumber % 10) * (int) Math.pow(8 ,i);
            octalNumber = octalNumber / 10;
            i++;
        }
        return decimalNumber;
    }
}
