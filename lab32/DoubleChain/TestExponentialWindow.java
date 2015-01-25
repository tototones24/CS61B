import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ExponentialWindow class.
 *  @author Josh Hug
 */

public class TestExponentialWindow {
    /** Sums all values inside the DoubleChain D.
    */
    private static double sumChain(DoubleChain d) {
        return sumChainFromFront(DoubleChain.getFront(d));
    }

    /** Sums all values inside the DoubleChain D assuming that
     *  D is the front of the DoubleChain.
     */

    private static double sumChainFromFront(DoubleChain d) {
        if (d == null) {
            return 0;
        }

        return d.val + sumChainFromFront(d.next);
    }

    /** Tests the genWindow method of the ExponentialWinow class
    */

    @Test
    public void testGenWindow() {
        /* The sum of the window should be:
         *         2 * (1 + 1/2 + 1/4 + 1/8 + 1/16)
         *
         * Thus we expect the sum of the window to be 3.875
         */

        DoubleChain ew = ExponentialWindow.genWindow(4, 2);

        assertEquals(2.875, sumChain(ew), 0.01);
    }

    /** Tests the exponential window function
     */

    public static void main(String[] args) {
        ucb.junit.textui.runClasses(TestExponentialWindow.class);
    }
}
