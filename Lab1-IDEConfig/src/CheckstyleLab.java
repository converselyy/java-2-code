// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: None

/**
 * @author Brandon Cline bcline@unomaha.edu
 * Program for Lab 1 of CSCI 1620
 */
public class CheckstyleLab
{
	/**
	 * Main method which calculates the sum of the squares of the integers 1 to 10 inclusive.
	 * @param args Command line arguments (Unused)
	 */
	public static void main(final String[] args)
	{
		int[] squares = new int[10];

		for (int i = 0; i < 10; i++)
		{
			squares[i] = (int) Math.pow(i + 1, 2);
			System.out.printf("Square of %d is %d\n", i + 1, squares[i]);
		}

		System.out.printf("The sum of the squares is %d!", sumArray(squares));

	}

	/**
	 * this method returns the sum of the values in the arr parameter or zero when
	 * arr is null.
	 * 
	 * @param arr Array whose elements are to be added up
	 * @return sum The sum of the elements in the array arr
	 */
	public static int sumArray(final int[] arr)
	{
		int sum = 0;
		
		if (arr != null)
		{
			for (int i : arr)
			{
				sum += i;
			}
		}
		return sum;
	}
}