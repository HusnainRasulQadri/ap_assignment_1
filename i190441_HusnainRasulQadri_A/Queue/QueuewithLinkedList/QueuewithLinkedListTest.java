import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class QueuewithLinkedListTest {
	private Queue_LinkedList Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object = new Queue_LinkedList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void enqueue_1() {
		Object.enqueue(10);
		Object.enqueue(20);//u
		Object.enqueue(30);
		Object.enqueue(72);
		Assert.assertEquals(10, Object.head.key);//array[Object.removePointer]);
	}
	

	
	@Test
	public void dequeue_1() {
		Object.enqueue(10);
		Object.enqueue(72);
		Object.enqueue(93);
		Object.enqueue(23);
		Assert.assertEquals(10,Object.dequeue());//array[Object.addPointer-1]);
	}
	
	/*This test is to check is we dequeue without enqueueing any value what happens*/
	@Test
	public void dequeue_2() {
		Assert.assertEquals(-1,Object.dequeue());//array[Object.addPointer-1]);
	}

	@Test
	public void display_1() {
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("Empty queue.\r\n"
				+ "", out1.toString());
	}
	
	@Test
	public void display_2() {
		Object.enqueue(10);
		Object.enqueue(72);
		Object.enqueue(93);
		Object.enqueue(23);
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("Queue_LinkedList : 10 72 93 23 \r\n"
				+ "", out1.toString());
	}
}
