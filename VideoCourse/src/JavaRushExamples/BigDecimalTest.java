package JavaRushExamples;

import java.math.BigDecimal;

public class BigDecimalTest {
    private BigDecimal balance;
    private String owner;

    public BigDecimalTest(String owner) {
        this(BigDecimal.ZERO, owner);
    }

    public BigDecimalTest(BigDecimal balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void deposit(BigDecimal money) {
        BigDecimal newBalance = balance.add(money);
        System.out.println("Добавляем " + money + ", на счету " + newBalance);
        balance = newBalance;
    }

    public synchronized void withdraw(BigDecimal money) throws RuntimeException {
        BigDecimal newBalance = balance.subtract(money);

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new RuntimeException();

        balance = newBalance;
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money)  {
        withdraw(new BigDecimal(money));
    }
}
