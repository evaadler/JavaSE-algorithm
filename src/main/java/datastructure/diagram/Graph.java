package datastructure.diagram;

import util.Bag;
import util.In;
import util.StdOut;

/**
 * three representation:
 * list of edges
 * adjacent matrix
 * ❤️adjacent list
 * Created by fifi on 2017/4/26.
 */
public class Graph {
    private int V ;

    private Bag<Integer>[] adj;  // adjacent lists (using Bag data type)



    /**
     * Create empty graph with V vertices
     * @param V
     */
    public Graph(int V){
        this.V = V;
        // create an empty graph with V vertices
        adj =  (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    /**
     * Create graph with input stream
     * @param in
     */
    public Graph(In in) {

    }

    /**
     * add an Edge  v-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    /**
     * vertices adjacent to v
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {

        return adj[v];
    }

    /**
     * number of vertices
     * @return
     */
    public int V() {
        return 0;
    }

    /**
     * number of edges
     * @return
     */
    public int E() {
        return 0;
    }

    /**
     * compute the degree of v
     * @param G
     * @param v
     * @return
     */
    public int degree(Graph G, int v) {
        int degree = 0;
        for (int w : adj(v)) {
            degree ++;
        }
        return degree;
    }


    public int maxDegree(Graph G) {
        int max = 0;
        for (int v=0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    /**
     * count self-loops
     * @param G
     * @return
     */
    public int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v=0; v<G.V(); v++){
            for (int w : adj(v)){
                if (v == w) count++;
            }
        }
        // each node counted twice
        return count / 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph g = new Graph(in);

        for (int v=0; v<g.V(); v++){
            for (int w : g.adj(v)) {
                StdOut.println(v + "-" + w);
            }
        }

        //Paths path = new Paths(g, s);
    }
}
