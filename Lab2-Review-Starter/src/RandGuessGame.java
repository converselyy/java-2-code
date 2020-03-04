// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: I checked the Random class docs for a getSeed() method. No such thing, apparently.

import java.util.Random;

/**
 * Class for a simple, randomized guessing game. Five integer values between 1 and MAX_VALUE (inclusive) will be
 * generated. Only the first and last will be shown to the player. The player must then guess if the sum
 * of all of the numbers is greater than the possible average or not.
 *
 * @author bcline
 */
public class RandGuessGame
{
	// declarations
	private static final int ARR_SIZE = 5;
	private static final int MAX_VALUE = 100;
	private int[] numbers = new int[ARR_SIZE];
	private int guessTarget;
	private char guess;
	private int arraySum = 0;
	private boolean hideMiddleVals;
	private Random rand = new Random();
	
	// constructors
	/**
	 * Creates a random guessing game object.
	 * @param temp Random object to be used for a given instance of the game.
	 */
	public RandGuessGame(Random temp)
	{
		this.rand = temp;
		this.guessTarget = numbers.length * (MAX_VALUE / 2);
		this.hideMiddleVals = true;
	}
	
	/**
	 * Populates the numbers array with random numbers between 1 and MAX_VALUE.
	 */
	public void populateArray()
	{
		for (int i = 0; i < numbers.length; i++)
		{
			numbers[i] = 1 + rand.nextInt(MAX_VALUE);
			this.arraySum += numbers[i];
		}
	}
	
	/**
	 * Toggles the value of hideMiddleVals.
	 */
	public void toggleHidden()
	{
		this.hideMiddleVals = !(this.hideMiddleVals);
	}
	
	/**
	 * Returns a String containing the values in the "numbers" array on a single line, separated by spaces
	 * with the middle values hidden or all visible based on value of "hideMiddleValue" data member. There is
	 * a trailing space on the end, so an example String returned may be: "5 X X X 67 ". NOTE: This does not
	 * output to System.out, it generates and returns a String.
	 * 
	 * @return A String with the values of the numbers array. Middle values are hidden if hideMiddleValueis true.
	 */
	public String toString()
	{
		if (hideMiddleVals)
		{
			return String.format("%d X X X %d ", numbers[0], numbers[4]);
		}
		else
		{
			return String.format("%d %d %d %d %d ", numbers[0],
				numbers[1], numbers[2], numbers[3], numbers[4]);
		}
	}
	
	/**
	 * Accepts a user's guess for the game. Validates that it is either the character 'Y' or 'N'. If it
	 * is a valid guess, sets the guess data member to the passed value and returns true. If it is not
	 * valid it does not change the value of guess and returns false.
	 * 
	 * @return True if the passed guess is valid, false if it is not.
	 */
	public boolean validatePlayerGuess(char temp)
	{
		if (temp == 'Y' || temp == 'N')
		{
			this.guess = temp;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns whether the player is correct or not.
	 * @return True if the player is correct, false if not.
	 */
	private boolean isCorrect()
	{
		if (this.guess == 'Y')
		{
			return this.arraySum > this.guessTarget;
		}
		else
		{
			return this.arraySum < this.guessTarget;
		}
	}
	
	/**
	 * Checks to see if player's guess was correct, and constructs and returns a String that reports if they
	 * are correct or incorrect, and appends the correct sum of the array.
	 * 
	 * @return A String reporting the results of the game.
	 */
	public String getResult()
	{
		if (this.isCorrect())
		{
			return String.format("You guessed correctly! The sum was %d!", this.arraySum);
		}
		else
		{
			return String.format("You guessed wrong! The sum was %d!", this.arraySum);
		}
	}
	
	/**
	 * Retrieves the numbers array. Used for testing, do not change.
	 * 
	 * @return The numbers array.
	 */
	public int[] getNumbers()
	{
		return numbers;
	}
	
	/**
	 * Retrieves the sum of the numbers in the array. Used for testing, do not change.
	 * @return The value of arraySum.
	 */
	public int getArraySum()
	{
		return arraySum;
	}
}
