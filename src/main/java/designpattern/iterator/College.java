package designpattern.iterator;

import java.util.Iterator;

/**
 * College
 *
 * @author Alicia
 * @description
 * @date 2021/2/1
 */
public interface College {
    public String getName();


    public Department addDeparment(String name, String desc);

    public Iterator createIterator();
}
