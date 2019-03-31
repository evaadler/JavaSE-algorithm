package util;

public class MyArrayList {

    Object[] objs = new Object[4];

    int size = 0;

    public int get() {

        return size;

    }

    public void add(Object obj) {
        objs[size] = obj;
        size ++;
    }

    public void set(int index, Object obj) {

    }

    public void delete(int index) {

    }
}
