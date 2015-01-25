package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;

/** Tests the Clorus class   
 *  @author Antonio Contreras
 */

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus p = new Clorus(2);
        assertEquals(p.energy(), 2, 0.01);
        assertEquals(new Color(34, 0, 231), p.color());
        p.move();
        assertEquals(p.energy(), 1.97, 0.01);
        p.move();
        assertEquals(p.energy(), 1.94, 0.01);
        p.stay();
        assertEquals(p.energy(), 1.93, 0.01);
        p.stay();
        assertEquals(p.energy(), 1.92, 0.01); //works if the energy is 2.10
    }

    @Test
    public void testReplicate() {
        Clorus a = new Clorus(2);
        Clorus b = a.replicate();
        assertNotSame(a, b);



    }

    @Test
    public void testChoose() {
        Clorus p = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        assertEquals(p.chooseAction(surrounded), new Action(Action.ActionType.STAY));
    }

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(TestPlip.class));
    }
} 
