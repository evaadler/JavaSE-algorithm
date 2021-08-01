package designpattern.interpreter;

import java.util.HashMap;

/**
 * Expression
 *
 * @author Alicia
 * @description
 * @date 2021/4/5
 */
public abstract class Expression {
    // 解释公式和数值，key就是公式（表达式），参数[a,b,c],value就是具体值
    // HashMap{a=10, }
    public abstract int interpreter(HashMap<String, Integer> var);
}
