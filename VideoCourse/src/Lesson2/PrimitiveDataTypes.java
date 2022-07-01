package Lesson2;

public class PrimitiveDataTypes {
    public static void main(String[] args) {
        System.out.println("========== 1. Целочисленные типы ===========");
        System.out.println("Переменные типа byte в разных системах исчисления");
        byte a1 = 0b1100; //начинается с 0b
        System.out.println("2-ичная " + a1);
        byte a2 = 014; //начинается с 0
        System.out.println("8-ичная " + a2);
        byte a3 = 12;
        System.out.println("10-ичная " + a3);
        byte a4 = 0xC; //начинается с 0x
        System.out.println("16-ичная " + a4);

        System.out.println("Переменные типа short в разных системах исчисления");
        short b1 = 0b0101_0001_0100;
        System.out.println("2-ичная " + b1);
        short b2 = 02424;
        System.out.println("8-ичная " + b2);
        short b3 = 1300;
        System.out.println("10-ичная " + b3);
        short b4 = 0x514;
        System.out.println("16-ичная " + b4);

        System.out.println("Переменные типа int в разных системах исчисления");
        int c1 = 0b0;
        System.out.println("2-ичная " + c1);
        int c2 = 00;
        System.out.println("8-ичная " + c2);
        int c3 = 0;
        System.out.println("10-ичная " + c3);
        int c4 = 0x0;
        System.out.println("16-ичная " + c4);

        System.out.println("Переменные типа long в разных системах исчисления");
        long d1 = 0b0111_0101_1011_1100_1101_0001_0101;
        System.out.println("2-ичная " + d1);
        long d2 = 0726_746_425;
        System.out.println("8-ичная " + d2);
        long d3 = 123456789;
        System.out.println("10-ичная " + d3);
        long d4 = 0x75B_CD15;
        System.out.println("16-ичная " + d4);

        System.out.println("========== 2. Вещественные и логические типы ===========");
        float f1 = 0.00000503538787098702452F;
        System.out.println("float " + f1);
        float f2 = 50_000_000F;
        System.out.println("float " + f2);

        double db1 = 0.00000000000000000000000000000000000000001d;
        System.out.println("double " + db1);
        double db2 = 1000000000000000000000000000000000000000000000d;
        System.out.println("double " + db2);

        boolean bl1 = true;
        System.out.println("boolean " + bl1);
        boolean bl2 = false;
        System.out.println("boolean " + bl2);

        System.out.println("========== 3. Символьный тип ===========");
        char ch1 = 'A';
        System.out.println("char " + ch1);
        char ch2 = 105;
        System.out.println("char " + ch2);
        char ch3 = '\u0555'; //16-ричная система исчисления, начинается с
        System.out.println("char " + ch3);
    }
}
