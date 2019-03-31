package sync;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 让普通变量也享受原子操作
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Candidate{
        int id;
        volatile int score;
    }

    public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater
            = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");

    //检查Updater是否工作正确
    public static AtomicInteger allScore = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        final Candidate stu = new Candidate();
        Thread[] ts = new Thread[10000];

        for (int i=0; i<10000; i++){
            ts[i] = new Thread(){
                @Override
                public void run() {
                    if (Math.random()>0.4){
                        scoreUpdater.incrementAndGet(stu);
                        allScore.incrementAndGet();
                    }
                }
            };
            ts[i].start();
        }

        for (int i=0; i<10000; i++ ){
            ts[i].join();
        }
    }
}
