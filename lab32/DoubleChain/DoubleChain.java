/**
 * @author Ross Teixeira
 *
 */
public class DoubleChain {
	public DoubleChain prev;
	public double val;
	public DoubleChain next;
	
	public DoubleChain(double val) {
		this.prev = null;
		this.val = val;
		this.next = null;
	}
	
	/** Returns the back of a DoubleChain. 
	 * The back of the DoubleChain is defined as the 
	 * last non-null DoubleChain that you reach if you 
	 * keep following d.next pointers. This operation 
	 * is undefined for DoubleChains with loops.
	 */
	public static DoubleChain getBack(DoubleChain d) {
		if (d.next == null) {
			return d;
		}
		return getBack(d.next);
	}
	
	/** Returns the front of a DoubleChain */
	public static DoubleChain getFront(DoubleChain d) {
		if (d.prev == null) {
			return d;
		}
		return getFront(d.prev);
	}
	
	/** Inserts a value at the back of a DoubleChain */
	public static void insertBack(DoubleChain d, double val) {
		DoubleChain back = getBack(d);
		back.next = new DoubleChain(val);
		back.next.prev = back;
		
	}
	
	/** Inserts a value at the front of a DoubleChain */
	public static void insertFront(DoubleChain d, double val) {
		DoubleChain front = getFront(d);
		front.prev = new DoubleChain(val);
		front.prev.next = front;
	}
	
	/** Returns a string representation of a DoubleChain. */
	public static String toString(DoubleChain d) {
		return "Hello";
	}

	}