import org.junit.Test;
import static org.junit.Assert.*;

/** Perform tests of the DoubleChain class
 */

public class TestDoubleChain {

    /** Tests the constructor of DoubleChain */
    @Test
    public void testConstructor() {
        DoubleChain d = new DoubleChain(5);
        assertEquals(d.val, 5, 1e-6);
        assertEquals(d.prev, null);
        assertEquals(d.next, null);
    }

    public static void main(String[] args) {
        ucb.junit.textui.runClasses(TestDoubleChain.class);
    }

    /** Tests the method getBack */
    @Test
    public void testAllMethods() {
        DoubleChain d1 = new DoubleChain (15);
        DoubleChain.insertBack(d1, 1.8);
        assertEquals(d1.next.val, 1.8, 1e-6); 
    }

}
