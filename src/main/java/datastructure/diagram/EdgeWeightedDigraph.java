package datastructure.diagram;

import util.Bag;

/**
 * Created by fifi on 2017/5/10.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private final Bag<DirectedEdge>[] adj;
    /**
     * Edge-weighted diagraph with v vertices
     * @param V
     */
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    /**
     * 当添加边，只添加在from点的邻接表里
     * @param e
     */
    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].add(e);
    }

    /**
     * edges pointing from v
     * @param v
     * @return
     */
    Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    /**
     * numbers of vertex
     * @return
     */
    public int V(){
        return V;
    }
}
