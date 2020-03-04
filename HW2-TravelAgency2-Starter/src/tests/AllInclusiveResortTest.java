// COURSE: CSCI1620
// TERM: Spring 2020
// 
// NAME: Nate Tyler, Brandon Cline
// RESOURCES: We referred to no outside materials when
//            writing the code in this file.

package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import triptypes.AllInclusiveResort;  

/**
 * Tests the AllInclusiveResort class.
 * @author ntyler, bcline
 *
 */

public class AllInclusiveResortTest 
{
	
	private static final double DOUBLE_TOLERANCE = 0.001;
	@Test
	public void testConstructor() 
	{
		AllInclusiveResort a = new AllInclusiveResort("Spring Break on the Gulf", 4, 
			"Hello There", 2, 425, new String[] {"Surfing", "Skidiving"});
		
		
		assertEquals(0.0, a.getFlightCosts(), DOUBLE_TOLERANCE);
		assertEquals(1275.0, a.getPrice(), DOUBLE_TOLERANCE);
		
		assertEquals("Spring Break on the Gulf", a.getName());
		assertEquals(4, a.getNumDays());
		assertEquals(2, a.getGuestsPerRoom());
		assertEquals(1275.0, a.getPrice(), DOUBLE_TOLERANCE);
		assertEquals("Surfing, Skidiving", a.getAmenities());
		assertEquals(a.getFlightCosts() + 0.5 * a.getLodgingCost(), a.getDepositAmount(), DOUBLE_TOLERANCE);
		assertEquals(1275.0, a.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testContructorInvaild()
	{
		AllInclusiveResort a = new AllInclusiveResort("Spring Break on the Gulf", 4, 
				"Hello There", -1, -1, new String[] {"Surfing", "Skidiving"});
		
		assertEquals(0, a.getGuestsPerRoom());
		assertEquals(0, a.getPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToString()
	{
		AllInclusiveResort a = new AllInclusiveResort("Spring Break on the Gulf", 14, 
				"Hello There", 4, 200, new String[] {"Surfing", "Skidiving"});
		
		assertEquals("$ 2600.00  Spring Break on the Gulf (Flight Not Included)\n" + 
				"           An all-inclusive stay at Hello There for 4 people!", a.toString());
	}
}