import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

//import java.util.Object;
//import static java.util.Object.*;
import static org.junit.Assert.*;

public class CircularLinkedListTest {
	private CircularLinkedList Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object = new CircularLinkedList();//Object
	}

	@After
	public void tearDown() throws Exception {
		//CircularObject.head =null;
	}

	@Test
	public void pushFront_1() {
		Object.pushFront(10);
		Object.pushFront(20);
		Object.pushFront(76);
		Object.pushFront(44);
		Assert.assertEquals(44,Object.head.key);//Array
	}
	
	
	@Test
	public void pushBack() {
		Object.pushBack(78);
		Object.pushBack(45);
		Object.pushBack(10);
		Object.pushBack(20);
		Assert.assertEquals(45,Object.head.next.key);
	}
	@Test
	public void popFront_1() {
		Object.pushFront(34);
		Object.pushFront(54);
		Object.popFront();
		Assert.assertEquals(Object.head.key, 34);
	}
	
	@Test
	public void popFront_2() {
		Object.pushFront(24);
		Object.pushFront(66);
		Object.popFront();
		Object.popFront();
		Assert.assertEquals(null,Object.head);
	}
	
	@Test
	public void popFront_3() {
		Object.popFront();
		Assert.assertEquals(null,Object.head);
	}
	
	/*pushing then popping one value and checking remaining one*/
	@Test
	public void popBack_1() {
		Object.pushFront(34);
		Object.pushFront(54);
		Object.popBack();
		Assert.assertEquals(54,Object.head.next.key);		
	}
	
	/*Filling then empting the linked list*/
	@Test
	public void popBack_2() {
		Object.pushFront(91);
		Object.pushFront(89);
		Object.popBack();
		Object.popBack();
		Assert.assertEquals(null,Object.head);
	}
	
	/*Testing popBack on empty Linked List*/
	@Test
	public void popBack_3() {
		Object.popBack();
		Assert.assertEquals(null,Object.head);
	}
	
	/*Test if the link list is empty*/
	@Test
	public void display_1() {
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("List : Empty List.\r\n"
				+ "", out1.toString());
	}
	
	/*Test display with values inside linked list*/
	@Test
	public void display_2() {
		Object.pushFront(91);
		Object.pushFront(89);
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("List : 89 91\r\n"
				+ "", out1.toString());
	}

}