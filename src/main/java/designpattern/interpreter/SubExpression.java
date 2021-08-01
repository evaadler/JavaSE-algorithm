package designpattern.interpreter;

import java.util.HashMap;

/**
 * SubExpression
 *
 * @author Alicia
 * @description
 * @date 2021/4/5
 */
public class SubExpression extends SymbolExpression{
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var){
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
