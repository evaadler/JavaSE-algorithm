/**
 * 银行账户
 * Created by fifi on 2017/2/19.
 */
public class Account {
    private double balance;  // 账户余额

    /**
     * 存款
     * @param money
     */
    public void deposit(double money){
        double newBalance = balance + money;
        try {
            Thread.sleep(10);  // 模拟此业务需要一段处理时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = newBalance;
    }

    /**
     * 获得账户余额
     * @return
     */
    public double getBalance() {
        return balance;
    }
}
