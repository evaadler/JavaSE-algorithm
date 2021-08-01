package designpattern.interpreter;

import java.util.HashMap;

/**
 * AddExpression
 *
 * @author Alicia
 * @description
 * @date 2021/4/5
 */
public class AddExpression extends SymbolExpression{
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var){
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
