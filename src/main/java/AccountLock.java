import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by fifi on 2017/2/19.
 */
public class AccountLock {
    private Lock accountLock = new ReentrantLock();
    private double balance;

    private void deposit(double money){
        accountLock.lock();
        try {
            double newBalance = balance + money;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance = newBalance;
        }finally {
            accountLock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}
