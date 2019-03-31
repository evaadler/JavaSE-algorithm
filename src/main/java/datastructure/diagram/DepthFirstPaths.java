package datastructure.diagram;

import javax.xml.soap.Detail;
import java.util.Stack;

/**
 * Created by fifi on 2017/4/27.
 */
public class DepthFirstPaths implements IPaths{

    private boolean[] marked;   //marked[v] = true if v connected s
    private int[] edgeTo;   // edgeTo[v] = previous vertex on path from s to v
    private int s;

    public DepthFirstPaths(){}

    public DepthFirstPaths(Graph G, int s){
        // TODO : initialize data structure
        this.s = s;
        dfs(G, s);   // find vertices contected to s
    }

    /**
     * recursive DFS dose the work
     * @param G
     * @param v
     */
    public void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;// record source vertex
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        // edgeTo[] is parent-link representation of a tree rooted at s.
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
