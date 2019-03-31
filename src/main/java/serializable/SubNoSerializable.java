package serializable;

import java.io.*;

public class SubNoSerializable {

}

abstract class Base{
    public int value;

    public Base(int value) {
        this.value = value;
    }

    public Base() {}
}

class Sub extends Base implements Serializable{
    public int subvalue;

    public Sub(int value, int subvalue){
        super(value);
        this.subvalue = subvalue;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(value);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        value = in.readInt();
    }
}
