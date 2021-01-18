package designpattern.prototype.deepclone;

/**
 * Client
 *
 * @author Alicia
 * @description
 * @date 2021/1/18
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.name = "宋江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");

        // 方式1
        DeepProtoType p1 = (DeepProtoType) p.clone();
        System.out.println("p.name="+p.name + "p.deepClonebaleTarget="+p.deepCloneableTarget);
        System.out.println("p1.name="+p1.name + "p1.deepClonebaleTarget="+p1.deepCloneableTarget);

        // 方式2
        DeepProtoType p2= (DeepProtoType) p.deepClone();
        System.out.println("p.name="+p.name + "p.deepClonebaleTarget="+p.deepCloneableTarget);
        System.out.println("p1.name="+p2.name + "p1.deepClonebaleTarget="+p2.deepCloneableTarget);
    }
}
