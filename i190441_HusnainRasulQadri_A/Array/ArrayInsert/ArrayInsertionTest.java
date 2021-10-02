import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayInsertionTest {
	//Declaring the class object and array for testing
	private ArrayInsertion Object;
	private int [] array;
	
	

	@Before
	public void setUp() throws Exception {
		//memory allocation for both object and array
		Object = new ArrayInsertion();
		Object.size=0;
		array = new int [10];
		
	}

	@After
	public void tearDown() throws Exception {
		Object = null;
		array = null;
		
	}

	/* This test is for simple data insertion in array
	* at a given random index with random value*/
	@Test
	public void test_1() {
		Assert.assertArrayEquals(new int [] {0,0,10,0,0,0,0,0,0,0},Object.insert(array, 10, 2));
	}

	/*This test is inserting random values at every index starting from 0 till 9
	* This test is to test whether array fills completely accessing every index*/
	/*This test fails due to an error in the code where he moves existing integers
	 *  and access index out of bound*/
	@Test
	public void test_2() {
		array=Object.insert(array,1,0);
		array=Object.insert(array,56,1);
		array=Object.insert(array,5,2);
		array=Object.insert(array,90,3);
		array=Object.insert(array,12,4);
		array=Object.insert(array,11,5);
		array=Object.insert(array,2,6);
		array=Object.insert(array,16,7);
		array=Object.insert(array,11,8);
		array=Object.insert(array,16,9);
		Assert.assertArrayEquals(new int [] {1,56,5,90,12,11,2,16,11,16},array);
	}

	/*This test is accessing array at index out of bound at the upper bound*/
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void test_3() {
		Object.insert(array,16,11);
	}

	/*This test is accessing array at index out of bound at the lower bound*/
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void test_4() {
		Object.insert(array,16,-1);
	}

	

	/*This test access the array at the extreme points to see whether they are taken care of and works properly*/
	@Test
	public void test_5() {
		array = Object.insert(array,1,0);
		array = Object.insert(array,16,9);
		Assert.assertArrayEquals(new int [] {1,0,0,0,0,0,0,0,0,16}, array);
	}
	
	
}