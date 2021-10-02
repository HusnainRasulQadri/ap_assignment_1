import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class LinkedListTest {
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
    @Before
	public void setUp() throws Exception {
    	LinkedList Object= new LinkedList(); //To test constructor
	}

	@After
	public void tearDown() throws Exception {
		LinkedList.head=null;
	}

	@Test
	public void pushFront_1() {
		LinkedList.pushFront(10);
		LinkedList.pushFront(20);
		Assert.assertEquals(LinkedList.head.key, 20);//Array
	}
	
	
	@Test
	public void pushBack() {
		LinkedList.pushBack(10);
		LinkedList.pushBack(20);
		Assert.assertEquals(LinkedList.head.next.key, 20);//Array
	}
	@Test
	public void popFront_1() {
		LinkedList.pushFront(34);
		LinkedList.pushFront(54);
		LinkedList.popFront();
		Assert.assertEquals(LinkedList.head.key, 34);//Array
	}
	
	@Test
	public void popFront_2() {
		LinkedList.pushFront(24);
		LinkedList.pushFront(66);
		LinkedList.popFront();
		LinkedList.popFront();
		Assert.assertEquals(null,LinkedList.head);//Array
	}
	
	@Test
	public void popFront_3() {
		LinkedList.popFront();
		Assert.assertEquals(null,LinkedList.head);//Array
	}
	
	@Test
	public void popBack_1() {
		LinkedList.pushFront(34);
		LinkedList.pushFront(54);
		LinkedList.popBack();
		Assert.assertEquals(LinkedList.head.next, null);//Array		
	}
	
	@Test
	public void popBack_2() {
		LinkedList.pushFront(91);
		LinkedList.pushFront(89);
		LinkedList.popBack();
		LinkedList.popBack();
		Assert.assertEquals(null,LinkedList.head);//Array.next, null
	}
	
	@Test
	public void popBack_3() {
		LinkedList.popBack();
		Assert.assertEquals(null,LinkedList.head);//Array.next, null
	}
	
	@Test 
	public void pop_1() {
		LinkedList.pushFront(92);
		LinkedList.pushFront(34);
		LinkedList.pushFront(54);
		LinkedList.pop(1);
		Assert.assertEquals(LinkedList.head.next.key,92);
	}
	
	@Test 
	public void pop_2() {
		LinkedList.pushFront(92);
		LinkedList.pushFront(34);
		LinkedList.pushFront(54);
		LinkedList.pop(1);
		LinkedList.pop(1);
		LinkedList.pop(0);
		Assert.assertEquals(null,LinkedList.head);//.next.key,92
	}
	
	@Test 
	public void pop_3() {
		LinkedList.pop(0);
		Assert.assertEquals(null,LinkedList.head);//.next.key,92
	}
	
	/*T*/
	@Test
	public void pop_4() {
		LinkedList.pushFront(92);
		LinkedList.pushFront(34);
		LinkedList.pushFront(54);
		Assert.assertEquals(54,LinkedList.head.key);//.next.key,9254
		Assert.assertEquals(34,LinkedList.head.next.key);//.next.key,9254
		Assert.assertEquals(92,LinkedList.head.next.next.key);//.next.key,9254
	}
	
	@Test
	public void display_1() {
		LinkedList.pushFront(92);
		LinkedList.pushFront(34);
		LinkedList.pushFront(54);
		System.setOut(new PrintStream(out1));
		LinkedList.display();
		 assertEquals("LinkedList : 54 34 92 \r\n"
		 		+ "", out1.toString());
	}
	
	@Test
	public void display_2() {
		System.setOut(new PrintStream(out1));
		LinkedList.display();
		 assertEquals("LinkedList :  \r\n"
		 		+ "", out1.toString());
	}


}