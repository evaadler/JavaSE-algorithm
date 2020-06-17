package cleancode.old.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * StringArgumentMarshaler
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {

    private String stringValue;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        }catch (NoSuchElementException e) {
            throw new ArgsException(ErrorCode.MISSING_STRING);
        }
    }

    @Override
    public Object get() {
        return stringValue;
    }
}
