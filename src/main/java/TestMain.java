import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试类
 * Created by fifi on 2017/2/18.
 */
public class TestMain {
    public static void main(String[] args){
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            service.execute(new AddMoneyThread(account, 1));
        }

        service.shutdown();

        while (!service.isTerminated()){

        }

        System.out.println("账户余额: " + account.getBalance());
    }

    /*
    在没有同步的情况下，执行结果通常是显示账户余额在10元一下，出现这种状况的原因是，当一个线程A试图存入1元的时候，另外一个线程B也能够进入
    存款的方法种，线程B读取到的账户余额仍然是线程A存入1元钱之前的那个余额，因此也是在原来的余额0上面做了加1元的操作，同理线程C也会做类似
    的事情，所以最后100个线程执行结束时，本来希望账户余额是100元，但实际得到的通常在10元以下。解决这个问题的办法就是同步，当一个线程对银
    行账户存钱时，需要将此账户锁定，待其操作完成后才允许其他线程进行操作，代码有几种调整方案：
    1。 在银行账户的存款（deposit）方法上同步（synchronized）关键字
    2。 在线程调用存款方法时对银行账户进行同步
    3。 通过Java5显示的锁机制，为每个银行账户创建一个锁对象，在存款操作进行加锁和解锁的操作

     */

    /** 当然也可以使用Semaphore或者CountdownLatch来实现同步 **/


}
