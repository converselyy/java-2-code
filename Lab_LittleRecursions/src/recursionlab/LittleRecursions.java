// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: I looked into getting subsets of arrays. Unfortunately, Arrays.copyOfRange
// requires importing a library which I'm guessing you'd prefer me not do, so I just decided
// to make my own.

package recursionlab;

////////////////////////////////////////////////////////////
//
// NOTE: No loops or fields are allowed in this file!
//       Solve these methods using only 
//       recursion.  
//
//       Use of fields will be penalized by WebCAT testing,
//       and points will be scaled proportionally based on 
//       your use of recursion.  If you use for/while to solve
//       these problems you will have points deducted!
//
////////////////////////////////////////////////////////////

/**
 * Class containing some recursive methods.
 * 
 * @author bcline
 */
public class LittleRecursions
{
	/**
	 * Determines if a given String is a palindrome
	 * (meaning it is the same forwards and backwards).
	 * Comparison of characters are not case sensitive.
	 * 
	 * <p>Thus, the following are palindromes
	 * <br>RACECAR
	 * <br>rAcECar
	 * <br>aBbA
	 * <p>The following are NOT palindromes
	 * <br>DOG
	 * <br>Taylor Swift
	 * <br>OO00
	 * 
	 * @param s The string to check for palindrome status.
	 * @return True if and only if s is a palindrome; false otherwise.
	 */
	public static boolean isPalindrome(String s)
	{
		String t = s.toUpperCase();
		return (t == null) ? false : (t.equals("") || t.length() == 1)
			? true : (t.charAt(0) == t.charAt(t.length() - 1))
				? isPalindrome(t.substring(1, t.length() - 1)) : false;
	}
	
	/**
	 * Creates a string like the one given in the input parameter, but
	 * with all letters in reverse order. All non-letters will be
	 * removed from the final string. For example:
	 * 
	 * <p>reverseSome("asdf") ==> "fdsa"
	 * <br>reverseSome("this is a test") ==> "tsetasisiht"
	 * <br>reverseSome("ABC 123!") ==> "CBA"
	 * 
	 * @param s The string to reverse.
	 * @return A version of s in which all letter characters are in
	 * the reverse order of the original.
	 */
	public static String reverseSome(String s)
	{
		String t = s.replaceAll("[^A-Za-z]", "");
		return (t == null || t.equals("")) ? "" : reverseSome(t.substring(1)) + t.charAt(0);
	}
	
	/**
	 * This method computes the greatest common divisor of two numbers using Euclid's algorithm. 
	 * 
	 * <p>Mathematically, gcd is recursively defined as:
	 * <br>gcd(x, 0) = x
	 * <br>gcd(x, y) = gcd(y, x mod y)
	 * 
	 * @param x The first operand in the greatest common divisor.
	 * @param y The second operand in the greatest common divisor.
	 * @return The greatest common divisor of x and y.
	 */
	public static int gcd(int x, int y)
	{
		return (y == 0) ? x : gcd(y, x % y);
	}
	
	/**
	 * Computes the sum of all positive values in the array parameter.
	 * 
	 * @param array The array of values to consider
	 * @return The additive sum of all integers in array that are positive.
	 * The sum will be 0 when the array parameter is null.  
	 */
	public static int sumPositive(int[] array)
	{
		return (array == null) ? 0 : helper(array.length - 1, array);
	}
	
	/**
	 * 
	 * @return
	 */
	public static int helper(int n, int[] temp)
	{
		return (n >= 0) ? (temp[n] > 0) ? temp[n] + helper(n - 1, temp) : helper(n - 1, temp) : 0;
	}
}
