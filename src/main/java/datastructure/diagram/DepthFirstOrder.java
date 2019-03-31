package datastructure.diagram;

import java.util.Iterator;
import java.util.Stack;

/**
 * 拓扑排序
 * Created by fifi on 2017/5/6.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Graph G) {
        reversePost = new Stack<>();

        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) dfs(g, w);
        }
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }


}
