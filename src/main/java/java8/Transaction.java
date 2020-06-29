package java8;

import java.time.temporal.TemporalAmount;

/**
 * Transaction
 *
 * @author Alicia
 * @description
 * @date 2020/6/28
 */
public class Transaction {

    private Trader trader;
    private int year;
    private int amount;

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Transaction(){}

    public Transaction(Trader trader, int year, int amount) {
        this.trader = trader;
        this.year = year;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader='" + trader + '\'' +
                ", year=" + year +
                ", amount=" + amount +
                '}';
    }
}
