// COURSE: CSCI1620
// TERM: Spring 2019
// 
// NAME: Brandon Cline
// RESOURCES: No external resources were used in the development of this testing program.

import static org.junit.Assert.*;   // A Checkstyle error on this line is okay.

import org.junit.Test;

/**
 * This class provides a series of JUnit test cases corresponding
 * to the SavingsAccount.java functionality.
 * 
 * @author bcline
 */
public class SavingsAccountTest
{
	///////////////////////////////////////////////////////////////
	// ATTENTION: Some sample tests are provided here to help you
	// get started.  Feel free to refer back to them as examples.
	// but we do not recommend editing them.
	///////////////////////////////////////////////////////////////
	
	/**
	 * The tolerance to use on all floating-point comparisons in the test
	 * cases.
	 */
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	/**
	 * This test verifies the behavior of the default constructor when 
	 * provided valid parameter values.  Getters are also exercised to
	 * verify that the object has been set up correctly.
	 */
	@Test
	public void testConstructorBasic()
	{
		// STEP 1: Setup prior state of the object
		// Since we're testing a constructor here, this step is not applicable.
		
		// STEP 2: Call the method being tested
		SavingsAccount a = new SavingsAccount("Herbert", "Detloff", 9721, 10.52);
		
		// STEP 3: Verify the post-state of the object
		assertEquals("Herbert", a.getFirstName());
		assertEquals("Detloff", a.getLastName());
		assertEquals(9721, a.getAccountNumber());
		
		// When comparing double or float values, assertEquals takes a 
		// third parameter that specifies how close the two values need to
		// be to be considered equal.
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);
		
		// STEP 4: Verify the return value of the method called
		// For constructors, verifying the "post-state" in step 3 and the return 
		// value are synonymous.  There's nothing more to do here.
	}
	
	/**
	 * This test verifies that calling setFirstName with a valid string will
	 * cause the SavingsAccount to take on the new name.
	 */
	@Test
	public void testSetFirstNameValid()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Durango", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName("Herbie");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Herbie", a.getFirstName());				// first name should have changed
		assertEquals("Durango", a.getLastName());   			// last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());				// account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  // balance should NOT have changed
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with null values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValidNull()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Durango", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName(null);
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());				// first name should NOT have changed
		assertEquals("Durango", a.getLastName());   			// last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());				// account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  // balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	/**
	 * This test verifies that calling setFirstName with empty values will
	 * not change the first name on the SavingsAccount.
	 */
	@Test
	public void testSetFirstNameInValidEmpty()
	{
		//STEP 1: Setup prior state of the object
		SavingsAccount a = new SavingsAccount("Durango", "Durango", 9721, 10.52);
		
		//STEP 2: Call the method being tested
		a.setFirstName("");
		
		//STEP 3: Verify the post-state of the object
		assertEquals("Durango", a.getFirstName());				// first name should NOT have changed
		assertEquals("Durango", a.getLastName());   			// last name should NOT have changed
		assertEquals(9721, a.getAccountNumber());				// account should NOT have changed
		assertEquals(10.52, a.getBalance(), DOUBLE_TOLERANCE);  // balance should NOT have changed		
		
		//STEP 4: Verify the return value of the method called
		//setFirstName is a void method and therefore has no return value to verify.
	}
	
	////////////////////////////////////////////////////////////////////////////
	// YOUR TESTS GO BELOW!  Try to write additional tests that exercise all of 
	// the code in SavingsAccount.java
	////////////////////////////////////////////////////////////////////////////

	// lastName tests
	/**
	 * This test verifies that setting the last name to null
	 * doesn't affect the state of lastName.
	 */
	@Test
	public void testSetLastNameInValidNull()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.setLastName(null);
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that setting the last name to a new name
	 * affects the state of lastName.
	 */
	@Test
	public void testSetLastNameInValidEmpty()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.setLastName("");
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that setting the last name to a new name
	 * affects the state of lastName.
	 */
	@Test
	public void testSetLastNameInValid()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.setLastName("Chen");
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Chen", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	// deposit / withdraw tests
	/**
	 * This test verifies that using deposit correctly
	 * affects the instance balance.
	 */
	@Test
	public void testDepositValid()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.deposit(50.0);
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56 + 50.0, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that using deposit with a negative
	 * doesn't affect the instance balance.
	 */
	@Test
	public void testDepositValidNegative()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.deposit(-50.0);
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that using withdraw correctly
	 * affects the instance variable accountNumber.
	 */
	@Test
	public void testWithdrawValid()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.withdraw(50.0);
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56 - 50.0, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that using withdraw
	 * affects the instance variable accountNumber.
	 */
	@Test
	public void testWithdrawValidNegative()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.withdraw(-50.0);
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56, a.getBalance(), DOUBLE_TOLERANCE);
	}

	
	// interest tests
	/**
	 * This test verifies that using setInterestRate()
	 * affects the instance variable accountNumber
	 */
	public void testSetInterestRate()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 100);
		
		// STEP 2: Call method to be tested
		a.setInterestRate(12.0);
		a.applyMonthlyInterest();
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(101.00, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	/**
	 * This test verifies that the method applyMonthlyInterest()
	 * correctly updates the instance balance.
	 */
	@Test
	public void testMonthlyInterest()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		a.setInterestRate(0.0);
		a.applyMonthlyInterest();
		
		// STEP 3: Verify the post-call state of the object
		assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56 + 234.56 * 0.0, a.getBalance(), DOUBLE_TOLERANCE);
	}
	
	// toString() test
	/**
	 * This test verifies that using toString() outputs
	 * the correct formatted string
	 */
	@Test
	public void testToStringValid()
	{
		// STEP 1: Create instance of Savings Account
		SavingsAccount a = new SavingsAccount("Roger", "Sash", 1234, 234.56);
		
		// STEP 2: Call method to be tested
		//String test = a.toString();
		
		// STEP 3: Verify the post-call state of the object
		/*assertEquals("Roger", a.getFirstName());
		assertEquals("Sash", a.getLastName());
		assertEquals(1234, a.getAccountNumber());
		assertEquals(234.56, a.getBalance(), DOUBLE_TOLERANCE); */
		
		// STEP 4: Verify the return statement of the tested method
		assertEquals("1234: $234.56", a.toString());
	}

}