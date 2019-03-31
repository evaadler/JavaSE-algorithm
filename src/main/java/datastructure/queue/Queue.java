package datastructure.queue;

/**
 * Created by fifi on 2017/4/27.
 */
public class 瘸ueQueue<T>  {
    private T[] queue;

    public void enqueue(T s) {
    }

    public boolean isEmpty() {
        return queue == null || queue.length == 0;
    }

    public T dequeue() {
        return queue[0];
    }
}
