package graph;

import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Will test the functionality of DepthFirstTraversal and BreadthFirstTraversal
 * @author Antonio Contreras
 */

public class TraversalTesting {

    class SubDepthFirstSearch extends DepthFirstTraversal {
        protected SubDepthFirstSearch(Graph G) {
            super(G);
        }

        @Override
        protected boolean visit(int v) {
            actual.add(new Integer(v));
            return true;
        }

        @Override
        protected boolean postVisit(int v) {
            actualPost.add(new Integer(v));
            return true;
        }

        /** Will hold the actual output for the DFS. */
        ArrayList<Integer> actual = new ArrayList<Integer>();

        /** Will hold the actual output for the DFS postvisit. */
        ArrayList<Integer> actualPost = new ArrayList<Integer>();
    }

    class SubBreadthFirstSearch extends BreadthFirstTraversal {
        protected SubBreadthFirstSearch(Graph G) {
            super(G);
        }
        @Override
        protected boolean visit(int v) {
            actual.add(new Integer(v));
            return true;
        }

        /** Will hold the actual output for the DFS. */
        ArrayList<Integer> actual = new ArrayList<Integer>();
    }

    @Test
    public void testingTrav() {
        DirectedGraph a = new DirectedGraph();
        a.add();
        a.add();
        a.add();
        a.add();
        a.add();
        a.add(5, 4);
        a.add(5, 3);
        a.add(4, 1);
        a.add(3, 2);
        a.add(1, 5);
        ArrayList<Integer> expectedTwo = new ArrayList<Integer>();
        expectedTwo.add(5);
        expectedTwo.add(4);
        expectedTwo.add(3);
        expectedTwo.add(1);
        expectedTwo.add(2);
        ArrayList<Integer> expectedOne = new ArrayList<Integer>();
        expectedOne.add(5);
        expectedOne.add(3);
        expectedOne.add(4);
        expectedOne.add(1);
        expectedOne.add(2);
        ArrayList<Integer> expectedThree = new ArrayList<Integer>();
        expectedThree.add(5);
        expectedThree.add(4);
        expectedThree.add(3);
        expectedThree.add(2);
        expectedThree.add(1);
        ArrayList<Integer> expectedFour = new ArrayList<Integer>();
        expectedFour.add(5);
        expectedFour.add(3);
        expectedFour.add(4);
        expectedFour.add(2);
        expectedFour.add(1);
        SubBreadthFirstSearch subBreadth = new SubBreadthFirstSearch(a);
        subBreadth.traverse(5);
        boolean correctAnswerB = false;
        if (expectedOne.equals(subBreadth.actual)
            || expectedTwo.equals(subBreadth.actual)
                || expectedThree.equals(subBreadth.actual)
                    || expectedFour.equals(subBreadth.actual)) {
            correctAnswerB = true;
        }
        assertTrue(correctAnswerB);
    }

    @Test
    public void testingTravTwo() {
        DirectedGraph a = new DirectedGraph();
        a.add();
        a.add();
        a.add();
        a.add();
        a.add();
        a.add(5, 4);
        a.add(5, 3);
        a.add(4, 1);
        a.add(3, 2);
        a.add(1, 5);
        ArrayList<Integer> expectedTwo = new ArrayList<Integer>();
        expectedTwo.add(5);
        expectedTwo.add(4);
        expectedTwo.add(3);
        expectedTwo.add(1);
        expectedTwo.add(2);
        ArrayList<Integer> expectedOne = new ArrayList<Integer>();
        expectedOne.add(5);
        expectedOne.add(3);
        expectedOne.add(4);
        expectedOne.add(1);
        expectedOne.add(2);
        ArrayList<Integer> expectedThree = new ArrayList<Integer>();
        expectedThree.add(5);
        expectedThree.add(4);
        expectedThree.add(3);
        expectedThree.add(2);
        expectedThree.add(1);
        ArrayList<Integer> expectedFour = new ArrayList<Integer>();
        expectedFour.add(5);
        expectedFour.add(3);
        expectedFour.add(4);
        expectedFour.add(2);
        expectedFour.add(1);
        SubBreadthFirstSearch subBreadth = new SubBreadthFirstSearch(a);
        subBreadth.traverse(5);
        boolean correctAnswerB = false;
        if (expectedOne.equals(subBreadth.actual)
                || expectedTwo.equals(subBreadth.actual)
                    || expectedThree.equals(subBreadth.actual)
                        || expectedFour.equals(subBreadth.actual)) {
            correctAnswerB = true;
        }
        assertTrue(correctAnswerB);
    }
}
