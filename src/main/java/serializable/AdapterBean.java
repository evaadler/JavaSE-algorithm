package serializable;

import java.io.*;

public class AdapterBean implements Serializable{
    private String name;
    private int age;

    public AdapterBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("AdapterBean writeObject.");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("AdapterBean readObject.");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.serial"));
        Person p = new Person("fifi",27);
        oos.writeObject(p);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.serial"));
        System.out.println(((AdapterBean)ois.readObject()).toString());
    }
}

class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("Person writeObject.");
    }

    private void readOject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Person readObject");
    }

    private Object writeReplace(){
        System.out.println("Person writeReplace.");
        return new AdapterBean(name, age);
    }
}
