package bugs.bug2.db61b;

import java.util.HashMap;


import static bugs.bug2.db61b.Utils.*;

/** A collection of Tables, indexed by name.
 *  @author FRANK FIVELEGS */
class Database {
    /** An empty database. */
    public Database() {
        _database = new HashMap<String, Table>();
    }

    /** Return the Table whose name is NAME stored in this database, or null
     *  if there is no such table. */
    public Table get(String name) {
        if (_database.containsKey(name)) {
            return _database.get(name);
        }
        return null;
    }

    /** Set or replace the table named NAME in THIS to TABLE.  TABLE and
     *  NAME must not be null, and NAME must be a valid name for a table. */
    public void put(String name, Table table) {
        if (name == null || table == null) {
            throw new IllegalArgumentException("null argument");
        }
        _database.put(name, table);
    }

    /** We chose to implement our database using a Map interface with
      * string object key, and a table object value. */
    private HashMap<String, Table> _database;
}
