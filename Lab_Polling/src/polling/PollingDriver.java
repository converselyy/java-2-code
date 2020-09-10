package polling;

import java.io.IOException;
import java.util.Scanner;

/**
 * Driver for PollResult.
 * @author Patrick Cavanaugh
 */
public class PollingDriver
{
	/**
	 * Execution entry point.
	 * @param args Command line arguments not used.
	 */
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String pollFile;
		PollResult poll;
		//Get name of file
		//Valid files are "vote1.ser" and "vote2.ser"
		System.out.print("Enter name of poll file: ");
		pollFile = input.next();
		//Create the PollResult object
		poll = new PollResult(pollFile);
		
		try
		{
			//Read the file
			if (poll.readPollFile())
			{
				//If successful process and output poll
				poll.processPoll();
				System.out.println(poll);
			}
			else
			{
				//If you are getting this output you may have altered the PollingPlace class!
				System.out.println("Error reading PollingPlace Object");
			}
		}
		catch (IOException ioe)
		{
			//File not present
			System.out.println("Poll file not found!");
		}
		input.close();
	}
}
