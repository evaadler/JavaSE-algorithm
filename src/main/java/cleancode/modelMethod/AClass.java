package cleancode.modelMethod;

/**
 * AClass
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
