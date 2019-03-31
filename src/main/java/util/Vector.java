package util;

/**
 * Created by fifi on 2017/5/10.
 */
// 所有实例不能被覆盖
public final class Vector {
    // 所有变量都是私有和final的
    private final int N;
    private final double[] data;

    public Vector(double[] data) {
        this.N = data.length;
        this.data = new double[N];
        for (int i=0; i<N; i++) {
            this.data[i] = data[i];
        }
    }
}
