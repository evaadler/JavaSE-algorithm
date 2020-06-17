package cleancode.old.args;

import java.util.Iterator;

/**
 * BooleanArgumentMarshaler
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public class BooleanArgumentMarshaler implements ArgumentMarshaler{
    private boolean booleanValue = false;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }

    @Override
    public Object get() {return booleanValue;}
}
