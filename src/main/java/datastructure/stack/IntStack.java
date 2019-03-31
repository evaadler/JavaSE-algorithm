package datastructure.stack;

/**
 * Created by fifi on 2017/4/5.
 */
public class IntStack {
    private int size;
    private int top;
    private int[] stack;

    public IntStack() {
        top = -1;
        size = 50;
        stack = new int [50];
    }

    public IntStack(int size) {
        top = -1;
        this.size = size;
        stack = new int[size];
    }

    public boolean push(int item) {

        if(!isFull()) {
            top ++;
            stack[top] = item;
            return true;
        } else {
            return false;
        }
    }

    public int pop() {
        return stack[top--];
    }

    public boolean isFull(){
        return top == stack.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
