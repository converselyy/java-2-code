// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

import java.util.Stack;

public class Exam_3
{
	/**
	 * Default constructor.
	 */
	public Exam_3() {}
	
	/**
	 * Finds the greatest odd Integer in a Stack of Integers.
	 * @param stack The stack to comb through.
	 * @return The greatest odd Integer, or null if the argument is null or contains no odd numbers.
	 */
	public static Integer greatestOdd(Stack<Integer> stack) {
		if (stack == null) return null;
		Integer temp = 0;
		
		for (int i = 0; i < stack.size(); i++) {
			if (stack.peek() % 2 != 0 && stack.peek() > temp) temp = stack.pop();
		}
		return (temp == 0) ? null : temp;
	}
}
