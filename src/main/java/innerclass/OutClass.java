package innerclass;

public class OutClass {
    class InnerClass1 {
        /*
        public static int func() {
            return 1;
        }*/
    }

    public class InnerClass2 {
        /*
        static int func(){
            return 1;
        }*/
    }

    private class InnerClass3 {
        int func() {
            return 1;
        }
    }

    static class InnerClass4 {
        protected int func() {
            return 1;
        }
    }

    abstract class InnerClass5 {
        public abstract int func();
    }

    private int out = 1;
    public void func(final int param) {
        final int in = 2;
        new Thread() {
            @Override
            public void run() {
                out = param;
                out = in;
            }
        }.start();
    }
}
