package graph;

import java.util.ArrayList;

/**
 * A sub class used to test DepthFirstTraversal.
 * @author Antonio Contreras
 *
 */

public class SubDepthFirstSearch extends DepthFirstTraversal {

    /** Constructor for the class with graph G. */
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
    protected ArrayList<Integer> actual = new ArrayList<Integer>();

    /** Will hold the actual output for the DFS postvisit. */
    protected ArrayList<Integer> actualPost = new ArrayList<Integer>();

}
