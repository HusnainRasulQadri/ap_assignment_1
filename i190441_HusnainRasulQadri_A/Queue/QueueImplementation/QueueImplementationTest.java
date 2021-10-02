import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class QueueImplementationTest {
private Queue Object;

private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object = new Queue(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void enqueue_1() throws Exception {
		Object.enqueue(10);
		Object.enqueue(20);//u
		Object.enqueue(30);
		Object.enqueue(72);
		Assert.assertEquals(10, Object.array[Object.removePointer]);
	}
	
	
	/*This test is to check whether the code break if we do more enqueue's then available space*/
	@Test (expected = Exception.class)
	public void enqueue_2() throws Exception {
		Object.enqueue(10);
		Object.enqueue(20);//u
		Object.enqueue(30);
		Object.enqueue(72);
		Object.enqueue(93);
		Object.enqueue(23);
		Assert.assertEquals(93,Object.array[Object.addPointer-1]);
	}
	
	@Test
	public void dequeue_1() throws Exception {
		Object.enqueue(10);
		Object.enqueue(72);
		Object.enqueue(93);
		Object.enqueue(23);
		Assert.assertEquals(10,Object.dequeue());//array[Object.addPointer-1]);
	}
	
	/*This test is to check is we dequeue without enqueueing any value what happens*/
	@Test ( expected = Exception.class)
	public void dequeue_2() throws Exception {
		Assert.assertEquals(-1,Object.dequeue());//array[Object.addPointer-1]);
	}
	
	@Test
	public void empty_1() {
		Assert.assertEquals(true, Object.empty());//.empty
	}
	@Test
	public void empty_2() throws Exception {
		Object.enqueue(10);
		Object.enqueue(72);
		Assert.assertEquals(false, Object.empty());//.empty
	}
	@Test
	public void size() throws Exception {
		Object.enqueue(10);
		Object.enqueue(72);
		Assert.assertEquals(2, Object.size());
	}
	@Test
	public void display_1() {
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("Empty Queue.\r\n"
				+ "", out1.toString());
	}
	@Test
	public void display_2() throws Exception {
		Object.enqueue(10);
		Object.enqueue(72);
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("Queue : 10 72 \r\n"
				+ "", out1.toString());
	}
}
