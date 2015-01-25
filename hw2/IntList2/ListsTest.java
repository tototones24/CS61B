import org.junit.Test;
import static org.junit.Assert.*;

/** FIXME
 *
 *  @author Antonio Contreras
 */

public class ListsTest {
    /** FIXME
     */

    // It might initially seem daunting to try to set up
    // Intlist2 expected.
   	//
    // There is an easy way to get the IntList2 that you want in just
    // few lines of code! Make note of the IntList2.list method that
    // takes as input a 2D array.

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(ListsTest.class));
    }

    /** Tests for naturalRuns. */
    // @Test
    // public void testNaturalRuns() {
    //     IntList a = IntList.list(1, 2, 3, 5, 6);
    //     IntList b = IntList.list(2);
    //     IntList c = IntList.list(1, 2, 3, 5, 6, 2);
    //     IntList2 d = IntList2.list(a, b);
    //     IntList2 z = Lists.naturalRuns(c);
    //     assertEquals(d, z);
    // }
    @Test
    public void testNaturalRuns () {
        IntList l = IntList.list(1, 3, 7, 5);
        IntList m = IntList.list(1, 3, 7);
        IntList n = IntList.list(5);
        IntList2 p = IntList2.list(m,n);
        assertEquals(p, Lists.naturalRuns(l));
    }

}


