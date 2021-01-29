package designpattern.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * ObjectStructure
 *
 * @author Alicia
 * @description
 * @date 2021/1/30
 */
public class ObjectStructure {

    private List<Person> persons = new LinkedList<>();

    public void attach(Person p){
        persons.add(p );
    }

    public void dettach(Person p){
        persons.remove(p);
    }

    public void display(Action action){
        for (Person person : persons){
            person.accept(action);
        }
    }
}
