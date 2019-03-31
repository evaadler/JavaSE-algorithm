package serializable;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// 子类实现序列化
public class ExtendSerializable {
    private void writeObject(ObjectOutputStream out) throws NotSerializableException {
        throw new NotSerializableException("xxx");
    }

    private void readObject(ObjectInputStream in) throws NotSerializableException {
        throw new NotSerializableException("xxx");
    }

    private void readObjectNoData() throws NotSerializableException {
        throw new NotSerializableException("xxx");
    }
}
