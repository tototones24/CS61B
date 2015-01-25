package db61b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static db61b.Utils.*;

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

    /** Return the number of the column whose title is TITLE, or -1 if
     *  there isn't one. */
    public int findColumn(String title) {
        for (int j = 0; j < _columnTitles.length; j++) {
            if (_columnTitles[j].equals(title)) {
                return j;
            }
        }
        return -1;
    }

    /** Return the number of Rows in this table. */
    public int size() {
        return _rows.size();

    }

    /** Returns an iterator that returns my rows in an unspecfied order. */
    @Override
    public Iterator<Row> iterator() {
        return _rows.iterator();
    }

    /** Add ROW to THIS if no equal row already exists.  Return true if anything
     *  was added, false otherwise. */
    public boolean add(Row row) {
        if (_rows.contains(row)) {
            return false;
        }
        _rows.add(row);
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
            String nxtLine = input.readLine();
            while (nxtLine != null) {
                String[] strings = nxtLine.split(",");
                Row nwRow = new Row(strings);
                table.add(nwRow);
                nxtLine = input.readLine();
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
            int marker = 0;
            int firstLen = _columnTitles.length;
            for (String string : _columnTitles) {
                marker += 1;
                output.print(string);
                if (marker != firstLen) {
                    output.print(",");
                }
            }
            output.println();
            for (Row row : _rows) {
                int len = row.getter().length;
                int count = 0;
                for (String string : row.getter()) {
                    count += 1;
                    output.print(string);
                    if (count != len) {
                        output.print(",");
                    }
                }
                output.println();
            }
        } catch (IOException e) {
            throw error("trouble writing to %s.db", name);
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /** Print my contents on the standard output, using TITLE as the title. */
    void print() {
        for (Row row : _rows) {
            int length = row.getter().length;
            int counter = 0;
            boolean twospaces = false;
            for (String string : row.getter()) {
                counter += 1;
                if (!twospaces) {
                    System.out.print("  ");
                    twospaces = true;
                }
                System.out.print(string);
                if (counter != length) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            twospaces = false;
        }
    }

    /** Return a new Table whose columns are COLUMNNAMES, selected from
     *  rows of this table that satisfy CONDITIONS. */
    Table select(List<String> columnNames, List<Condition> conditions) {
        Table result = new Table(columnNames);
        if (conditions == null || conditions.size() == 0) {
            for (Row row : this) {
                Row dummyRow;
                String[] dummy = new String[columnNames.size()];
                int cntr = 0;
                for (String col : columnNames) {
                    Column colms = new Column(col, this);
                    String value = colms.getFrom(row);
                    dummy[cntr] = value;
                    cntr += 1;
                }
                dummyRow = new Row(dummy);
                result.add(dummyRow);
            }
        } else {
            ArrayList<Column> col1 = new ArrayList<Column>();
            for (String str : columnNames) {
                col1.add(new Column(str, this));
            }
            for (Row row : this) {
                if (Condition.test(conditions, row)) {
                    result.add(new Row(col1, row));
                }
            }
        }
        return result;
    }

    /** Return a new Table whose columns are COLUMNNAMES, selected
     *  from pairs of rows from this table and from TABLE2 that match
     *  on all columns with identical names and satisfy CONDITIONS. */
    Table select(Table table2, List<String> columnNames,
                 List<Condition> conditions) {
        Table result = new Table(columnNames);
        ArrayList<Column> colA = new ArrayList<Column>();
        ArrayList<Column> colB = new ArrayList<Column>();
        ArrayList<String> lStrings = new ArrayList<String>();
        for (int i = 0; i < _columnTitles.length; i++) {
            for (int j = 0; j < table2.columns(); j++) {
                if (table2.getTitle(j).equals(this.getTitle(i))) {
                    lStrings.add(table2.getTitle(j));
                }
            }
        }
        for (String str : lStrings) {
            colA.add(new Column(str, this));
            colB.add(new Column(str, table2));

        }
        ArrayList<Column> newC = new ArrayList<Column>();
        for (String str2 : columnNames) {
            newC.add(new Column(str2, this, table2));
        }
        if (lStrings.size() != 0) {
            for (Row firstR : _rows) {
                for (Row secondR : table2) {
                    if (equijoin(colA, colB, firstR, secondR)
                        && Condition.test(conditions, firstR, secondR)) {
                        Row inputRow = new Row(newC, firstR, secondR);
                        result.add(inputRow);
                    }
                }
            }
        } else {
            for (Row first : _rows) {
                for (Row second : table2) {
                    if (Condition.test(conditions, first, second)) {
                        Row inputRow = new Row(newC, first, second);
                        result.add(inputRow);
                    }
                }
            }
        }
        return result;
    }

    /** Return true if the columns COMMON1 from ROW1 and COMMON2 from
     *  ROW2 all have identical values.  Assumes that COMMON1 and
     *  COMMON2 have the same number of elements and the same names,
     *  that the columns in COMMON1 apply to this table, those in
     *  COMMON2 to another, and that ROW1 and ROW2 come, respectively,
     *  from those tables. */
    private static boolean equijoin(List<Column> common1, List<Column> common2,
                                    Row row1, Row row2) {
        for (int i = 0; i < common1.size(); i++) {
            String val1 = common1.get(i).getFrom(row1);
            String val2 = common2.get(i).getFrom(row2);
            if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }

    /** My rows. */
    private HashSet<Row> _rows = new HashSet<>();
    /** My columns. */
    private String[] _columnTitles;
}

