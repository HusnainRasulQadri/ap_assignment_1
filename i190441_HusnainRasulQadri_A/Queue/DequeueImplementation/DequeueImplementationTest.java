import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class DequeueImplementationTest {
	private Dequeue Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setUp() throws Exception {
		Object= new Dequeue(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addLeft1() {
		Object.addLeft(10);
		Object.addLeft(20);
		assertEquals(20,Object.array[Object.rightPointer]);
	}
	
	@Test
	public void addLeft2() {
		Object.addRight(10);
		Object.addLeft(20);
		assertEquals(20,Object.array[Object.rightPointer]);
	
	}
	
	@Test
	public void addRight1() {
		Object.addRight(10);
		Object.addRight(20);
		Object.addRight(30);
		Object.addRight(40);
		Object.addLeft(50);
		Object.addRight(20);
		assertEquals(40,Object.array[Object.leftPointer]);
		assertEquals(50,Object.array[Object.rightPointer]);
	}
	
	@Test
	public void addRight2() {
		Object.addLeft(14);
		Object.addLeft(23);
		Object.addLeft(43);
		Object.addLeft(23);
		Object.addRight(20);
		assertEquals(20,Object.array[Object.leftPointer]);
	}	
	
	@Test
	public void display() {
		Object.addLeft(14);
		Object.addRight(20);
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("DeQueue : 14 0 0 0 20 \r\n"
				+ "", out1.toString());
	}
}
