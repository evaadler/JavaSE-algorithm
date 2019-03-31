package sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 无锁实现多线程访问，并且线程安全
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int k=0; k<10000; k++){
                i.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];

        for (int i=0; i<ts.length; i++){
            ts[i] = new Thread(new AddThread());
        }

        for (int j=0; j<10; j++){
            ts[j].start();
        }

        for (int j=0; j<10; j++){
            ts[j].join();
        }

        System.out.println(i);
    }
}
