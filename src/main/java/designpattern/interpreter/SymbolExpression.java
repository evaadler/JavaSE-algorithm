package designpattern.interpreter;

import java.util.HashMap;

/**
 * 抽象运算符号解析器，每个运算符都只和自己左右两个数字有关系，
 * 但左右两个数字有可能也是一个解析的结果，无论何种类型，都是Expression类的实现类
 *
 * @author Alicia
 * @description
 * @date 2021/4/5
 */
public class SymbolExpression extends Expression{
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }


    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return 0;
    }
}
