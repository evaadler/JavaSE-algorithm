package base;

/**
 * TwoThreads
 * java 中每个对象身上有个对象复制锁🔒
 * 如果 runnable 超过一个以上，就另外定义一个共享对象
 *
 *
 * @author Alicia
 * @description
 * @date 2021/8/21
 */
public class TwoThreads {
    public static void main(String[] args) {
        Object obj = new Object();
        T1 t1 = new T1(obj);
        T2 t2 = new T2(obj);

        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);

        th1.start();
        th2.start();

    }

}

class T1 implements Runnable{
    private Object obj;
    T1(Object obj){
        this.obj = obj;
    }
    @Override
    public void run() {
        synchronized (obj) {//这样加上锁之后，循环期间不会被打断
            for (int i = 0; i < 52; i++) {
                System.out.println(i);

                try {
                    if(i%2==0) {
                        obj.notifyAll();
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class T2 implements Runnable{
    private Object obj;
    T2(Object obj){
        this.obj = obj;
    }
    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 'A'; i <= 'Z'; i++) {
                System.out.println((char) i);

                try {
                    obj.notifyAll();
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

