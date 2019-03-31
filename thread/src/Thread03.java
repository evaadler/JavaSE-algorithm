import java.util.concurrent.*;

/**
 * Callable 支持返回值
 *
 * Executor 多线程顶级接口
 * ExcecutorService 三级
 *
 */
public class Thread03 implements Callable{
    public static void main(String[] args) throws Exception{

        //FutureTask > RunnableFuture > Runnable, Futureby

        // Executor 多线程顶级接口
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    @Override
    public String call() throws Exception{
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<4; i++) {
            sb.append(i);
        }

        return sb.toString();
    }


    // ThreadPoolExecutor  🏁
}
