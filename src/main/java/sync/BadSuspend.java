package sync;

public class BadSuspend {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");  // 给线程起名字
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{

        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        public void run(){
            synchronized (u){  // 给u加锁，对象实例监视器
                System.out.println("in" + getName());
                Thread.currentThread().suspend(); // 挂起操作
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100); //休眠是为了确保t1执行到suspend部分
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();  // 主线程中等待t1，t2结束
    }

}
