package sync;

/**
 * 给方法实例加锁
 */
public class Accounting2Sync implements Runnable{
    static Accounting2Sync instance = new Accounting2Sync();

    static int i = 0;

    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j<100000; j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);

        Thread t2 = new Thread(instance);

        // Thread t1 = new Thread(new Accouonting2Sync())  结果错误，因为构造了不同实例，而锁加载了实例上面
        // 但如果方法是静态的，即锁加载了类上，则可以有正确结果

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
