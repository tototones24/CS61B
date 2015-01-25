import static org.junit.Assert.*;

import org.junit.Test;


public class RossIntsTest {

	@Test
	public void test() {
		assertEquals(10, new RossInts(3).get());
	}

	public static void main(String[] args) {
		ucb.junit.textui.runClasses(RossIntsTest.class);
	}
}
