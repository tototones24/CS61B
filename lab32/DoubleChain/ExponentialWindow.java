/** Class that implements an exponential windowing function and store
 *  the result in a DoubleChain.
 *  @author Josh Hug
 */

public class ExponentialWindow {
    /** Creates an exponential window stored as a deque. The
     *  window should have peak value of 1, and N points to the
     *  left and right of the peak, and should drop off exponentially.
     *  by a factor of LAMBDA per point.
     *
     *  For example genWindow(3, 3) should return
     *  [1/27, 1/9, 1/3, 1, 1/3, 1/9, 1/27]
     */

    public static DoubleChain genWindow(int N, double lambda) {
        double val = 1;
        DoubleChain d = new DoubleChain(val);

        for (int i = 0; i < N; i++) {
        	DoubleChain.insertFront(d, val);
        	DoubleChain.insertBack(d, val);
        }
        return d;
    }
}
