package datastructure;

import util.StdIn;
import util.StdOut;

/**
 * union-find 连通性分量
 * Created by fifi on 2017/5/9.
 */
public class UF {
    private int id[]; // 分量id（以触电为索引）
    private int count; // 分量数量

    /**
     * 以整数标识0-N-1初始化N个触电
     * @param N
     */
    public UF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public void union(int p, int q){

    }

    /**
     * p所在的分量的标识符
     * @param p
     * @return
     */
    public int find(int p){
        return 0;
    }

    /**
     * 连通分量的数量
     * @return
     */
    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) ==  find(q);
    }


    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(uf.connected(p, q)) continue;

            uf.union(p, q); // 归并分量

            StdOut.println(p + " " + q);  // 打印连接
        }
    }
}
