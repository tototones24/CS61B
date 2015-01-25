package bugs.bug1.db61b;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Scanner;
import java.util.ArrayList;

/** Tests basic functionalities including:
 *  1. The Row class
 *  2. The Table class
 *  3. The Database class
 *  @author STEVE SIXARMS
 */

public class BasicTests {

    @Test
    public void testRow() {
        Row p = new Row(new String[]{"Hello", "world"});
        Row q = new Row(new String[]{"Hello", "world"});
        Row r = new Row(new String[]{"Holla", "back"});
        assertEquals(2, p.size());
        assertEquals("Hello", p.get(0));
        assertEquals(true, p.equals(q));
        assertEquals(false, p.equals(r));
    }

    @Test
    public void testTablePhase1() {
        // assert that the length of columnNames is length of added row
        /* tests size() */
        Table t = new Table(new String[]{"1stCol", "2ndCol", "3rdCol"});
        Row p = new Row(new String[]{"Hello", "world", "yo"});
        Row q = new Row(new String[]{"Hello", "world", "yo"});
        Row r = new Row(new String[]{"Fat", "cats", "go"});
        t.add(p);
        t.add(q);
        t.add(r);
        assertEquals(3, t.columns());
        assertEquals("2ndCol", t.getTitle(1));
        assertEquals(2, t.findColumn("3rdCol"));
        assertEquals(2, t.size());
        assertEquals(false, t.add(p));
        t.print();
        t.writeTable("tester");
        Table u = Table.readTable("tester");
        u.print();
    }

    @Test
    public void testTableSingleSelect() {
    	Table t = Table.readTable("testing/students");
    	ArrayList<String> lst = new ArrayList<String>();
    	lst.add("SID");
    	lst.add("Lastname");
    	Table t2 = t.select(lst, null);
    	assertEquals("SID", lst.get(0));
    	assertEquals(6, t2.size());
    	t2.print();
    }

    @Test
    public void testTableEquijoin() {

        //Test equijoin
        Table t = new Table(new String[]{"a", "b", "c", "d", "e"});
        Row p = new Row(new String[]{"1", "2", "3", "4", "5"});
        Row q = new Row(new String[]{"6", "7", "8", "9", "10"});
        Row r = new Row(new String[]{"11", "12", "13", "14", "15"});
        t.add(p);
        t.add(q);
        t.add(r);
        Row[] trows = new Row[]{p, q, r};
        Table v = new Table(new String[]{"b", "f", "a", "c"});
        Row a = new Row(new String[]{"0", "0", "0", "0"});
        Row b = new Row(new String[]{"2", "6", "1", "3"});
        Row c = new Row(new String[]{"4", "1", "7", "9"});
        Row[] vrows = new Row[]{a, b, c};
        Table[] tables = new Table[]{t, v};
        ArrayList<Column> col1 = new ArrayList<>();
        Column c11 = new Column("a", tables);
        Column c12 = new Column("b", tables);
        Column c13 = new Column("c", tables);
        // c11._table = 0, name = a, column = 0
        // c11._table = 0, name = b, column = 1
        // c11._table = 0, name = c, column = 2
        col1.add(c11);
        col1.add(c12);
        col1.add(c13);
        ArrayList<Column> col2 = new ArrayList<>();
        Column c20 = new Column("b", tables);
        Column c22 = new Column("a", tables);
        Column c23 = new Column("c", tables);
        // c20._table = 1, name = b, column = 0
        // c21._table = 1, name = a, column = 2
        // c22._table = 1, name = c, column = 3
        col2.add(c20);
        col2.add(c22);
        col2.add(c23);
        Row r1 = new Row(col1, trows);
        Row r2 = new Row(col2, vrows);
        assertEquals(true, Table.equijoin(col1, col2, r1, r2));
    }

    @Test
    public void testDatabase() {
        Table t1 = new Table(new String[]{"1stCol", "2ndCol", "3rdCol"});
        Row p1 = new Row(new String[]{"Hello", "world", "yo"});
        Row q1 = new Row(new String[]{"Holla", "back", "tho"});
        Row r1 = new Row(new String[]{"Fat", "cats", "go"});
        t1.add(p1);
        t1.add(q1);
        t1.add(r1);
        Table t2 = new Table(new String[]{"4thCol", "5thCol", "6thCol"});
        Row p2 = new Row(new String[]{"Eat", "red", "apples"});
        Row q2 = new Row(new String[]{"Consume", "green", "pears"});
        Row r2 = new Row(new String[]{"Chef", "Boy", "ardee"});
        t2.add(p2);
        t2.add(q2);
        t2.add(r2);
        Database d = new Database();
        d.put("Hello", t1);
        d.put("Food", t2);
        d.get("Hello").print();

    }

    @Test
    public void testCommandInterpreter() {
        Scanner input = new Scanner(System.in);
        CommandInterpreter c = new CommandInterpreter(input, System.out);

    }

    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(BasicTests.class));
    }

}
