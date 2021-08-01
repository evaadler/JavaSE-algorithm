package designpattern.interpreter;

import java.util.HashMap;

/**
 * VarExpression
 *
 * @author Alicia
 * @description
 * @date 2021/4/5
 */
public class VarExpression extends Expression{
    private String key; //key=a,key=b, key=c

    public VarExpression(String key){
        this.key = key;
    }
    // var就是{a=10, b=20}
    // interpreter根据变量的名称返回对应的值
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
