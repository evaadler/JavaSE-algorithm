package clone;

import java.io.*;

public class ObjectClone {
}

class InfoBean implements Cloneable{
    public String name;
    private int age;

    public InfoBean clone() {
        try {
            return (InfoBean)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class PeopleBean implements Cloneable {
    public String vipId;
    public InfoBean infoBean;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PeopleBean bean = (PeopleBean)super.clone();
        bean.infoBean = (InfoBean)infoBean.clone();
        return bean;
    }
}

class CloneUtil{
    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;


        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
            objOut.writeObject(obj);
            objOut.close();

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream objIn = new ObjectInputStream(byteIn);
            cloneObj = (T)objIn.readObject();
            objIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }
}
