package cleancode.old.args;

import java.util.Iterator;

/**
 * ArgumentMarshaler
 *
 * @author Alicia
 * @description
 * @date 2020/6/17
 */
public interface ArgumentMarshaler {
    public abstract void set(Iterator<String> currentArgument) throws ArgsException;

    public abstract Object get();
}
