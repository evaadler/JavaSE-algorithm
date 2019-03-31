package serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalInfo implements Externalizable {
    private String name;
    private int age;

    // 必须定义无参构造方法
    public ExternalInfo() {}

    public ExternalInfo(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 实现此方法序列化时使用
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(this.age);
    }

    // 实现此方法反序列化时使用
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }
}
