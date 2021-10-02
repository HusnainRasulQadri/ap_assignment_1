import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackwithLinkedListTest {
	private Stack_LinkedList Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object = new Stack_LinkedList();
	}

	@After
	public void tearDown() throws Exception {
		Object = null;
	}
	
	/*Testing push with random values and checking there sequence too*/
	@Test
	public void push_1() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(Object.head.key,11);
		Assert.assertEquals(Object.head.next.key,84);
	}

	@Test
	public void push_2() {
		Object.push(11);
		Assert.assertEquals(Object.head.key,11);
		Assert.assertEquals(null,Object.head.next);
	}

	/*Testing top with random values*/
	@Test
	public void top_1() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(Object.top(),11);
	}
	
	/*Testing top on empty stack */
	@Test
	public void top_2() {
		Assert.assertEquals(-1,Object.top());
	}

	/* stack with random values*/
	@Test
	public void pop_1() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(11,Object.pop());
	}
	
	/*Testing pop on empty stack*/
	@Test
	public void pop_2() {
		Assert.assertEquals(-1,Object.pop());
	}

	/*Checking display om empty stack*/
	@Test
	public void display_1() {
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("Stack_LinkedList is empty.\r\n", out1.toString());
	}
	
	/*Checking display with values*/
	@Test
	public void display_2() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("\r\n"
				+ "Stack_LinkedList \r\n"
				+ "----------\r\n"
				+ "|   11   |\r\n"
				+ "----------\r\n"
				+ "|   84   |\r\n"
				+ "----------\r\n"
				+ "|   76   |\r\n"
				+ "----------\r\n"
				+ "|   87   |\r\n"
				+ "----------\r\n"
				+ "|   22   |\r\n"
				+ "----------\r\n"
				+ "|   33   |\r\n"
				+ "----------\r\n"
				+ "\r\n"
				+ "", out1.toString());
	}

	@Test
	public void getSize_1() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(6,Object.getSize());
	}
	@Test
	public void getSize_2() {
		Assert.assertEquals(0,Object.getSize());
	}
	
}