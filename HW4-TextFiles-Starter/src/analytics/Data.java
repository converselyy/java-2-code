// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package analytics;

/**
 * Set of useful reusable tools for analyzing sets of data.
 * 
 * @author bcline
 */
public class Data
{
	/**
	 * Finds the minimum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * 
	 * @param <E> Type of data passed. The type must implement the Comparable interface.
	 * @param data Collection of data to find minimum value of.
	 * 
	 * @return Minimum value in passed data.
	 */
	public static <E extends Comparable<E>> E minimum(E[] data)
	{
		E temp = data[0];
		for (E item : data)
		{
			if (item == null)
			{
				break;
			}
			if (item.compareTo(temp) < 0)
			{
				temp = item;
			}
		}
		return temp;
	}

	/**
	 * Finds the maximum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * 
	 * @param <E> Type of data passed. The type must implement the Comparable interface.
	 * @param data Collection of data to find maximum value of.
	 * 
	 * @return Maximum value in passed data.
	 */
	public static <E extends Comparable<E>> E maximum(E[] data)
	{
		E temp = data[0];
		for (E item : data)
		{
			if (item == null)
			{
				break;
			}
			if (item.compareTo(temp) > 0)
			{
				temp = item;
			}
		}
		return temp;
	}
	
	/**
	 * Finds the average of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * 
	 * @param <N> Type of data passed. The type must extend the Number class.
	 * See the assignment supplemental for useful information on the Number class.
	 * @param data Collection of data to find average of.
	 * 
	 * @return Average of passed data. Regardless of type passed will always return a Double.
	 * This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 * which it should do automatically.
	 */
	public static <N extends Number> Double average(N[] data)
	{
		Double temp = 0.0;
		int count = 0;
		for (N item : data)
		{
			if (item == null)
			{
				break;
			}
			temp = temp + item.doubleValue();
			count++;
		}
		return temp / count;
	}
	
	/**
	 * Finds the population standard deviation of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * 
	 * @param <N> Type of data passed. The type must extend the Number class.
	 * See the assignment supplemental for useful information on the Number class.
	 * @param data Collection of data to find standard deviation of.
	 * 
	 * @return Population Standard Deviation of passed data. Regardless of type passed will
	 * always return a Double. This means if no results are in data it will return Double's
	 * "Divide By 0" value, NaN, which it should do automatically.
	 */
	public static <N extends Number> Double standardDeviation(N[] data)
	{
		return Math.sqrt(Math.pow(sum(data), 2.0) / data.length);
	}
	
	/**
	 * Finds the sum of an array as a double.
	 * @param <N> Type of data passed. The type must extend the Number class.
	 * @param data The array of data to sum up.
	 * @return The sum of the array's elements as a double.
	 */
	public static <N extends Number> Double sum(N[] data)
	{
		Double temp = 0.0;
		for (N item : data)
		{
			if (item == null)
			{
				break;
			}
			temp = temp + item.doubleValue();
		}
		return temp;
	}
}
