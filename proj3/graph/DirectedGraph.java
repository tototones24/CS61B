package graph;

import java.util.ArrayList;

/* See restrictions in Graph.java. */

/** Represents a general unlabeled directed graph whose vertices are denoted by
 *  positive integers. Graphs may have self edges.
 *
 *  @author Antonio Contreras
 */
public class DirectedGraph extends GraphObj {

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public int inDegree(int v) {
        int instances = 0;
        if (!adjList.containsKey(v)) {
            return 0;
        }
        for (Integer key : adjList.keySet()) {
            if (adjList.get(key).contains(v)) {
                instances += 1;
            }
        }
        return instances;
    }

    @Override
    public int predecessor(int v, int k) {
        if (!adjList.containsKey(v)) {
            return 0;
        }
        if (orderedPredKey.get(v).isEmpty()) {
            return 0;
        }
        if (k > orderedPredKey.get(v).size() - 1) {
            return 0;
        }
        if (orderedPredKey.get(v).size() == 0) {
            return 0;
        }
        return orderedPredKey.get(v).get(k);
    }

    @Override
    public Iteration<Integer> predecessors(int v) {
        return Iteration.iteration(orderedPredKey.get(v));
    }

    /** Holds all of the predecessors of the vertex v,
     *  not in th eorder they were added. */
    protected ArrayList<Integer> noOrderPred;

    /** Hold all of the predecessors in order they were added. */
    protected ArrayList<Integer> orderPred;

    /** Hold all of the edges in no particular order. */
    protected ArrayList<int[]> noOrderEdges;

}
