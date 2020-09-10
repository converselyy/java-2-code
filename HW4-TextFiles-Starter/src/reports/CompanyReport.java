// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import analytics.Data;

/**
 * A report for a single company of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues, profits,
 * and rank for all years in which the company was ranked in the Fortune 500.
 * 
 * @author bcline
 */
public class CompanyReport implements Report
{
	/**
	 * Constant number of stats for each section.
	 */
	private static final int NUM_STATS = 4;
	/**
	 * A file containing Fortune 500 data for this report.
	 */
	private File data;
	/**
	 * String containing the name of the company for this report.
	 */
	private String company = "";
	/**
	 * The number of times the company has been ranked.
	 */
	private int numRanked;
	/**
	 * Boolean representing whether or not the report has been processed.
	 */
	private boolean beenProcessed;
	
	/*
	 * The following arrays are organised as such:
	 * 		0. Minimum
	 * 		1. Maximum
	 * 		2. Average
	 * 		3. Standard deviation
	 */
	/**
	 * Array of doubles representing the min, max, ave, and SD of the revenue.
	 */
	private Double[] revenueStats = new Double[NUM_STATS];
	/**
	 * Array of doubles representing the min, max, ave, and SD of the ranks.
	 */
	private Double[] rankStats = new Double[NUM_STATS];
	/**
	 * Array of doubles representing the min, max, ave, and SD of the profits.
	 */
	private Double[] profitStats = new Double[NUM_STATS];
	
	/**
	 * Creates new CompanyReport for given company; data to be read from given file.
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param companyIn - Company to report Fortune 500 data.
	 */
	public CompanyReport(File inputFileIn, String companyIn)
	{
		this.data = inputFileIn;
		this.company = companyIn;
	}
	
	/**
	 * Returns the company of this report.
	 * @return Company of this report as a String.
	 */
	public String getCompany()
	{
		return this.company;
	}
	
	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues, profits,
	 * and rank for all years the company is ranked using tools in the Data class.
	 *  
	 * @return true if processing successful, false if the input file does not exist.
	 */
	public boolean processReport()
	{
		try
		{
			// some declarations
			Scanner file = new Scanner(data);
			String[] line;
			ArrayList<Double> rank = new ArrayList<>();
			ArrayList<Double> profit = new ArrayList<>();
			ArrayList<Double> revenue = new ArrayList<>();
			
			// skip the top column labels
			file.nextLine();
			
			// go through each subsequent line
			while (file.hasNextLine())
			{
				line = file.nextLine().split(",");
				
				// if the current line is the company we're after
				if (Arrays.asList(line).contains(this.getCompany()))
				{
					revenue.add(0, Double.parseDouble(line[REVENUE_LOC]));
					rank.add(0, Double.parseDouble(line[RANK_LOC]));
					profit.add(0, Double.parseDouble(line[PROFIT_LOC]));
				}
			}
			
			file.close();
			
			// might have to make a helper method for all this
			// revenue stats
			this.revenueStats[0] = Data.minimum(revenue.toArray(new Double[0]));
			this.revenueStats[1] = Data.maximum(revenue.toArray(new Double[0]));
			this.revenueStats[2] = Data.average(revenue.toArray(new Double[0]));
			this.revenueStats[3] = Data.standardDeviation(revenue.toArray(new Double[0]));
			
			// rank stats
			this.rankStats[0] = Data.minimum(rank.toArray(new Double[0]));
			this.rankStats[1] = Data.maximum(rank.toArray(new Double[0]));
			this.rankStats[2] = Data.average(rank.toArray(new Double[0]));
			this.rankStats[3] = Data.standardDeviation(rank.toArray(new Double[0]));
			this.numRanked = rank.toArray(new Double[0]).length; // might need to subtract 1
			
			// profit stats
			this.profitStats[0] = Data.minimum(profit.toArray(new Double[0]));
			this.profitStats[1] = Data.maximum(profit.toArray(new Double[0]));
			this.profitStats[2] = Data.average(profit.toArray(new Double[0]));
			this.profitStats[3] = Data.standardDeviation(profit.toArray(new Double[0]));
			
			// assuming it's made it this far
			this.beenProcessed = true;
			return true;
		}
		catch (FileNotFoundException e)
		{
			return false;
		}
	}

	/**
	 * Writes the processed report to the given file.
	 * The given file's contents will look like the result of calling CompanyReport's toString.
	 * @param outputFile - File to write report to.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been
	 * processed.
	 * @return true if write successful, false if file cannot be created.
	 */
	public boolean writeReport(File outputFile)
	{
		if (!this.beenProcessed)
		{
			throw new DataNotProcessedException();
		}
		
		try
		{
			FileOutputStream output = new FileOutputStream(outputFile, true);
			PrintWriter writer = new PrintWriter(output);
			writer.print(this.toString());
			writer.close();
			return true;
		}
		catch (FileNotFoundException e)
		{
			return false;
		}
	}
	
	/**
	 * Returns a formatted String of this report suitable for writing to an output file.
	 * String is of the form:
	 * 
	 * Fortune 500 Report for COMPANY ranked RANKED times
	 * Revenue
	 * Min: MINREV Max: MAXREV Avg: AVGREV StD: STDREV
	 * Profit
	 * Min: MINPRO Max: MAXPRO Avg: AVGPRO StD: STDPRO
	 * Rank
	 * Min: MINRANK Max: MAXRANK Avg: AVGRANK StD: STDRANK
	 * 
	 * Where COMPANY is the company,
	 * RANKED is the number of times the company has been ranked in the file,
	 * MINREV, MAXREV, AVGREV, STDREV are the minimum, maximum, average,
	 * and standard deviation of revenues,
	 * MINPRO, MAXPRO, AVGPRO, STDPRO are the minimum, maximum, average,
	 * and standard deviation of profits, and
	 * MINRANK, MAXRANK, AVGRANK, STDRANK are the minimum, maximum, average,
	 * and standard deviation of rank.
	 * 
	 * These are all floating point values formatted to exactly three decimals except for
	 * MINRANK and MAXRANK which are whole number values.
	 * 
	 * NOTE: There are no blank lines before, after, or between the lines, and the String
	 * DOES NOT end in a new line. If your toString is not formatted exactly most tests will fail.
	 * A JUnit test for this method is provided in the tests package to ensure your formatting
	 * is correct. Additionally, remember that all are formatted to exactly three decimal places,
	 * which will explain any "nul"s you see in the provided test case.
	 *   
	 * @return A formatted string summary of the report.
	 */
	@Override
	public String toString()
	{
		return String.format("Fortune 500 Report for %s ranked %d times\n"
			+ "Revenue\n"
			+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
			+ "Profit\n"
			+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
			+ "Rank\n"
			+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f",
			this.getCompany(), this.numRanked,
			this.revenueStats[0], this.revenueStats[1], this.revenueStats[2], this.revenueStats[3],
			this.profitStats[0], this.profitStats[1], this.profitStats[2], this.profitStats[3],
			this.rankStats[0], this.rankStats[1], this.rankStats[2], this.rankStats[3]);
	}
}
