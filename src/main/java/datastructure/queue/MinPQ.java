package datastructure.queue;

import util.StdIn;
import util.Transaction;


/**
 * Created by fifi on 2017/5/9.
 */
public class MinPQ<Key extends Comparable<Key>> {
    private static final int M = 0;

    public void insert(Key item) {
    }

    public int size() {
        return 0;
    }

    public void delMin() {
    }

    public static void main(String[] args) {
        MinPQ<Transaction> pq = new MinPQ<Transaction>();

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            Transaction item = new Transaction(line);
            pq.insert(item);
            if (pq.size() > M) {
                pq.delMin();
            }
        }
    }
}
