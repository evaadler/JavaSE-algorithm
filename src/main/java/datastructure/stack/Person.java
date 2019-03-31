package datastructure.stack;

/**
 * Created by fifi on 2017/4/5.
 */
public class Person {
    private String name;
    private String rollno;

    public Person(String name, String rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Rollno: " + this.rollno;
    }
}
