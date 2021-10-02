import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class QueuewithArrayTest {
	private Queue_Array Object;

	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object = new Queue_Array(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void enqueue_1() {
		Object.enqueue(10);
		Object.dequeue();
		Object.enqueue(72);
		assertEquals(72, Object.array[Object.removePointer]);
	}
	
	
	/*This test is to check whether the code break if we do more enqueue's then available space*/
	@Test
	public void enqueue_2() {
		Object.enqueue(10);
		Object.enqueue(20);//u
		Object.enqueue(30);
		Object.enqueue(72);
		Object.enqueue(93);
		System.setOut(new PrintStream(out1));
		Object.enqueue(23);
		assertEquals("Queue_Array is Full.\r\n"
				+ "", out1.toString());
	}
	
	@Test
	public void dequeue_1() {
		Object.enqueue(10);
		Object.enqueue(72);
		Object.enqueue(93);
		Object.enqueue(23);
		Object.enqueue(92);
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
		 assertEquals("Empty Queue_Array.\r\n"
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
		assertEquals("Queue_Array : 10 72 93 23 \r\n"
				+ "", out1.toString());
	
	}
}
