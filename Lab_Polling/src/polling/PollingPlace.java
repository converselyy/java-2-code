// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: This file.

package polling;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for a single Polling Place in a voting district.
 * @author Patrick Cavanaugh
 */
public class PollingPlace implements Serializable
{
	/**
	 * Numerical id for the Polling Place.
	 */
	private int pollingPlaceId;
	/**
	 * Number of registered voters assigned to this Polling Place.
	 */
	private int registeredVoters;
	/**
	 * Number of votes for each candidate in the order they appear on the ballot.
	 */
	private ArrayList<Integer> votesByCandidate;
	
	/**
	 * Constructor sets all members of the instance.
	 * @param pollingPlaceIdIn Id of the Polling Place.
	 * @param registeredVotersIn Number of voters assigned to the Polling Place.
	 * @param votesByCandidateIn Submitted votes at the Polling Place.
	 */
	public PollingPlace(int pollingPlaceIdIn, int registeredVotersIn, ArrayList<Integer> votesByCandidateIn)
	{
		pollingPlaceId = pollingPlaceIdIn;
		registeredVoters = registeredVotersIn;
		votesByCandidate = votesByCandidateIn;
	}
	
	/**
	 * Returns the Polling Place Id.
	 * @return Polling Place Id.
	 */
	public int getPollingPlaceId()
	{
		return pollingPlaceId;
	}
	
	/**
	 * Returns the number of registered voters.
	 * @return Number of registered voters for this Polling Place.
	 */
	public int getRegisteredVoters()
	{
		return registeredVoters;
	}
	
	/**
	 * Returns all of the votes at this Polling Place.
	 * @return ArrayList of votes for all Candidates.
	 */
	public ArrayList<Integer> getVotesByCandidate()
	{
		return votesByCandidate;
	}
	
	/**
	 * Equality of Polling Places is determined by Polling Place Id.
	 * @return True if the two Polling Places are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object other)
	{
		return pollingPlaceId == ((PollingPlace) other).pollingPlaceId;
	}
	
	/**
	 * String representation of this Polling Place.
	 * @return All Polling Place data as a String.
	 */
	@Override
	public String toString()
	{
		int votesSum = 0;
		String out = String.format("Id: %d Voters: %d Votes:", pollingPlaceId, registeredVoters);
		for (Integer i : votesByCandidate)
		{
			out += String.format(" %s", i);
			votesSum += i;
		}
		
		out += String.format(" Total: %s", votesSum);
		
		return out;
	}
}
