package datastructure.diagram;

import util.StdIn;
import util.StdOut;

import java.util.Iterator;

/**
 * shortest path
 * Created by fifi on 2017/5/10.
 */
public class SP {
    private int[] distTo;  // s到v的最短路径的长度
    private int[] edgeTo;  // s到v的最短路径上的最后一条边
    /**
     * shortest path from s in graph G
     * @param G
     * @param s
     */
    public SP(EdgeWeightedDigraph G, int s) {
    }

    /**
     * length of shortest path from s -> v
     * @param v
     * @return
     */
    double distTo(int v){
        return distTo[v];
    }

    /**
     * shortest path from s -> v
     * @param v
     * @return
     */
    Iterable<DirectedEdge> pathTo(int v){
        return new Iterable<DirectedEdge>() {
            @Override
            public Iterator<DirectedEdge> iterator() {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        int V = StdIn.readInt();
        int s = StdIn.readInt();
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);

        SP sp = new SP(G, s);
        for (int v = 0; v < G.V(); v++){
            StdOut.printf("%d to %d (%.2f): ",s, v, sp.distTo(v));
            for (DirectedEdge e : sp.pathTo(v)) {
                StdOut.print(e + " ");
            }
            StdOut.println();
        }

    }
}
