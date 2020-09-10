// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

public class Digit
{
	/**
	 * Recursively finds the sum of the digits in a given integer.
	 * @param d The integer whose digits to find the sum of.
	 * @return The sum of the integer's digits.
	 */
	public static int sum(int d) {
		return helper(d, Integer.toString(d).length());
	}
	
	/**
	 * Helper function including length as a parameter.
	 * @param d Integer to be added.
	 * @param l Length of the integer.
	 * @return The sum of the integer's digits.
	 */
	public static int helper(int d, int l) {
		d = Math.abs(d);
		return d % 10 == 0 && l == 0 ? 0 : d % 10 + helper(d / 10, l - 1);
	}
}