package datastructure.queue;

/**
 * Created by fifi on 2017/4/5.
 */
public class Intq {
    private int size = 50;
    private int total = 0;
    private int rear = -1;
    private int front = -1;
    private int[] q;

    public Intq() {
        total = 0;
        front = 0;
        rear = 0;
    }

    public Intq(int size) {
        this.size = size;
        total = 0;
        front = 0;
        rear = 0;
        q = new int[size];
    }

    public boolean enqueue(int item) {
        if(!isFull()){
            total++;
            rear++;
            q[rear] = item;
        }else{
            return false;
        }
        return false;
    }

    public boolean isFull() {
        return total == size;
    }

    public int dequeue(){
        total--;
        front++;
        return q[front];
    }

    public void showAll() {
        int f = front;
        if(total != 0) {
            for (int i = 0; i < total; i++) {
                System.out.println(" " + q[f]);
                f = (f+1) % size;
            }
        }
    }
}
