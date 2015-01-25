package graph;

import java.util.ArrayList;

/**
 * A subclass used to test BreadthFirstTraversal.
 * @author Antonio Contreras
 */

public class SubBreadthFirstSearch extends BreadthFirstTraversal {

    /** Constructor with graph G. */
    protected SubBreadthFirstSearch(Graph G) {
        super(G);
    }

    @Override
    protected boolean visit(int v) {
        actual.add(new Integer(v));
        return true;
    }
    /** Will hold the actual output for the DFS. */
    protected ArrayList<Integer> actual = new ArrayList<Integer>();

}
