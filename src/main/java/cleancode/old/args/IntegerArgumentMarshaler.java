package cleancode.old.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * IntegerArgumentMarshaler
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class IntegerArgumentMarshaler implements ArgumentMarshaler{

    private int integerValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            integerValue = Integer.parseInt(parameter);
        }catch (NoSuchElementException e){
            throw new ArgsException(ErrorCode.MISSING_INTEGER);
        }catch (NumberFormatException e) {
            throw new ArgsException(ErrorCode.INVALID_INTEGER, parameter);
        }
    }

    @Override
    public Object get() {
        return integerValue;
    }
}
