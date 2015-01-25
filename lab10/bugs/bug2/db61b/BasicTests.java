package  bugs.bug2.db61b;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;



/** Tests basic functionality.
 *  @author FRANK FIVELEGS
 */

public class BasicTests {
    /** Tests basic functionality including the row class.
     */

    @Test
    public void testRow() {
        Row r = new Row(new String[]{"Josh", "is", "writing", "this", "test."});
        assertEquals(5, r.size());
        assertEquals("is", r.get(1));
        assertEquals(true, r.equals(r));
        assertEquals(false, r.equals(new Row(new String[]{"Hello."})));
        assertEquals(true, r.equals(new Row(
            new String[]{"Josh", "is", "writing", "this", "test."})));

        Row s = new Row(new String[]{"Josh", "104", "hi"});
        assertEquals(false, r.equals(s));
        Row t = new Row(new String[]{"Josh", "is", "writing", "this", "test."});
        assertEquals(true, r.equals(t));

    }

    @Test
    public void testTable() {
        Table t = new Table(new String[]{"Name", "DOB", "SID", "CCN"});
        assertEquals(4, t.columns());
        assertEquals("DOB", t.getTitle(1));
        assertEquals(-1, t.findColumn("BLEH"));
        assertEquals(2, t.findColumn("SID"));
        assertEquals(0, t.size());

        Row tekla = new Row(
            new String[]{"TEKLA", "May 12", "24329578", "No clue."});
        t.add(tekla);
        assertEquals(1, t.size());
        t.add(tekla);
        assertEquals(1, t.size());

        Table sched = Table.readTable("schedule");
        assertEquals(8, sched.size());
        sched.print();
    }

    @Test
    public void testDatabase() {
        Database testingDatabase = new Database();
        assertEquals(null, testingDatabase.get("hello"));
        Table t = new Table(new String[]{"Name", "DOB", "SID", "CCN"});
        Row tekla = new Row(
            new String[]{"TEKLA", "May 12", "24329578", "No clue."});
        t.add(tekla);

        testingDatabase.put("Tekla", t);

        Table tActual = testingDatabase.get("Tekla");
        assertEquals(tActual, t);
        assertEquals(1, tActual.size());

        Table sched = Table.readTable("schedule");
        testingDatabase.put("schedule", sched);

        Table schedActual = testingDatabase.get("schedule");
        assertEquals(8, schedActual.size());
        assertEquals(sched, schedActual);
    }

    @Test
    public void testRowComplicated() {
        Database testingDatabase = new Database();
        Table t = new Table(new String[]{"Name", "DOB", "SID", "CCN"});
        Row tekla = new Row(
            new String[]{"TEKLA", "May 12", "24329578", "No clue."});
        t.add(tekla);
        testingDatabase.put("Tekla", t);


        Column cf = new Column("Name", t);
        Column cs = new Column("SID", t);

        ArrayList<Column> lstOfCol = new ArrayList<Column>();
        lstOfCol.add(cf);
        lstOfCol.add(cs);

        Row testRow = new Row(lstOfCol, tekla);
        assertEquals(2, testRow.size());
        assertEquals("TEKLA", testRow.get(0));
        assertEquals("24329578", testRow.get(1));

        Table tstSomething = new Table(new String[]{"Name", "SID"});
        tstSomething.add(testRow);
        tstSomething.print();


    }


    @Test
    public void testSelectNoCond() {
        Database testingDatabase = new Database();
        Table t = new Table(new String[]{"Name", "DOB", "SID", "CCN"});
        Row tekla = new Row(
            new String[]{"TEKLA", "May 12", "24329578", "No clue."});
        Row gennadiy = new Row(
            new String[]{"Gennadiy", "May 12", "222222", "No Cluetoo"});
        Row roelof = new Row(
            new String[]{"ROELOF", "May 13", "108429", "CCN3"});
        Row roelof2 = new Row(
            new String[]{"ROELOF", "May 13", "108429", "CCN3"});
        t.add(tekla);
        t.add(gennadiy);
        t.add(roelof);
        t.add(roelof2);

        testingDatabase.put("Tekla", t);

        List<String> strss = new ArrayList<String>();
        List<Condition> conds = new ArrayList<Condition>();
        strss.add("Name");
        Table newTbl = t.select(strss, conds);
        newTbl.print();

    }





    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(BasicTests.class));
    }
}
