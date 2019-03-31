package serializable;

import java.io.*;

public class SerializableInterface {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos1 = new ObjectOutputStream(
                new FileOutputStream("obj1.dat"));
        Child1 oosChild1 = new Child1();
        oos1.writeObject(oosChild1);
        oos1.flush();
        oos1.close();

        // 重点
        ObjectInputStream ois1 = new ObjectInputStream(
                new FileInputStream("obj1.dat"));
        Child1 oisChild1 = (Child1)ois1.readObject();
        System.out.println(oisChild1);
        ois1.close();

        ObjectOutputStream oos2 = new ObjectOutputStream(
                new FileOutputStream("obj2.dat"));
        Child2 oosChild2 = new Child2();
        oos2.writeObject(oosChild2);
        oos2.flush();
        oos2.close();

        ObjectInputStream ois2 = new ObjectInputStream(
                new FileInputStream("obj2.dat"));
        Child2 oisChild2 = (Child2)ois2.readObject();
        System.out.println(oisChild2);
        ois2.close();
    }
}

class Base1 implements Serializable{
    public Base1() {
        System.out.println("Base1");
    }

}

class Child1 extends Base1 {
    public Child1() {
        System.out.println("Child1");
    }
}

class Base2{

    public Base2(){
        System.out.println("Base2");
    }

}

class Child2 extends Base2 implements Serializable{
    public Child2() {
        System.out.println("Child2");
    }
}


