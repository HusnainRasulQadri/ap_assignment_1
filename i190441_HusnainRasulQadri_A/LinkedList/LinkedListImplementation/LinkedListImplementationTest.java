import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//import java.util.LinkedList;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LinkedListImplementationTest {
	LinkedList_2 Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	@Before
	public void setup(){
		Object = new LinkedList_2();
		Object.numofElements=0;
		Object.headPointer=null;
		Object.tailPointer=null;
	}

	@After
	public void tearDown() {
	 	Object = null;
	}

	@Test
	public void add() {
		Object.add(92);
		Object.add(64);
		Object.add(72);
		Object.add(22);
		//Object.pushFront();
		Assert.assertEquals(Object.tailPointer.data,22);
	}

	@Test// (expected = Exception.class)
	public void topFront_1() throws Exception {
		Object.add(92);
		Object.add(64);
		Object.add(72);
		Object.add(22);
		Assert.assertEquals(Object.topFront(),92);
	}

	@Test (expected = Exception.class)
	public void topFront_2() throws Exception {
		Object.topFront();
	}

	@Test
	public void topBack_1() throws Exception {
		Object.add(92);
		Object.add(64);
		Object.add(72);
		Object.add(22);
		Assert.assertEquals(Object.topBack(),22);
	}
	@Test (expected = Exception.class)
	public void topBack_2() throws Exception {
		Object.topBack();
	}

	//====================================================
	@Test
	public void pushFront_1() {
		Object.pushFront(10);
		Object.pushFront(20);
		Assert.assertEquals(Object.headPointer.data, 20);//Array
	}


	@Test
	public void pushBack() {
		Object.pushBack(10);
		Object.pushBack(20);
		Assert.assertEquals(20,Object.headPointer.nextPointer.data);//Array
	}
	@Test //(expected = Exception.class)
	public void popFront_1() throws Exception {
		Object.pushFront(34);
		Object.pushFront(54);
		Object.popFront();
		Assert.assertEquals(Object.headPointer.data, 34);//Array
	}

	@Test //(expected = Exception.class)
	public void popFront_2() throws Exception {
		Object.pushFront(24);
		Object.pushFront(66);
		Object.popFront();
		Object.popFront();
		Assert.assertEquals(null,Object.headPointer);//Array
	}

	@Test (expected = Exception.class)
	public void popFront_3() throws Exception {
		Object.popFront();
	}
	
	@Test
	public void size_1() {
		Assert.assertEquals(0,Object.size());
	}
	
	@Test
	public void size_2() {
		Object.pushFront(24);
		Object.pushFront(66);
		Assert.assertEquals(2,Object.size());
	}
	
	@Test
	public void display_1() {
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("LinkedList_2 : [ ]\r\n"
				+ "", out1.toString());	
	}
	@Test
	public void display_2() {
		Object.pushFront(24);
		Object.pushFront(66);
		System.setOut(new PrintStream(out1));
		Object.display();
		assertEquals("LinkedList_2 : [ 66 24 ]\r\n"
				+ "", out1.toString());
	}
}