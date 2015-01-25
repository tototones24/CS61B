// This is a SUGGESTED skeleton for a class that describes a single
// Condition (such as CCN = '99776').  You can throw this away if you
// want,  but it is a good idea to try to understand it first.
// Our solution changes or adds about 30 lines in this skeleton.

package  bugs.bug1.db61b;

import java.util.List;
import static bugs.bug1.db61b.Utils.*;

/** Represents a single 'where' condition in a 'select' command.
 *  @author STEVE SIXARMS */
class Condition {

    /** A Condition representing COL1 RELATION COL2, where COL1 and COL2
     *  are column designators. and RELATION is one of the
     *  strings "<", ">", "<=", ">=", "=", or "!=". */
    Condition(Column col1, String relation, Column col2) {
        // YOUR CODE HERE
        _col1 = col1;
        _col2 = col2;
        _op = relation;
    }

    /** A Condition representing COL1 RELATION 'VAL2', where COL1 is
     *  a column designator, VAL2 is a literal value (without the
     *  quotes), and RELATION is one of the strings "<", ">", "<=",
     *  ">=", "=", or "!=".
     */
    Condition(Column col1, String relation, String val2) {
        this(col1, relation, (Column) null);
        _val2 = val2;
    }

    /** Assuming that ROWS are rows from the respective tables from which
     *  my columns are selected, returns the result of performing the test I
     *  denote. */
    boolean test(Row... rows) {
        // REPLACE WITH SOLUTION
        // you can test a maximum of 2 rows.
        if (_col2 == null) { // compares rowitem1s in col1, return statement in every case
            return testVal(rows);
        } else { // compares corresponding rowitem1s in col1 and col2
            return testCol(rows);

        }

    }

    /** Assuming that _col2 is null, tests whether the two row items
     *  that we're comparing satisfy the given condition clause.
     * @param rows the 2 rows that we're comparing
     * @return whether the 2 rows satsify the condition clause
     */
    private boolean testVal(Row... rows) {
        String item1 = _col1.getFrom(rows);
        switch (_op) {
        case "<":
            if (item1.compareTo(_val2) < 0) {
                return true;
            }
            return false;
        case ">":
            if (item1.compareTo(_val2) > 0) {
                return true;
            }
            return false;
        case "<=":
            if (item1.compareTo(_val2) <= 0) {
                return true;
            }
            return false;
        case ">=":
            if (item1.compareTo(_val2) >= 0) {
                return true;
            }
            return false;
        case "=":
            if (item1.compareTo(_val2) == 0) {
                return true;
            }
            return false;
        case "!=":
            if (item1.compareTo(_val2) != 0) {
                return true;
            }
            return false;
        default:
            throw error("unknown relation operator: %s", _op);
        }
    }

    /** Assuming that _col2 is not null, tests whether the two row items
     *  that we're comparing satisfy the given condition clause.
     * @param rows the 2 rows that we're comparing
     * @return whether the 2 rows satsify the condition clause
     */
    private boolean testCol(Row... rows) {
        String item1 = _col1.getFrom(rows);
        String item2 = _col2.getFrom(rows);
        switch (_op) {
        case "<":
            if (item1.compareTo(item2) < 0) {
                return true;
            }
            return false;
        case ">":
            if (item1.compareTo(item2) > 0) {
                return true;
            }
            return false;
        case "<=":
            if (item1.compareTo(item2) <= 0) {
                return true;
            }
            return false;
        case ">=":
            if (item1.compareTo(item2) >= 0) {
                return true;
            }
            return false;
        case "=":
            if (item1.compareTo(item2) == 0) {
                return true;
            }
            return false;
        case "!=":
            if (item1.compareTo(item2) != 0) {
                return true;
            }
            return false;
        default:
            throw error("unknown relation operator: %s", _op);
        }
    }

    /** Return true iff ROWS satisfies all CONDITIONS. */
    static boolean test(List<Condition> conditions, Row... rows) {
        for (Condition cond : conditions) {
            if (!cond.test(rows)) {
                return false;
            }
        }
        return true;
    }

    /** The operands of this condition.  _col2 is null if the second operand
     *  is a literal. */
    private Column _col1, _col2;
    /** Second operand, if literal (otherwise null). */
    private String _val2;
    /** The comparison operator that is to be used. */
    private String _op;
}
