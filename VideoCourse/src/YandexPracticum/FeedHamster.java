package YandexPracticum;

public class FeedHamster {

    public static void main(String[] args) {
        String catPixel = "Пиксель";
        double[] feedExpensesCat = {100.50, 236.0, 510.6, 150.20, 80.0, 172.0, 135.4};
        sayHello(catPixel);
        System.out.println("Твой самый дорогой корм стоил " + findMaxExpense(feedExpensesCat));
        System.out.println("Всего на корм было потрачено " + findExpensesSum(feedExpensesCat));
        sayEnjoyMeal(catPixel);

        System.out.println("         ");

        String humsterByte = "Байт";
        double[] feedExpensesHamster = {70.50, 146.0, 710.6, 250.20, 83.0, 19.0, 55.4};
        sayHello(humsterByte);
        System.out.println("Твой самый дорогой корм стоил " + findMaxExpense(feedExpensesHamster));
        System.out.println("Всего на корм было потрачено " + findExpensesSum(feedExpensesHamster));
        sayEnjoyMeal(humsterByte);
    }

    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void sayEnjoyMeal(String name) {
        System.out.println("Приятного аппетита, " + name + "!");
    }

    public static double findMaxExpense(double[] feedExpenses) {
        double maxFeedExpense = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            if (feedExpenses[i] > maxFeedExpense) {
                maxFeedExpense = feedExpenses[i];
            }
        }
        return maxFeedExpense;
    }

    public static double findExpensesSum(double[] feedExpenses) {
        double sumFeedCat = 0;
        for (int i = 0; i < feedExpenses.length; i++) {
            sumFeedCat = sumFeedCat + feedExpenses[i];
        }
        return sumFeedCat;
    }
}
