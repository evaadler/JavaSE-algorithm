import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

public class ThreadTest extends Thread{

    public static void main(String[] args) throws Exception{
        Long start = System.currentTimeMillis();

        final Random random = new Random();

        final List<Integer> list = new ArrayList<>();

        for (int i=0; i<1000; i++){
//            ExecutorService executorService=null;  // 线程池
//
//            thread.start();
//            thread.join();
//
//            executorService.shutdown();
//            executorService.awaitTermination();// 等待子线程运行完毕再运行主线程
        }


    }
}
