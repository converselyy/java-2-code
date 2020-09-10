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
import java.util.Scanner;

import analytics.Data;

/**
 * A report for a single year of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues and profits
 * for all ranked companies of the report's year.
 *  
 * @author bcline
 */
public class YearReport implements Report
{
	/**
	 * Constant number of stats for each section.
	 */
	private static final int NUM_STATS = 4;
	/**
	 * Integer representing the year of the report.
	 */
	private int year;
	/**
	 * File containing Fortune 500 data for this report.
	 */
	private File data;
	/**
	 * Boolean representing whether or not the report has been processed.
	 */
	private boolean beenProcessed = false;
	
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
	 * Array of doubles representing the min, max, ave, and SD of the profits.
	 */
	private Double[] profitStats = new Double[NUM_STATS];
	
	/**
	 * Creates new YearReport for given year; data to be read from given file.
	 * @param inputFileIn File containing Fortune 500 data for this report.
	 * @param yearIn Year to report Fortune 500 data.
	 */
	public YearReport(File inputFileIn, int yearIn)
	{
		this.year = yearIn;
		this.data = inputFileIn;
	}
	
	/**
	 * Returns the year of this report.
	 * @return Year of this report.
	 */
	public int getYear()
	{
		return this.year;
	}

	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues and profits
	 *  for all ranked companies of the report's year using tools in the Data class.
	 *  
	 * @throws YearNotFoundException - Thrown if the report's year is not present in the data file.
	 * @return true if processing successful, false if the input file does not exist.
	 */
	public boolean processReport()
	{
		try
		{
			Scanner file = new Scanner(this.data);
			int count = 0;
			
			// do some data processing, just pull from CompanyReport
			
			String[] line;
			ArrayList<Double> profit = new ArrayList<>();
			ArrayList<Double> revenue = new ArrayList<>();
			
			// skip the top column labels
			file.nextLine();
			
			// go through each subsequent line
			while (file.hasNextLine())
			{
				line = file.nextLine().split(",");
				
				// if the current line is the company we're after
				if (Integer.parseInt(line[YEAR_LOC]) == this.getYear())
				{
					count++;
					revenue.add(0, Double.parseDouble(line[REVENUE_LOC]));
					profit.add(0, Double.parseDouble(line[PROFIT_LOC]));
				}
			}
			
			file.close();
			if (count == 0)
			{
				throw new YearNotFoundException();
			}
			
			// might have to make a helper method for all this
			// revenue stats
			this.revenueStats[0] = Data.minimum(revenue.toArray(new Double[0]));
			this.revenueStats[1] = Data.maximum(revenue.toArray(new Double[0]));
			this.revenueStats[2] = Data.average(revenue.toArray(new Double[0]));
			this.revenueStats[3] = Data.standardDeviation(revenue.toArray(new Double[0]));
			
			// profit stats
			this.profitStats[0] = Data.minimum(profit.toArray(new Double[0]));
			this.profitStats[1] = Data.maximum(profit.toArray(new Double[0]));
			this.profitStats[2] = Data.average(profit.toArray(new Double[0]));
			this.profitStats[3] = Data.standardDeviation(profit.toArray(new Double[0]));
			
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
	 * The given file's contents will look like the result of calling YearReport's toString.
	 * 
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
			String text = this.toString();
			writer.print(text);
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
	 * Fortune 500 Report for YEAR
	 * Revenue
	 * Min: MINREV Max: MAXREV Avg: AVGREV StD: STDREV
	 * Profit
	 * Min: MINPRO Max: MAXPRO Avg: AVGPRO StD: STDPRO
	 * 
	 * Where YEAR is the year of the report, MINREV, MAXREV, AVGREV, STDREV are the
	 *  minimum, maximum, average, and standard deviation of revenues, and
	 *  MINPRO, MAXPRO, AVGPRO, STDPRO are the minimum, maximum, average, and standard deviation of profits.
	 * These are all floating point values formatted to exactly three decimals
	 *  except for YEAR which is a whole number value.
	 * NOTE: There are no blank lines before, after, or between the lines, and the String DOES NOT end in a
	 * new line. If your toString is not formatted exactly most tests will fail.
	 *  A JUnit test for this method is provided in the tests package to ensure your formatting is correct.
	 *  Additionally, remember that all are formatted to exactly three decimal places,
	 *   which will explain any "nul"s you see in the provided test case.
	 */
	@Override
	public String toString()
	{
		return String.format("Fortune 500 Report for %d\n"
			+ "Revenue\n"
			+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f\n"
			+ "Profit\n"
			+ "Min: %.3f Max: %.3f Avg: %.3f StD: %.3f",
			this.getYear(),
			this.revenueStats[0], this.revenueStats[1], this.revenueStats[2], this.revenueStats[3],
			this.profitStats[0], this.profitStats[1], this.profitStats[2], this.profitStats[3]);
	}
}

