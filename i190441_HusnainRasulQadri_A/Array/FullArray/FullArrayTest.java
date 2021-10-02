import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FullArrayTest {
	private Array Object;
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;

	@Before
	public void setUp() throws Exception {
		Object = new Array();
		System.setOut(new PrintStream(out1));
	}

	@After
	public void tearDown() throws Exception {
		Object = null;
		System.setOut(out);
	}


	@Test
	public void insert_1() {
		Object.insert(110,2);
		Assert.assertEquals(110, Object.array[2]);
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void insert_2() {
		Object.insert(145,100);
		Assert.assertEquals(145, Object.array[100]);
	}

	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void insert_3() {
		Object.insert(110,-1);
		Assert.assertEquals(110, Object.array[-1]);
	}

	@Test //(expected = ArrayIndexOutOfBoundsException.class)
	public void insert_4() {
		Object.insert(110,0);
		Assert.assertEquals(110, Object.array[0]);//[0]
		Object.insert(110,99);
		Assert.assertEquals(110, Object.array[99]);
	}
	
	@Test //(expected = ArrayIndexOutOfBoundsException.class)
	public void insert_5() {
		Object.insert(110,0);
		
		Object.insert(10,2);
		Object.insert(12,1);
		Assert.assertEquals(110, Object.array[0]);
		Assert.assertEquals(10, Object.array[2]);
		Assert.assertEquals(12, Object.array[1]);
	}

	@Test
	public void delete_1() {
		//Assert.assertEquals(Object.insert(110,2)[2],110);_stub_stub
		Object.insert(110,2);
		Object.delete(2);
		Assert.assertEquals(0,Object.size);
	}

	/*Checking deletion fro the extreme two ends*/
	@Test
	public void delete_2() {
		Object.insert(110,2);
		Object.insert(242,4);
		Object.insert(972,3);
		Object.insert(1646,99);
		Object.insert(267,0);
		Assert.assertEquals(5,Object.size);
		Object.delete(0);
		Assert.assertEquals(4,Object.size);
		Object.delete(99);
		Assert.assertEquals(3,Object.size);
		

	}

	@Test
	public void display() {
		Object.insert(267,0);
		Object.insert(1646,1);
		Object.insert(110,2);
		Object.insert(972,3);
		Object.insert(242,4);
		Object.display();
		
		Assert.assertEquals("267 1646 110 972 242 \r\n", out1.toString() );
	}

	/*Test if the search is successful*/
	@Test (timeout = 100)
	public void linearSearch_1() {
		Object.insert(110,2);
		Object.insert(242,4);
		Object.insert(972,3);
		Object.insert(1646,1);
		Object.insert(267,0);
		Assert.assertEquals(true,Object.linearSearch(110));//true
	}

	/*Test if the number is not found*/
	@Test (timeout = 100)
	public void linearSearch_2() {
		Object.insert(110,2);
		Object.insert(242,4);
		Object.insert(972,3);
		Object.insert(1646,1);
		Object.insert(267,0);
		Assert.assertEquals(false,Object.linearSearch(211));//1
	}

	/*Test if the array is empty*/
	@Test (timeout = 100)
	public void linearSearch_3() {
		Assert.assertEquals(false, Object.linearSearch(211));//1
	}

	/*Normal test checking if the sort works*/
	@Test (timeout = 100)
	public void bubbleSort() {
		int [] ans = {110,242,267,972,1646};//new int [100];//
		Object.insert(267,0);
		Object.insert(1646,1);
		Object.insert(110,2);
		Object.insert(972,3);
		Object.insert(242,4);
	
		
		Object.bubbleSort();//_stub
		
		Assert.assertEquals(ans[0],Object.array[0]);//Equals(Object.bubbleSort_stub());
		Assert.assertEquals(ans[1],Object.array[1]);
		Assert.assertEquals(ans[2],Object.array[2]);
		Assert.assertEquals(ans[3],Object.array[3]);
		Assert.assertEquals(ans[4],Object.array[4]);
	}

	/*If the array is empty will bubble sort will work fine*/
	@Test (timeout = 100)
	public void bubbleSort_2(){
		int [] ans = new int[100];
		Object.bubbleSort();
		Assert.assertArrayEquals(ans,Object.array);//Equals(Object.bubbleSort_stub());//_stub
	}

	@Test
	public void binarySearch() {
		Object.insert(267,0);
		Object.insert(1646,1);
		Object.insert(110,2);
		Object.insert(972,3);
		Object.insert(242,4);
		
		
		Assert.assertEquals(true,Object.binarySearch(267,0,6));
	}

	@Test
	public void binarySearch_2() {
		Object.insert(110,2);
		Object.insert(242,4);
		Object.insert(972,3);
		Object.insert(1646,1);
		Object.insert(267,0);
		Assert.assertEquals(false,Object.binarySearch(333,0,6));
	}

	@Test
	public void binarySearch_3() {
		Assert.assertEquals(false,Object.binarySearch(333,0,6));
	}

	@Test
	public void binarySearch_4() {
		Object.insert(110,2);
		Object.insert(242,4);
		Object.insert(972,3);
		Object.insert(1646,1);
		Object.insert(267,0);
		Assert.assertEquals(false,Object.binarySearch(333,-1,6));
	}
}