package datastructure.diagram;

/**
 * Created by fifi on 2017/5/2.
 */
public class DirectedDFS {
    private boolean marked[];  // true if path from s

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[v]) dfs(G, v);
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }


}
