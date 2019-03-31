package datastructure.tree;

import datastructure.queue.Queue;

/**
 * Created by fifi on 2017/5/18.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.count = 1 + size(x.left) + size(x.right);  // add new
        return x;
    }

    public Value get(Key key){
        Node x = root;
        if(root != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else
                return x.value;
        }
        return null;
    }

    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);                  // search for key
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;                     // no right child

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);                           // replace with successor
            x.left = t.left;
        }
        x.count = size(x.left) +size(x.right) + 1;                  // update subtree counts
        return x;
    }

    private Node min(Node right) {
        return null;
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    public Node floor(Node x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0) return x;

        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);

        if (t!=null) return t;
        else return x;
    }

    public int rank(Key key){

        return rank(root, key);

    }

    private int rank(Node x, Key key) {
        if (key ==  null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<Key>();
        inorder(root, q);
        return (Iterable<Key>) q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    public Iterable<Key> iterator(){

        return null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null) return 0;
        return x.count;
    }



    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int count;   // add new

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}


