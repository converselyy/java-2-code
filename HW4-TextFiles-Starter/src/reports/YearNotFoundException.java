// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: bcline
// RESOURCES: No external resources were referenced or used.

package reports;

/**
 * An Exception to be thrown if a requested year is not present in the data set.
 * The "serialVersionUID" warning can be suppressed.
 * 
 * @author bcline
 */
@SuppressWarnings("serial")
public class YearNotFoundException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Requested year not in file".
	 */
	public YearNotFoundException()
	{
		super("Requested year not in file");
	}
}