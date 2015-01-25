package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;
import huglife.Creature;
import huglife.Lab5Utils;
import java.util.Map;
import java.util.List;
/** Tests the plip class   
 *  @authr Antonio Contreras
 */

public class TestPlip {

    @Test
    public void testBasics() {
        Plip p = new Plip(2);
        assertEquals(p.energy(), 2, 0.01);
        assertEquals(new Color(99, 255, 76), p.color());
        p.move();
        assertEquals(p.energy(), 1.85, 0.01);
        p.move();
        assertEquals(p.energy(), 1.70, 0.01);
        p.stay();
        assertEquals(p.energy(), 1.90, 0.01);
        p.stay();
        assertEquals(p.energy(), 2.00, 0.01);
    }

    @Test
    public void testReplicate() {
        Plip a = new Plip(2);
        Plip b = a.replicate();
        assertNotSame(a, b); 

        Plip parent = new Plip(2);
        Plip baby = parent.replicate();
        assertEquals(parent.energy(), 1.00, 0.01);
        assertEquals(baby.energy(), 1.00, 0.01);
    }

    @Test
    public void testChoose() {
        Plip p = new Plip(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        assertEquals(p.chooseAction(surrounded), new Action(Action.ActionType.STAY));

        Plip a = new Plip(1.5);
        Map<Direction, Occupant> neighbors = new HashMap<Direction, Occupant>();
        neighbors.put(Direction.TOP, new Empty());
        neighbors.put(Direction.BOTTOM, new Impassible());
        neighbors.put(Direction.LEFT, new Impassible());
        neighbors.put(Direction.RIGHT, new Impassible());
        List<Direction> empties = a.getNeighborsOfType(neighbors, "empty");
        Plip baby = a.replicate();
        Direction direction = empties.get(0);
        assertEquals(a.chooseAction(neighbors), new Action(Action.ActionType.REPLICATE, direction));
    }

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(TestPlip.class));
    }
} 


