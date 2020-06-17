package cleancode.old.args;

import jdk.nashorn.internal.runtime.ArgumentSetter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DoubleArgumentMarshaler
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class DoubleArgumentMarshaler implements ArgumentMarshaler {
    private double doubleValue = 0;
    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            doubleValue = Double.parseDouble(parameter);
        } catch (NoSuchElementException e){
            throw new ArgsException(ErrorCode.MISSING_DOUBLE);
        } catch (NumberFormatException e){
            throw new ArgsException(ErrorCode.INVALID_DOUBLE, parameter);
        }
    }


    @Override
    public Object get() {
        return null;
    }
}
