/* NOTE: The file ArrayUtil.java contains some functions that may be useful
 * in testing your answers. */

/** HW #2, Problem #2. */

/** Array utilities.
 *  @author
 */
class Arrays {
    /* 2a. */
    /** Returns a new array consisting of the elements of A followed by the
     *  the elements of B. */
    static int[] catenate(int[] A, int[] B) {
        /* *Replace this body with the solution. */
        int[] answer = new int[A.length + B.length];
        int counter = 0;
        int pos = 0;
        while (counter < A.length && pos < answer.length) {
            answer[pos] = A[counter];
            counter ++;
            pos ++;
        }
        counter = 0;
        while (counter < B.length) {
            answer[pos] = B[counter];
            counter ++;
            pos ++;
        }
        return answer;
    }

    /* 2b. */
    /** Returns the array formed by removing LEN items from A,
     *  beginning with item #START. */
    static int[] remove(int[] A, int start, int len) {
        /* *Replace this body with the solution. */
        int answer[] = new int[len];
        int counter = 0;
        int pos = 0;
        int lastCounter = 0;
        lastCounter = start;
        while (counter < len) {
            answer[pos] = A[lastCounter];
            counter ++;
            pos ++;
            lastCounter ++;
        }
        return answer;
    }

    /* 4 (optional). */
    /** Returns the array of arrays formed by breaking up A into
     *  maximal ascending lists, without reordering.
     *  For example, if A is {1, 3, 7, 5, 4, 6, 9, 10}, then
     *  returns the three-element array
     *  {{1, 3, 7}, {5}, {4, 6, 9, 10}}. */
    static int[][] naturalRuns(int[] A) {
        /* *Replace this body with the solution. */
        return null;
    }
}
