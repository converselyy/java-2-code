// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package reports;

/**
 * An Exception to be thrown if it is attempted to write a report that has not been processed.
 * The "serialVersionUID" warning can be suppressed.
 * 
 * @author bcline
 */
@SuppressWarnings("serial")
public class DataNotProcessedException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Data not processed, cannot write report".
	 */
	public DataNotProcessedException()
	{
		super("Data not processed, cannot write report");
	}
}