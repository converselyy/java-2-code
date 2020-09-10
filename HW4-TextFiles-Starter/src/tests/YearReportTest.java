// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURES: No external resources were referenced or used.

package tests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import reports.DataNotProcessedException;
import reports.YearNotFoundException;
import reports.YearReport;

public class YearReportTest
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * The default provided toString test. Thanks again.
	 */
	@Test
	public void unprocessedToStringTest() {
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		String expected = "Fortune 500 Report for 2020\n" + 
			"Revenue\n" + 
			"Min: nul Max: nul Avg: nul StD: nul\n" + 
			"Profit\n" + 
			"Min: nul Max: nul Avg: nul StD: nul";
		
		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, y.toString());
	}
	
	/**
	 * Testing toString() with a processed report.
	 */
	@Test
	public void testToStringProcessedValid() {
		YearReport y = new YearReport(new File("fortune500.csv"), 1972);
		String expected = "Fortune 500 Report for 1972\n" + 
			"Revenue\n" + 
			"Min: 176.100 Max: 28263.900 Avg: 1005.797 StD: 22490.309\n" + 
			"Profit\n" + 
			"Min: -356.400 Max: 1935.700 Avg: 46.824 StD: 1047.021";
		
		assertEquals(true, y.processReport());
		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, y.toString());
	}
	
	/**
	 * 
	 */
	/*********** processReport Tests ***********/
	/**
	 * Test processReport() with the given .csv file.
	 */
	@Test
	public void testProcessReportValid() {
		YearReport c = new YearReport(new File("fortune500.csv"), 2000);
		assertEquals(true, c.processReport());
	}
	
	/**
	 * Test processReport() with a nonexistent file.
	 */
	@Test
	public void testProcessReportInvalid() {
		YearReport c = new YearReport(new File("idontexist.csv"), 2000);
		assertEquals(false, c.processReport());
	}
	
	/**
	 * Testing for a year not found in the valid report.
	 */
	@Test
	public void testProcessReportInvalidYear() throws YearNotFoundException {
		YearReport c = new YearReport(new File("fortune500.csv"), 1901);
		thrown.expect(YearNotFoundException.class);
		c.processReport();
	}
	
	/*********** writeReport Tests ***********/
	/**
	 * Test writeReport() with a valid input file and nonexistent output file.
	 */
	@Test
	public void testWriteReportValidInput() {
		YearReport c = new YearReport(new File("fortune500.csv"), 1994);
		assertEquals(true, c.processReport());
		assertEquals(true, c.writeReport(new File("new.txt")));
	}
	
	/**
	 * Test writeReport() with an invalid input file and a nonexistent output file.
	 */
	@Test
	public void testWriteReportInvalidInput() throws DataNotProcessedException {
		YearReport c = new YearReport(new File("idontexist.csv"), 1969);
		assertEquals(false, c.processReport());
		thrown.expect(DataNotProcessedException.class);
		c.writeReport(new File("rip.txt"));
	}
}
