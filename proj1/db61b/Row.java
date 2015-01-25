package db61b;

import java.util.Arrays;
import java.util.List;

/** A single row of a database.
 *  @author Antonio Contreras
 */
class Row {
    /** A Row whose column values are DATA.  The array DATA must not be altered
     *  subsequently. */
    Row(String[] data) {
        _data = data;
    }

    /** Given N colums and rows, returns a new row containing one column from
     *  each of the supplied ROWS.
     *
     *  The value for the ith column of this new row will come from the ith row
     *  in ROWS, using the ith entry of COLUMNS as an effective column index.
     *
     *  There is a method in the Columns class that you'll need to use,
     *  see {@link db61b.Column#getFrom}).  you're wondering why this looks like
     *  a potentially clickable link it is! Just not in source. You might
     *  consider converting this spec to HTML using the Javadoc command.
     */
    Row(List<Column> columns, Row... rows) {
        String[] string = new String[columns.size()];
        int index = 0;
        for (Column colm : columns) {
            string[index] = colm.getFrom(rows);
            index += 1;
        }
        _data = string;
    }
    /** Return my number of columns. */
    int size() {
        return _data.length;
    }

    /** Return the value of my Kth column.  Requires that 0 <= K < size(). */
    String get(int k) {
        if (0 <= k && k < size()) {
            return _data[k];
        } else {
            throw new DBException("Your index is out of bounds");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return Arrays.deepEquals(((Row) obj)._data, _data);
    }

    /* NOTE: Whenever you override the .equals() method for a class, you
     * should also override hashCode so as to insure that if
     * two objects are supposed to be equal, they also return the same
     * .hashCode() value (the converse need not be true: unequal objects MAY
     * also return the same .hashCode()).  The hash code is used by certain
     * Java library classes to expedite searches (see Chapter 7 of Data
     * Structures (Into Java)). */

    @Override
    public int hashCode() {
        return Arrays.hashCode(_data);
    }
    /** Contents of this row. */
    private String[] _data;

    /** @return {String[]} Will be used to access the _data.  You made this. */
    public String[] getter() {
        return _data;
    }

    /** Needed for the second row constructor. */
    private String[] _row;

    /** @return Needed to acces String. */
    public String toString() {
        return Arrays.toString(_data);
    }

}
