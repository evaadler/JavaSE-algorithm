package datastructure.symboltable;

import datastructure.tree.BST;

/**
 * Created by fifi on 2017/5/15.
 */
public class ST<Key extends Comparable<Key>, Value> {
    private int N = 0;
    private Value[] keys ;
    private Value[] vals;


    public ST() {
      //  keys = new Value[N];
       // vals = new Value[N];
    }

    void put(Key key, Value value){

    }

    Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        //if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        //else return null;
        return  null;
    }

    Key min(){
        return null;
    }

    Key max(){
        return null;
    }

    Key floor(){


        return null;
    }

    Key ceiling() {
        return null;
    }

    /**
     * datastructure.search: logN
     * insert: N    avg-case: N / 2
     * ordered iteration: yes
     * key interface: compareTo()
     *
     */
    int rank(Key key){
        int lo = 0, hi = N - 1;

        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = 0;
                    //key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if(cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;

    }

    Key select(){
        return null;
    }

    void delete(Key key){

    }

    void deleteMin(){

    }

    void deleteMax(){

    }



    boolean contains(Key key){
        return false;
    }

    boolean isEmpty(){
        return false;
    }

    Iterable<Key> keys(Key lo, Key hi){
        return null;
    }

    Iterable<Key> keys(){
        return null;
    }

    int size(){
        return 0;
    }

}


