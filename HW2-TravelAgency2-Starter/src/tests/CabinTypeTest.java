// COURSE: CSCI1620
// TERM: Spring 2020
// 
// NAME: Nate Tyler, Brandon Cline
// RESOURCES: We referred to no outside materials when
//            writing the code in this file.

package tests;
import static org.junit.Assert.*;
import org.junit.Test;
import triptypes.CabinType;
public class CabinTypeTest 
{
	@Test
	public void testCabinType()
	{
		CabinType c = CabinType.INTERIOR;
		assertEquals(c, CabinType.INTERIOR);
		c = CabinType.OCEAN_VIEW;
		assertEquals(c, CabinType.OCEAN_VIEW);
		c = CabinType.BALCONY;
		assertEquals(c, CabinType.BALCONY);
		c = CabinType.SUITE;
		assertEquals(c, CabinType.SUITE);
	}
}
