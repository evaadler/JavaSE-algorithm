package serializable;

import java.io.*;

// 自定义序列化：使用transient也可序列化
public class Info implements Serializable {
    transient private Item item = null;

    private void writeObject(ObjectOutputStream out) throws IOException{

        // invoke default serialization method
        out.defaultWriteObject();
        if (item == null){
            item = new Item();
        }
        out.writeObject(item.name);
        out.writeObject(item.id);
    }

    private void readObject(ObjectInputStream in ) throws IOException,
            ClassNotFoundException {
        // invoke default serialization method
        in.defaultReadObject();
        String name = (String) in.readObject();
        String id = (String) in.readObject();
        item = new Item(name, id);
    }

}
