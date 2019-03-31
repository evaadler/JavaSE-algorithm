package datastructure.diagram;

/**
 * Created by fifi on 2017/4/27.
 */
public interface IPaths {
    public boolean hasPathTo(int v);
    public Iterable<Integer> pathTo(int v);
}
