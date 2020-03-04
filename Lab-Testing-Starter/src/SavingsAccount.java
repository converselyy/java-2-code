// COURSE: CSCI1620
// TERM: Spring 2018
// 
// NAME: Brandon Cline
// RESOURCES: We referred to no outside materials when
//            writing the code in this file.

/**
 * This class provides a simple abstraction for a savings account
 * that can gather monthly interest.
 * 
 * @author bdorn, pcavanaugh
 *
 */
public class SavingsAccount 
{
	/**
	 * Fixed number of months. Will never change. Ever.
	 */
	private final double months = 12.0;
	/**
	 * Account number of the account holder.
	 */
	private int accountNumber;
	/**
	 * Shared member for the bank wide annual interest rate.
	 */
	private double annualInterestRate;
	/**
	 * Monthly interest rate.
	 */
	private double monthlyInterestRate = annualInterestRate / this.months;
	/**
	 * Current funds in the account.
	 */
	private double balance;
	/**
	 * First name of the account holder.
	 */
	private String firstName;
	/**
	 * Last name of the account holder.
	 */
	private String lastName;
	
	/**
	 * Constructor used to create a new SavingsAccount for a bank member.
	 * Default interest rate is 0%.
	 * 
	 * @param firstNameIn The account holder's first name.
	 * @param lastNameIn The account holder's last name.
	 * @param accountNumberIn The new account number.
	 * @param balanceIn The initial opening balance for the account.
	 */
	public SavingsAccount(String firstNameIn, String lastNameIn, 
			int accountNumberIn, double balanceIn)
	{
		this.accountNumber = accountNumberIn;
		this.setFirstName(firstNameIn);
		this.setLastName(lastNameIn);
		this.balance = balanceIn;		
		this.annualInterestRate = 0.0;
	}
	
	/**
	 * Updates this account holder's first name with a valid non-empty
	 * String.  The first name is unchanged if an invalid value is given.
	 * 
	 * @param firstNameIn The new first name.
	 */
	public void setFirstName(String firstNameIn)
	{
		if (firstNameIn != null && !firstNameIn.equals(""))
		{
			this.firstName = firstNameIn;
		}
	}
	
	/**
	 * Retrieves the first name on this account.
	 * @return The first name.
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * Updates this account holder's last name with a valid non-empty
	 * String.  The last name is unchanged if an invalid value is given.
	 * 
	 * @param lastNameIn The new last name.
	 */
	public void setLastName(String lastNameIn)
	{
		if (lastNameIn != null && !lastNameIn.equals(""))
		{
			this.lastName = lastNameIn;
		}
	}
	
	/**
	 * Retrieves the last name on this account.
	 * @return The last name.
	 */
	public String getLastName()
	{
		return this.lastName;
	}

	/**
	 * Retrieves the account number for this account.
	 * @return The account number.
	 */
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	/**
	 * Credits this account a specified amount > 0.  Should either 0 or a negative 
	 * amount be deposited, the transaction will be unsuccessful and the account's balance
	 * will not change. 
	 *  
	 * @param anAmount how much money is being deposited into the account
	 * @return true if the transaction was successful, false otherwise. 
	 */
	public boolean deposit(double anAmount)
	{
		if (anAmount > 0)
		{
			this.balance += anAmount;
			return true;
		}
		return false;
	}
	
	/**
	 * Debits this account a specified amount > 0.  Should either 0 or a negative 
	 * amount be withdrawn, the transaction will be unsuccessful and the account's balance
	 * will not change. 
	 *   
	 * @param anAmount how much money is being debited from the account
	 * @return true if the transaction was successful, false otherwise. 
	 */
	public boolean withdraw(double anAmount)
	{
		if (anAmount > 0)
		{
			this.balance -= anAmount;
			return true;
		}
		return false;
	}
	
	/**
	 * Retrieves the current balance of this account.
	 * 
	 * @return The current balance.
	 */
	public double getBalance()
	{
		return this.balance;
	}
	
	/**
	 * Applies monthly interest to the account by increasing balance by interest gained. 
	 */
	public void applyMonthlyInterest()
	{
		this.balance += this.balance * this.monthlyInterestRate;
	}
	
	/**
	 * Updates the annual interest rate on this account. 
	 * 
	 * @param rateIn The new interest rate specified in percentage form.  E.g., 
	 *               2.15 for 2.15% (not .0215).
	 */
	public void setInterestRate(double rateIn)
	{
		final double PERCENT_SCALE_BY = 100.0;
		this.annualInterestRate = rateIn / PERCENT_SCALE_BY;
		this.monthlyInterestRate = this.annualInterestRate / this.months;
	}
	
	/**
	 * Displays this SavingsAccount's number and current balance formatted like
	 * 
	 * 1234: $32.75
	 * 
	 * Amounts are rounded to the nearest cent. The account number is always
	 * displayed as 4 digits, including leading zeros as needed. 
	 * 
	 * @return The formatted string.
	 */
	public String toString()
	{
		return String.format("%4d: $%.2f", this.accountNumber, this.balance);
	}
}
