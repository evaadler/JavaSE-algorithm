package designpattern.prototype.deepclone;

import java.io.Serializable;

/**
 * DeepCloneableTarget
 *
 * @author Alicia
 * @description
 * @date 2021/1/18
 */
public class DeepCloneableTarget implements Cloneable, Serializable{
    private String name;
    private String cloneClass;

    public DeepCloneableTarget(String name, String cloneClass) {
        this.name = name;
        this.cloneClass =cloneClass;
    }

    // 因为该类的属性，都是 String，因此我们这里使用默认的 clone 完成即可 ？？？
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
