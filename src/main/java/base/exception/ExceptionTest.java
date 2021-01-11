package base.exception;

import org.junit.Test;

/**
 * ExceptionTest
 *
 * @author Alicia
 * @description
 * @date 2020/6/24
 */
public class ExceptionTest {

    /**
     * 异常处理
     */
    @Test
    public void test(){
        try {
            int num = div(10, 0);
            System.out.println(num);
        }catch (ArithmeticException e){
            //e.printStackTrace();
            System.out.println("算数异常");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally中 - 一定要执行");
        }

        System.out.println("try catch外 - Hello Exception");

    }

    /**
     * 包含return的异常处理
     */
    @Test
    public void test1(){
        try {
            int num = div(10, 0);
            System.out.println(num);
        }catch (ArithmeticException e){
            //e.printStackTrace();
            System.out.println("算数异常");
            return;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally中 - 一定要执行");
            //return;
        }

        System.out.println("try catch外 - Hello Exception");

    }


    public static int div(int i, int j){
            return i / j;
    }
}
