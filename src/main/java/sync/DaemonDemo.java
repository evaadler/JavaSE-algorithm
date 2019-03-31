package sync;

/**
 * 守护线程
 */
public class DaemonDemo {
    public static class Daemon1 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Daemon1();
        t.setDaemon(true);  // 设置为守护线程 start方法之前
        t.start();

        Thread.sleep(2000);
    }
}
