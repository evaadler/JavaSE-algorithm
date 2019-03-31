package datastructure.diagram;

import util.Bag;
import util.In;

/**
 * Created by fifi on 2017/4/30.
 */
public class Digraph {
    private int V;
    private Bag<Integer>[] adj;

    public Digraph (int V){
        this.V = V;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }


    public Digraph(In in){


    }

    public int V(){
        return V;
    }

    public int E() {
        return 0;
    }

    /**
     * add a direct edge : v->w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
        return  null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
