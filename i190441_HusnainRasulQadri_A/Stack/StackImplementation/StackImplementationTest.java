import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackImplementationTest {
	MyStack Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	
	@Before
	public void setUp() throws Exception {
		Object = new MyStack(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void push() throws Exception {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(11,Object.arraytostoreStack[Object.topPointer]);
	}
	@Test
	public void push_1() throws Exception {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(Object.arraytostoreStack[Object.topPointer],11);//arrayto
		Assert.assertEquals(Object.arraytostoreStack[Object.topPointer-1],84);
	}

	@Test
	public void push_2() throws Exception {
		Object.push(23);
		Assert.assertEquals(Object.arraytostoreStack[Object.topPointer],23);//arrayto
		Assert.assertEquals(0,Object.topPointer);
	}

	@Test (expected = Exception.class)
	public void push_3() throws Exception {
		for (int i=0;i<11;i++) {
			Object.push(i);
		}
	}

	

	@Test
	public void top_1() throws Exception {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(Object.top(),11);
	}

	@Test (expected = Exception.class)
	public void top_2() throws Exception {
		Object.top();
	}

	
	@Test
	public void pop_1() throws Exception {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(11,Object.pop());
	}
	
	@Test (expected = Exception.class)
	public void pop_2() throws Exception {
		Object.pop();
	}


	@Test
	public void display() throws Exception {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		System.setOut(new PrintStream(out1));
		Object.displayStack();
		assertEquals("Stack : [ 33 22 87 76 ]\r\n"
				+ "", out1.toString());
	}

	@Test//org.junit.Test
	public void getSize() throws Exception {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Assert.assertEquals(4,Object.size());
	}

}
