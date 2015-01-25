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


    /** Tests the DoubleChainClass
     */
    @Test
    public void testDoubleChain() {
    	DoubleChain d = new DoubleChain(5);
    	DoubleChain.insertBack(d, 4);
    	assertEquals(DoubleChain.getBack(d).val, new DoubleChain(4).val, .01);
    	DoubleChain.insertFront(d, 6);
    	assertEquals(DoubleChain.getFront(d).val, new DoubleChain(6).val, .01);
    }

    public static void main(String[] args) {
        ucb.junit.textui.runClasses(TestDoubleChain.class);
    }
}
