// This is a SUGGESTED skeleton for a class that contains the Tables your
// program manipulates.  You can throw this away if you want, but it is a good
// idea to try to understand it first.  Our solution changes about 6
// lines in this skeleton.

// Comments that start with "//" are intended to be removed from your
// solutions.
package  bugs.bug1.db61b;

import java.util.HashSet;
import java.util.Iterator;

/** A collection of Tables, indexed by name.
 *  @author STEVE SIXARMS */
class Database {
    /** An empty database. */
    public Database() {
        _tables = new HashSet<Table>();
    }

    /** Return the Table whose name is NAME stored in this database, or null
     *  if there is no such table. */
    public Table get(String name) {
        Iterator<Table> iter = _tables.iterator();
        Table nextTable;
        while (iter.hasNext()) {
            nextTable = iter.next();
            if ((nextTable.getName()).equals(name)) {
                return nextTable;
            }
        }
        return null;      // REPLACE WITH SOLUTION
    }

    /** Set or replace the table named NAME in THIS to TABLE.  TABLE and
     *  NAME must not be null, and NAME must be a valid name for a table. */
    public void put(String name, Table table) {
        if (name == null || table == null) {
            throw new IllegalArgumentException("null argument");
        }
        // FILL IN
        removeIfExists(name, _tables);
        table.changeName(name);
        _tables.add(table);
    }

    /** Removes a table from tables if there exists a table in tables
     *  with the label name. Else does nothing.
     * @param name the label we're searching for
     * @param tables the HashSet of tables we're looking through
     */
    private void removeIfExists(String name, HashSet<Table> tables) {
        if (name == null || tables == null) {
            throw new IllegalArgumentException("null argument");
        }
        // if for any table in _tables, the name matches, then remove
        Iterator<Table> iter = tables.iterator();
        Table nextTable;
        while (iter.hasNext()) {
            nextTable = iter.next();
            if (nextTable.getName() == name) {
                tables.remove(nextTable);
            }
        }
    }

    /** My tables. */
    private HashSet<Table> _tables;
}
