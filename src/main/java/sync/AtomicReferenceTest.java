package sync;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    final static AtomicReference<String> atomicStr = new AtomicReference<String>("abc");


    public static void main(String[] args) {
        for (int i=0; i<10; i++){
            new Thread(){
              public void run(){
                  try {
                      Thread.sleep(Math.abs((int) (Math.random()*100)));

                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  if (atomicStr.compareAndSet("abc", "cde")){
                      System.out.println("Thread" + Thread.currentThread().getId() + " change value");
                  }else{
                      System.out.println("Thread " + Thread.currentThread().getId() + " failed");
                  }
              }
            }.start();
        }
    }
}
