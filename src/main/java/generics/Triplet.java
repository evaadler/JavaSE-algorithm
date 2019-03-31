package generics;

// java的元祖实现（Python语言支持）
public class Triplet<A, B, C> {
    private A a;
    private B b;
    private C c;

    public Triplet(A a, B b, C c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
