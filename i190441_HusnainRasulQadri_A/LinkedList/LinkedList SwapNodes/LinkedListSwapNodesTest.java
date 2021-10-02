import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.PrintStream;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class LinkedListSwapNodesTest {
	private LinkedListSwapNodes Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object = new LinkedListSwapNodes();
	}

	@After
	public void tearDown() throws Exception {
		Object = null;
	}

	@Test
	public void pushFront_1() {
		Object.pushFront(10);
		Object.pushFront(20);
		Assert.assertEquals(Object.head.key, 20);//Array
	}
	
	
	@Test
	public void pushBack() {
		Object.pushBack(10);
		Object.pushBack(20);
		Assert.assertEquals(Object.head.next.key, 20);//Array
	}

	@Test
	public void swap_1() {
		Object.pushFront(30);
		Object.pushFront(40);
		Object.pushFront(70);
		Object.pushFront(80);
		Object.swap();
		Assert.assertEquals(Object.head.key,30);
	}

	@Test
	public void swap_2() {
		Object.pushFront(30);
		Object.swap();
		Assert.assertEquals(30,Object.head.key);
	}

	@Test
	public void swap_3() {
		Object.swap();
		Assert.assertEquals(null,Object.head);
	}
	

	@Test
	public void display_1() {
		System.setOut(new PrintStream(out1));
		Object.display();
		 assertEquals("List : Empty.\r\n"
		 		+ "", out1.toString());
	}
	
	@Test
	public void display_2() {
		Object.pushFront(92);
		Object.pushFront(34);
		Object.pushFront(54);
		System.setOut(new PrintStream(out1));
		Object.display();
		 assertEquals("List : 54 34 92 \r\n"
		 		+ "", out1.toString());
	}
}