package db61b;


import org.junit.Test;
import static org.junit.Assert.*;

/** Tests for what is considered phase 1.
*/

public class Tests {
	/** Will  test the size get and equals method in row.*/
	@Test
	public void testRow() {
	Row row1 = new Row(new String[]{"Time", "to", "get", "this", "done"});
	assertEquals(row1.size(), 5);
	Row rowa = new Row(new String[]{});
	assertEquals(rowa.size(), 0);

	Row row0 = new Row(new String[]{"a", "b", "c", "d"});
       	String expected = "c";
	assertEquals(row0.get(2), expected);

	Row row2 = new Row(new String[]{"i", "am", "equal"});
	Row row3 = new Row(new String[]{"i", "am", "equal"});
	assertEquals(row2, row3);

        Row row9 = new Row(new String[]{"hey", "ho", "letsgo"});
       	Row row10 = new Row(new String[]{"hey", "ho", "letsgo"});
       	assertEquals(row9, row10);

       	Row row11 = new Row(new String[]{"hey", "ho", "letsgo"});
       	Row row12 = new Row(new String[]{"hey", "ho"});
       	assertFalse(row11.equals(row12));
	}
	/** These tests will test several methods that were implamented in the table class. */
	@Test
	public void testTable() {
	/** Tests the add method and the getTitle method. */
	Row rowl = new Row(new String[]{"she", "he", "knew"});
	Row rowm = new Row(new String[]{"low"});
	String[] strings = {"how", "are", "you"};
	Table newTable = new Table(strings);
	String result = "are";
	assertEquals(newTable.getTitle(1), result);
	assertTrue(newTable.add(rowl));


	/** Tests the print method.  */
	Row rowx = new Row(new String[]{"she", "he", "kneww"});
	Row rowy = new Row(new String[]{"hey", "ho"});
	Row rowz = new Row(new String[]{"hey", "hey", "hey"});
	String[] testTable = {"how", "are", "you"};
	Table table = new Table(testTable);
	table.add(rowx);
	table.add(rowy);
	table.add(rowz);
	table.print();

	Row one = new Row(new String[]{"she", "he", "kneww"});
	Row two = new Row(new String[]{"hey", "ho"});
	Row three = new Row(new String[]{"hey", "hey hey", "hey"});
	String[] colms = {"how", "are", "you"};
	Table newtable = new Table(colms);
	newtable.add(one);
	newtable.add(two);
	newtable.add(three);
	newtable.writeTable("copy1");

	Row haha = new Row(new String[]{"she", "he", "kneww"});
	String[] colm = {"how", "are", "you"};
	Table tablzz = new Table(colm);
	tablzz.add(haha);
	}
	public static void main(String[] args) {
    	System.exit(ucb.junit.textui.runClasses(Tests.class));
    }
}
