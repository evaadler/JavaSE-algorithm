package datastructure.diagram;

/**
 * Created by fifi on 2017/5/10.
 */
public class DirectedEdge {
    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * vertex v
     * @return
     */
    public int from(){
        return v;
    }

    /**
     * vertex w
     * @return
     */
    public int to(){
        return w;
    }

    /**
     * weight of this edge
     * @return
     */
    double weight(){
        return weight;
    }

    @Override
    public String toString() {
        return "DirectedEdge{}";
    }
}
