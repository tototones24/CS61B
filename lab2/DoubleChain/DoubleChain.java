public class DoubleChain {

    /** Moves backwards into the previous DoubleChaion. */
    public DoubleChain prev;
    /** Gives you the value in DoubleChain. */
    public double val;
    /** Moves forward onto the next DoubleChain. */
    public DoubleChain next;

    /** Constructs a new DoubleChain with only one element value. */
    public DoubleChain(double val) {
        this.val = val;
    }

    /** Returns the back of a DoubleChain.  The back of the DoubleChain is
     *  defined as the last non-null DoubleChain that you reach if you keep
     *  following d.next pointers. This operation is undefined for 
     *  DoubleChains with loops, returns a DoubleChain. */
    public static DoubleChain getBack(DoubleChain d) {
        while (d.next != null) {
            d = d.next;
        }
        return d;
    }

    /** Return the front of a DoubleChain,
     *  returns a DoubleChain. */ 
    public static DoubleChain getFront(DoubleChain d) {
        while (d.prev != null) {
            d = d.prev;
        }
        return d;
    }

    /** Inserts a value at the back of a double chain. */
    public static void insertBack(DoubleChain d, double val) {
        if (d.next == null) {
            d.next = new DoubleChain(val);
            d.next.prev = d;
        } else {
            insertBack(d.next, val);
        }
    }

    /** Inserts a value at the front of the DoubleChain. */
    public static void insertFront(DoubleChain d, double val) {
        if (d.prev == null) {
            d.prev = new DoubleChain(val);
            d.prev.next = d;
        } else {
            insertFront(d.prev, val);
        }
    }

    /** Returns a string representation of the doueble chain
     *  rturns a string.  */
    public static String toString(DoubleChain d) {
        return "dummy" ;//dummy
    }
}
