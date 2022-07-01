package JavaRushExamples;

public class ChekedUnchekedExeption {
    public static void main(String[] args) {
    }

    //checked-исключение наследуется от класса Exception. Нужно обрабатывать с помощью try..catch
    //Эти ошибки можно предсказать (отсуствие файла в директории и пр.)
    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

    static class MyException2 extends MyException {
        public MyException2(String message) {
            super(message);
        }
    }

    //unchecked-исключение наследуется от класса RuntimeException. Не обязательно обрабатывать с помощью try..catch
    //человеческие ошибки, предсказать нельзя (деление на ноль, выход за рамки массива и пр.)
    static class MyException3 extends RuntimeException{
    }

    static class MyException4 extends MyException3 {
    }
}
