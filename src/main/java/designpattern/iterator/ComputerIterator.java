package designpattern.iterator;

import javax.swing.text.Position;
import java.util.Iterator;

/**
 * ComputerIterator
 *
 * @author Alicia
 * @description
 * @date 2021/2/1
 */
public class ComputerIterator implements Iterator {
    private Department[] departments;
    private int position;

    public ComputerIterator(Department[] departments){
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if (position>=departments.length || departments[position] == null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Department obj = departments[position];
       position += 1; // 后移一位
        return obj;
    }

    @Override
    public void remove() {

    }
}
