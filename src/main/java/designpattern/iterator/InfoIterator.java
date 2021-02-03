package designpattern.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * InfoIterator
 *
 * @author Alicia
 * @description
 * @date 2021/2/1
 */
public class InfoIterator implements Iterator{
    private List<Department> departmentList;
    private int index;

    public InfoIterator(){
        departmentList = new LinkedList<>();
    }


    @Override
    public boolean hasNext() {
        if (index>=departmentList.size()-1) {
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Object next() {
        index ++;
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
