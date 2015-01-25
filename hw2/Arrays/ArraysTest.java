import org.junit.Test;
import static org.junit.Assert.*;

/** FIXME
 *  @author FIXME
 */

public class ArraysTest {
    /** FIXME
     */

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(ArraysTest.class));
    }

    /** Tests catenate, returns new array. */
    @Test
    public void testCatenate() {
    	int x[] = new int[]{1, 2, 3, 4, 5};
    	int y[] = new int[]{6, 7, 8, 9, 10};
    	int z[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	assertArrayEquals(z ,Arrays.catenate(x, y));

    	int a[] = new int[]{4, 5, 6};
    	int b[] = new int[]{8, 9, 10};
    	int c[] = new int[]{4, 5, 6, 8, 9, 10};
    	assertArrayEquals(c, Arrays.catenate(a, b));
    }

    /** Test remove */
    @Test
    public void testRemove() {
    	int a[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    	int b[] = new int[]{2, 3, 4, 5}; 
    	assertArrayEquals(b, Arrays.remove(a, 1, 4));

    	int x[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	int y[] = new int[]{4, 5, 6}; 
    	assertArrayEquals(y, Arrays.remove(a, 3, 3));

    }
}

//remove(int[] A, int start, int len)