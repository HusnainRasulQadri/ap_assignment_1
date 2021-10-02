import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayDeletionTest {
	private ArrayDeletion Object;
	private int [] array;
	
	private final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	private final PrintStream out = System.out;
	
	@Before
	public void setUp() throws Exception {
		Object = new ArrayDeletion();
		array = new int[] {1, 6, 34, 0, 2, 43};
		System.setOut(new PrintStream(out1));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(out);
	}

	/*Random deletion from the array*/
	@Test
	public void ArrayDeletion_0() {
		int [] a = Object.delete_stub(array,3);
		
		
		assertArrayEquals(new int [] {1, 6, 34, 2, 43, -1} ,array);
	}

	/*Deletion from the largest index*/
	@Test
	public void ArrayDeletion_1() {
		int [] a = Object.delete_stub(array,5);
		Assert.assertArrayEquals(new int[] {1, 6, 34, 0, 2, -1},a);//,-1
	}

	/*Checking out of bound deletion (upper bound)*/
	@Test //(expected = ArrayIndexOutOfBoundsException.class)
	public void ArrayDeletion_2() {
		int [] a=Object.delete_stub(array,101);
		Assert.assertArrayEquals(new int[] {1, 6, 34, 0, 2, 43},a);//,-1
	}

	

	@Test
	public void display() {
		Object.display(array);
		 assertEquals("1 6 34 0 2 43 \r\n", out1.toString());

	}
}