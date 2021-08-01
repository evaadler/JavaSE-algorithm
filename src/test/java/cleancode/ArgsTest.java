package cleancode; /**
 * cleancode.ArgsTest
 *
 * @author Alicia
 * @description
 * @date 2020/6/16
 */
import cleancode.old.args.Args;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArgsTest {

    @Test
    public void test() {

    }

    @Test
    public void testSimpleDoublePresent() throws Exception {
        Args args = new Args("x##", new String[]{"-x","42.3"});
        //assertTrue(args.isValid());
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(42.3, args.getDouble('x'), .001);
    }

    public void testInvalidDouble() throws Exception{
        Args args = new Args("x##", new String[]{"-x","Forty two"});
        //assertTrue(args.isValid());
        assertEquals(0, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(0, args.getInt('x'));
    }
}
