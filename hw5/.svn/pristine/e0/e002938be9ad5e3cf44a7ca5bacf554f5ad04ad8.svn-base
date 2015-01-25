import org.junit.Test;
import static org.junit.Assert.*;


public class Test {
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(Tests.class));
    }
    @Test 
    public void adderTest() {
        assertEquals(11, Adder.add(8, 3));
        assertEquals(0, Adder.add(0, 0));
        assertEquals(-1, Adder.add(3, -4));
    }
    
    @Test
     public void nybblesTest() {
        Nybbles nyb1 = new Nybbles(9);
        nyb1.set(1, -5);
        assertEquals(-5, nyb1.get(1));
    }
}





