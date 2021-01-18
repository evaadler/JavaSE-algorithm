package designpattern.prototype.deepclone;

import com.sun.corba.se.spi.extension.CopyObjectPolicy;

import java.io.*;

/**
 * DeepProtoType
 * 原型
 * @author Alicia
 * @description
 * @date 2021/1/18
 */
public class DeepProtoType implements Cloneable, Serializable{

    public String name;
    public DeepCloneableTarget deepCloneableTarget; // 引用类型

    public DeepProtoType(){
        super();
    }

    // 深拷贝 - 方式1使用 clone 方法
    @Override
    protected Object clone(){
        Object deep = null;
        // 这里完成对基本数据类型（属性）和String的克隆
        try {
            deep = super.clone();
            // 对引用类型的属性，进行单独处理
            DeepProtoType deepProtoType = (DeepProtoType)deep;
            deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
            return deepProtoType;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 深拷贝 - 方式2 通过对象的序列化实现（推荐）
    public Object deepClone(){
        ByteArrayOutputStream bos=null;
        ObjectOutputStream oos=null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;


        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 当前这个对象以对象流的方式输出
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copy = (DeepProtoType) ois.readObject();
            return copy;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        }
      return null;


    }
}
