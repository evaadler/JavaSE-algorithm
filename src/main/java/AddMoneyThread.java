/**
 * 存钱线程类
 * Created by fifi on 2017/2/19.
 */
public class AddMoneyThread implements Runnable {
    private Account account; // 存入账户
    private double money;    // 存入金额

    public AddMoneyThread(Account account, double money){
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        account.deposit(money);
    }
}
