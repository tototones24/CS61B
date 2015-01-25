package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Lab5Utils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

/** An implementation of for Clorus.
 *  @author Antonio Contreras
 */
public class Clorus extends Creature {
    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    /** creates clorus with energy equal to E. */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /** creates a clorus with energy equal to 1. */
    public Clorus() {
        this(1);
    }

    /** Should return a color with red = 34, blue = 231, and green = 0. */
    public Color color() {
        g = 0;
        r = 34;
        b = 231;
        return color(r, g, b);
    }

    /** Clorus gains the creatures anergy. */
    public void attack(Creature c) {
        energy += c.energy();
    }

    /** Clorus should lose 0.03 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    public void move() {
        energy -= .03; //all are changes
    }


    /** Clorus gain 0.01 energy when staying due to photosynthesis. */
    public void stay() {
        energy -= .01; //all are changes
    }

    /** When replicating, Cloruses should receive half of their energy and their     *  offspring should receive the other half.
     */
    public Clorus replicate() {
        energy = .50 * energy;
        Clorus baby = new Clorus(energy);
        return baby;
    }

    /** Plips take exactly the following actions based on NEIGHBORS:
     *  1. If there are no empty squares the Clorus will STAY (even if there are
     *     no empty spaces.
     *  2. Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     *  3. Otherwise, if the Clorus has energy greater than or equal to one, it 
     *     will REPLICATE to a random empty square.
     *  4. Otherwise, the Clorus will MOVE.
     *
     *  Returns an object of type Action. See Action.java for the
     *  scoop on how Actions work. See SampleCreature.chooseAction()
     *  for an example to follow.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        } else if (plips.size() > 0) {
            Direction moveDir = Lab5Utils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK, moveDir);
        } else if (energy >= 1) {
            if (empties.size() > 0) {
                Direction moveDir = Lab5Utils.randomEntry(empties);
                return new Action(Action.ActionType.REPLICATE, moveDir);
            }
        }
        Direction moveDir = Lab5Utils.randomEntry(empties);
        return new Action(Action.ActionType.MOVE, moveDir);
    }
}
