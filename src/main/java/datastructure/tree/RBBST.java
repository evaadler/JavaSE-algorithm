package datastructure.tree;

/**
 * red-black BST
 * Created by fifi on 2017/5/20.
 */
public class RBBST<Key extends Comparable, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public boolean isRed(Node x){
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h){
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private class Node{
        Key key;
        Value value;
        Node left, right;
        boolean color;          // color of parent link
    }


}
