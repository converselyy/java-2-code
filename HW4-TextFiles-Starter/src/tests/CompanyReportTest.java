// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package tests;

import static org.junit.Assert.*;
import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import reports.CompanyReport;
import reports.DataNotProcessedException;

public class CompanyReportTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/*********** toString() Tests ***********/
	/**
	 * The default provided toString() test. Thanks for that, by the way.
	 */
	@Test
	public void testUnprocessedToString() {
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Blatantly Wrong");
		String expected = "Fortune 500 Report for Blatantly Wrong ranked 0 times\n" + 
			"Revenue\n" + 
			"Min: nul Max: nul Avg: nul StD: nul\n" + 
			"Profit\n" + 
			"Min: nul Max: nul Avg: nul StD: nul\n" + 
			"Rank\n" + 
			"Min: nul Max: nul Avg: nul StD: nul";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());
	}
	
	/**
	 * Normal toString() test with normal input.
	 */
	@Test
	public void testToStringValid() {
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "General Electric");
		String expected = "Fortune 500 Report for General Electric ranked 0 times\n" + 
			"Revenue\n" + 
			"Min: nul Max: nul Avg: nul StD: nul\n" + 
			"Profit\n" + 
			"Min: nul Max: nul Avg: nul StD: nul\n" + 
			"Rank\n" + 
			"Min: nul Max: nul Avg: nul StD: nul";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());
	}
	
	/*********** processReport Tests ***********/
	/**
	 * Test processReport() with the given .csv file.
	 */
	@Test
	public void testProcessReportValid() {
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "CBS");
		assertEquals(true, c.processReport());
	}
	
	/**
	 * Test processReport() with a nonexistent file.
	 */
	@Test
	public void testProcessReportInvalid() {
		CompanyReport c = new CompanyReport(new File("idontexist.csv"), "blep");
		assertEquals(false, c.processReport());
	}
	
	/*********** writeReport Tests ***********/
	/**
	 * Test writeReport() with a valid input file and nonexistent output file.
	 */
	@Test
	public void testWriteReportValidInput() {
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "CBS");
		assertEquals(true, c.processReport());
		assertEquals(true, c.writeReport(new File("new.txt")));
	}
	
	/**
	 * Test writeReport() with an invalid input file and a nonexistent output file.
	 */
	@Test
	public void testWriteReportInvalidInput() throws DataNotProcessedException {
		CompanyReport c = new CompanyReport(new File("idontexist.csv"), "lols");
		assertEquals(false, c.processReport());
		thrown.expect(DataNotProcessedException.class);
		c.writeReport(new File("rip.txt"));
	}
}
