package bugs.bug2.db61b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;


import static bugs.bug2.db61b.Utils.*;

/** A single table in a database.
 *  @author P. N. Hilfinger
 */
class Table implements Iterable<Row> {



    /** A new Table whose columns are given by COLUMNTITLES, which may
     *  not contain dupliace names. */
    Table(String[] columnTitles) {
        for (int i = columnTitles.length - 1; i >= 1; i -= 1) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (columnTitles[i].equals(columnTitles[j])) {
                    throw error("duplicate column name: %s",
                                columnTitles[i]);
                }
            }
        }
        _columnTitles = columnTitles;
        _table = new ArrayList<String[]>();
        _nextIndex = 0;
    }

    /** A new Table whose columns are give by COLUMNTITLES. */
    Table(List<String> columnTitles) {
        this(columnTitles.toArray(new String[columnTitles.size()]));
    }

    /** Return the number of columns in this table. */
    public int columns() {
        return _columnTitles.length;
    }

    /** Return the title of the Kth column.  Requires 0 <= K < columns(). */
    public String getTitle(int k) {
        return _columnTitles[k];
    }

    public String getArray(int k, int j) {
        return _table.get(j)[k];
    }

    /** Return the number of the column whose title is TITLE, or -1 if
     *  there isn't one. */
    public int findColumn(String title) {
        for (int i = 0; i < _columnTitles.length; i += 1) {
            if (_columnTitles[i].equals(title)) {
                return i;
            }
        }
        return -1;
    }

    /** Return the number of Rows in this table. */
    public int size() {
        return _nextIndex;
    }

    /** Returns an iterator that returns my rows in an unspecfied order. */
    @Override
    public Iterator<Row> iterator() {
        return _rows.iterator();
    }

    /** Add ROW to THIS if no equal row already exists.  Return true if anything
     *  was added, false otherwise. */
    public boolean add(Row row) {
        for (int i = 0; i < _nextIndex; i += 1) {
            if (row.equals(new Row(_table.get(i)))) {
                return false;
            }
        }
        _rows.add(row);
        _table.add(row.toArray());
        _nextIndex += 1;
        return true;
    }

    /** Read the contents of the file NAME.db, and return as a Table.
     *  Format errors in the .db file cause a DBException. */
    static Table readTable(String name) {
        BufferedReader input;
        Table table;
        input = null;
        table = null;
        try {
            input = new BufferedReader(new FileReader(name + ".db"));
            String header = input.readLine();
            if (header == null) {
                throw error("missing header in DB file");
            }
            String[] columnNames = header.split(",");
            table = new Table(columnNames);
            String line = null;
            while ((line = input.readLine()) != null) {
                String[] rowArray = line.split(",");
                table.add(new Row(rowArray));
            }
        } catch (FileNotFoundException e) {
            throw error("could not find %s.db", name);
        } catch (IOException e) {
            throw error("problem reading from %s.db", name);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    /* Ignore IOException */
                }
            }
        }
        return table;
    }

    /** Write the contents of TABLE into the file NAME.db. Any I/O errors
     *  cause a DBException. */
    void writeTable(String name) {
        PrintStream output;
        output = null;
        try {
            String sep;
            sep = "";
            output = new PrintStream(name + ".db");
            // FILL THIS IN
        } catch (IOException e) {
            throw error("trouble writing to %s.db", name);
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /** Print my contents on the standard output. */
    void print() {
        int colunmns = this.columns();

        for (int a = 0; a < _table.size(); a += 1) {
            for (int i = 0; i < colunmns; i += 1) {
                System.out.print(" " + _table.get(a)[i]);
            }
            System.out.println();
        }
    }

    /** Return a new Table whose columns are COLUMNNAMES, selected from
     *  rows of this table that satisfy CONDITIONS. */
    Table select(List<String> columnNames, List<Condition> conditions) {
        Table result = new Table(columnNames);

        /** generates a column list to pass into row constructor */
        List<Column> lstOfCols= new ArrayList<Column>();
        for (int i = 0; i < columnNames.size(); i ++) {
            lstOfCols.add(new Column(columnNames.get(i), this));
        }


        for (int j = 0; j < this.size(); j++) {
            Row = new Row(lstOfCols, this.getRow(j));


            /** if it passes ALL of the conds, will set allow pass to remain true.
              * otherwise, pass will become false forever.
              */
            boolean pass = true;
            for (int p = 0; p < conditions.size() - 1; p++) {
                if (conditions.get(p).test(temp)) {
                    pass = (true && pass);
                }
                if (!conditions.get(p).test(temp)) {
                    pass = (false && pass);
                }
            }

            if (pass) {

                if (result.size() == 0) { // if it's the first row
                    result.add(temp);
                } else { //disallows duplicates 
                    boolean flag = false;
                    for (int k = 0; k < result.size(); k++ ) {
                        if (Arrays.deepToString(temp.toArray()).equals(
                                Arrays.deepToString(result.getK(k)))) {
                            flag = true;
                        }
                    }
                    if (!flag) {
                        result.add(temp);
                    }
                }
            }
        }
        return result;

    }


    String[] getK(int k) {
        return _table.get(k);
    }

    Row getRow(int i) {
        return new Row(_table.get(i));
    }

    /** Return a new Table whose columns are COLUMNNAMES, selected
     *  from pairs of rows from this table and from TABLE2 that match
     *  on all columns with identical names and satisfy CONDITIONS. */
    Table select(Table table2, List<String> columnNames,
                 List<Condition> conditions) {
        return null;
    }

    /** Return true if the columns COMMON1 from ROW1 and COMMON2 from
     *  ROW2 all have identical values.  Assumes that COMMON1 and
     *  COMMON2 have the same number of elements and the same names,
     *  that the columns in COMMON1 apply to this table, those in
     *  COMMON2 to another, and that ROW1 and ROW2 come, respectively,
     *  from those tables. */
    private static boolean equijoin(List<Column> common1, List<Column> common2,
                                    Row row1, Row row2) {
        return false;
    }

    /** My rows. */
    private HashSet<Row> _rows = new HashSet<>();

    /** Decide to implement our _TABLE as an arraylist of strings. */
    private List<String[]> _table;

    /** Decide to implement the titles separately, as a string array. */
    private String[] _columnTitles;

    /** This is the counter for number of rows, used for many fcns. */
    private int _nextIndex;

}

