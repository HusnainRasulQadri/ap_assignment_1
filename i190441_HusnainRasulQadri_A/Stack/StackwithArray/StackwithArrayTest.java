import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StackwithArrayTest {

	private Stack_Array Object;
	@Before//org.junit.Before
	public void setUp() throws Exception {
		Object = new Stack_Array();
	}
	
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final ByteArrayOutputStream out2 = new ByteArrayOutputStream();
	private final ByteArrayOutputStream out3 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	

	@After//org.junit.After
	public void tearDown() throws Exception {
		Object = null;
	}

	@Test
	public void push_1() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		Assert.assertEquals(Object.array[Object.addPointer-1],11);
		Assert.assertEquals(Object.array[Object.addPointer-2],84);
	}

	@Test
	public void push_2() {
		Object.push(11);
		Assert.assertEquals(11,Object.array[Object.addPointer-1]);
		Assert.assertEquals(-1,Object.addPointer-2);
	}

	@Test
	public void push_3() {
		for(int i=0;i<101;i++) {
			if (i==100) {
				System.setOut(new PrintStream(out2));
			}
			Object.push(i);
		}
		assertEquals("Stack_Array is Full!\r\n", out2.toString());
	}
	
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
	
	@Test
	public void pop_2() {
		Assert.assertEquals(-1,Object.pop());
	}


	@Test
	public void display_1() {
		Object.push(33);
		Object.push(22);
		Object.push(87);
		Object.push(76);
		Object.push(84);
		Object.push(11);
		System.setOut(new PrintStream(out1));
		Object.display();
		
		//System.out.print(out1.toString()+"This");
		assertEquals("Stack_Array : 33 22 87 76 84 11 \r\n", out1.toString());
	}
	
	@Test
	public void display_2() {
		System.setOut(new PrintStream(out3));
		Object.display();
		//System.out.print(out1.toString()+"This");
		assertEquals("Empty Stack_Array.\r\n", out3.toString());
	}


}
