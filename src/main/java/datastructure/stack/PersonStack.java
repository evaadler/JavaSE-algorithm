package datastructure.stack;

/**
 * Created by fifi on 2017/4/5.
 */
public class PersonStack {
    private int size;
    private int top;
    private Person[] stack;

    public PersonStack() {
        top = -1;
        size = 50;
        stack = new Person [50];
    }

    public PersonStack(int size) {
        top = -1;
        this.size = size;
        stack = new Person[size];
    }

    public boolean push(Person item) {

        if(!isFull()) {
            top ++;
            stack[top] = item;
            return true;
        } else {
            return false;
        }
    }

    public Person pop() {
        return stack[top--];
    }

    public boolean isFull(){
        return top == stack.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
