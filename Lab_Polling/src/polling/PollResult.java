// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package polling;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * The PollResult class is used to read the Serialised data of Polling Places stored in a Serialised file.
 * Polling Place data is read from the file and locally stored in an ArrayList of PollingPlaces.
 * It can also process the data, tallying the votes of all Polling Places and storing them in an
 * ArrayList of Integers, and determining the winner of the election.
 * 
 * @auth bcline
 */
public class PollResult
{
	/**
	 * Collection of all the PollingPlace data read from the poll file.
	 */
	private ArrayList<PollingPlace> polls;
	/**
	 * Collection of the tallies of all votes.
	 */
	private ArrayList<Integer> tallies;
	/**
	 * File to read Polling Place data from.
	 */
	private String pollFile;
	/**
	 * The index of tallies that contains the most votes; set in processing.
	 */
	private int mostVotes;
	
	private int numCandidates = 0;
	
	/**
	 * Constructor sets file containing polling data and initialises ArrayLists.
	 * @param pollFileIn File to read polling data.
	 */
	public PollResult(String pollFileIn)
	{
		this.pollFile = pollFileIn;
		this.polls = new ArrayList<PollingPlace>();
		this.tallies = new ArrayList<Integer>();
	}
	
	/**
	 * Opens pollFile and reads PollingPlace data into polls ArrayList. Any duplicate PollingPlaces found
	 * while reading will be ignored and not added to the ArrayList.
	 * @return True if reading successful, false if ClassNotFoundException occurs.
	 * @throws IOException Thrown if poll data file is not found.
	 */
	public boolean readPollFile() throws IOException 
	{
		PollingPlace temp;
		
		try
		{
			FileInputStream file = new FileInputStream(new File(this.pollFile));
			ObjectInputStream stream = new ObjectInputStream(file);
			
			try
			{
				while (true)
				{
					temp = (PollingPlace) stream.readObject();
					if (!this.polls.contains(temp))
					{
						this.polls.add(temp);
						this.numCandidates = // somehow this was over 120 chars
							(temp.getVotesByCandidate().size() > this.numCandidates)
							? temp.getVotesByCandidate().size() : this.numCandidates;
					}
				}
			}
			catch (EOFException u)
			{
				stream.close();
			}
			catch (ClassNotFoundException v)
			{
				stream.close();
				return false;
			}
		}
		catch (FileNotFoundException e)
		{
			throw new IOException();
		}
		return true;
	}
	
	/**
	 * Determines if a PollingPlace is valid. A fraudulent PollingPlace will have a sum of votes
	 * greater than the number of registered voters. NOTE: This is a class helper method and would normally
	 * not be static and be private, but is static and public for testing purposes.
	 * @param p Polling Place to test for fraud.
	 * @return True if the Polling Place is valid, false if it is fraudulent.
	 */
	public static boolean validPollingPlace(PollingPlace p)
	{
		int votes = 0;
		for (int i = 0; i < p.getVotesByCandidate().size(); i++)
		{
			votes += p.getVotesByCandidate().get(i);
		}
		return votes <= p.getRegisteredVoters();
	}
	
	/**
	 * Tallies all of the votes from the Collection of Polling Places. The order of candidates in the
	 * PollingPlace's votes is assumed to be the same for all instances of PollingPlace. The tallies of the
	 * votes are stored in the tallies ArrayList in this same order. Fraudulent Polling Places as determined
	 * by the validPollingPlace method are ignored in the tallying process. Updates the mostVotes index.
	 */
	public void processPoll()
	{
		int temp = 0; // for the maximum below
		
		// populate the ArrayList with zeros
		for (int i = 0; i < this.numCandidates; i++)
		{
			this.tallies.add(0);
		}
		
		// re-populate with candidate votes
		for (int i = 0; i < this.polls.size(); i++)
		{
			if (validPollingPlace(this.polls.get(i)))
			{
				for (int j = 0; j < this.polls.get(i).getVotesByCandidate().size(); j++)
				{
					this.tallies.set(j, this.tallies.get(j) + 
						this.polls.get(i).getVotesByCandidate().get(j));
				}
			}
		}
		
		for (int i = 0; i < this.tallies.size(); i++)
		{
			if (this.tallies.get(i) > temp)
			{
				this.mostVotes = i;
				temp = this.tallies.get(i);
			}
		}
	}
	
	/**
	 * Returns a String representation of this PollResult.
	 * 
	 * String is of the form:
	 * Candidate 1: VOTES
	 * Candidate 2: VOTES
	 * ...
	 * Winner - Candidate WINNER
	 * 
	 * Candidates are listed as numerical values starting with the number 1, followed by the number of
	 * votes that candidate received. The number of candidates listed depends on the number of candidates
	 * in the Polling data. The winner is listed as the number of the candidate.
	 * 
	 * @return Results of the Poll.
	 */
	@Override
	public String toString()
	{
		String out = "";
		for (int i = 0; i < this.tallies.size(); i++)
		{
			out += String.format("Candidate %d: %d\n", i + 1, this.tallies.get(i));
		}
		out += String.format("Winner - Candidate %d", this.mostVotes + 1);
		
		return out;
	}
	
	/**
	 * Returns the polls ArrayList.
	 * @return The polls ArrayList.
	 */
	public ArrayList<PollingPlace> getPolls()
	{
		return this.polls;
	}
	
	/**
	 * Returns the tallies ArrayList.
	 * @return The tallies ArrayList.
	 */
	public ArrayList<Integer> getTallies()
	{
		return this.tallies;
	}
	
	/**
	 * Returns the index with the most votes.
	 * @return The index with the most votes.
	 */
	public int getMostVotes()
	{
		return this.mostVotes;
	}
	
}
