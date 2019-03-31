package datastructure.diagram;


import util.Bag;
import util.In;
import util.StdOut;

/**
 * 强连通分量
 * Created by fifi on 2017/4/28.
 */
public class CC {

    // id[v] = id of component containing v
    private boolean[] marked;
    private int[] id;
    private int count;  // number of components

    /**
     *
     * find connected components in G
     * @param G
     */
    public CC(Graph G){
        marked = new boolean[G.V()];
       // DepthFirstPaths dfp = new DepthFirstPaths();
        id = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]){
                // run dfs from one vertex in each component
              //  dfp.dfs(G, v);
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    boolean connected(int v, int w){
        return id[v] == id[w];
    }

    /**
     * number of connected components
     * @return
     */
    int count(){
        return count;
    }

    /**
     * component identifier for v
     * @param v
     * @return
     */
    int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);

        int M = cc.count();
        StdOut.println(M + " components");

        Bag<Integer>[] components;

        components = new Bag[M];


        // TODO understand
        for (int i = 0; i < M; i++) {
            components[i] = new Bag<>();
        }



    }
}
