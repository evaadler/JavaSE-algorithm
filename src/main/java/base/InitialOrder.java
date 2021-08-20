package base;

/**
 * InitialOrder
 *
 * @author Alicia
 * @description
 * @date 2021/8/20
 */
public class InitialOrder {
    public static void main(String[] args) {
        InitialOrder.f1();
    }

    static InitialOrder t = new InitialOrder();
    static {
        System.out.println("1");
    }
    {
        System.out.println(2);
    }
    InitialOrder(){
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }
    public static void f1(){
        System.out.println("4");
    }
    int a = 110;
    static int b = 112;
}
