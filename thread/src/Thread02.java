import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable 支持返回值
 */
public class Thread02 implements Callable{
    public static void main(String[] args) throws Exception{
        FutureTask task = new FutureTask(new Thread02());

        new Thread(task).start();


        System.out.println(task.get());
    }


    @Override
    public String call() throws Exception{
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<4; i++) {
            sb.append(i);
        }

        return sb.toString();
    }
}
