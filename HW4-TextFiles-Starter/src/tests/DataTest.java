// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import analytics.Data;

/**
 * JUnit tests for the Data class.
 * 
 * @author bcline
 */
public class DataTest
{
	/*********** Maximum Tests ***********/
	/**
	 * Testing the maximum method with normal valid data.
	 */
	@Test
	public void testMaximumValid() {
		Integer[] temp = { 234, 354, 3246, 234 };
		assertEquals((int) 3246, (int) Data.maximum(temp));
	}
	
	/**
	 * Testing the maximum method with one null value.
	 */
	@Test
	public void testMaximumNullValue() {
		Integer[] temp = { 234, 154246, 5423, null, 134243, 134235134 };
		assertEquals((int) 154246, (int) Data.maximum(temp));
	}
	
	/**
	 * Testing the maximum method with an array full of zeros.
	 */
	@Test
	public void testMaximumArrayOfZeros() {
		Integer[] temp = { 0, 0, 0, 0, 0, 0 };
		assertEquals((int) 0, (int) Data.maximum(temp));
	}
	
	/*********** Minimum Tests ***********/
	/**
	 * Testing the minimum method with a valid array.
	 */
	@Test
	public void testMinimumValid() {
		Integer[] temp = { 512, 234, 354, 3246, 234 };
		assertEquals((int) 234, (int) Data.minimum(temp));
	}
	
	/**
	 * Testing the minimum method with an array containing a null.
	 */
	@Test
	public void testMinimumNullValue() {
		Integer[] temp = { 134, 2531, 0, 134, 1, null, 2590, -1 };
		assertEquals((int) 0, (int) Data.minimum(temp));
	}
	
	/*********** Average Tests ***********/
	/**
	 * Testing the average method with a normal array.
	 */
	@Test
	public void averageTestValid() {
		Integer[] temp = { 1423, 253, 134, 525, 1235, 215, 121, 3215 };
		assertEquals(890.125, (double) Data.average(temp), 0.001); // deprecated, apparently.
	}
	
	/*********** Sum Tests ***********/
	/**
	 * Testing sum with a valid set of Integers.
	 */
	@Test
	public void sumTestValid() {
		Integer[] temp = { 134, 23465, 123, 3215, 6313, 0 };
		assertEquals(33250.0, Data.sum(temp).doubleValue(), 0.0);
	}
	
	/**
	 * Testing sum with an array of Integers including a null.
	 */
	@Test
	public void sumTestNullValue() {
		Integer[] temp = { 2154, null, 246, 14, 3245 };
		assertEquals(2154.0, (double) Data.sum(temp), 0.0);
	}
}
