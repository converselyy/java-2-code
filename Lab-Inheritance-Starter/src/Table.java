// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Brandon Cline
// RESOURCES: No external resources were used or referenced.

/**
 * Class for a generic table product. Inherits basic product data from FurnitureProduct.
 */
public class Table extends FurnitureProduct
{
	/**
	 * Count of possible place settings at the table.
	 */
	private int seats;
	
	/**
	 * Table constructor, takes all information required of a table furniture product.
	 * @param productNameIn Name of the table.
	 * @param productNumberIn Product number of the table.
	 * @param seatsIn Number of seats the table can hold.
	 */
	public Table(String productNameIn, int productNumberIn, int seatsIn)
	{
		super(productNameIn, productNumberIn);
		if (seatsIn > 0)
		{
			this.seats = seatsIn;
		}
		else
		{
			this.seats = 1;
		}
	}
	
	/**
	 * Returns the number of possible seats.
	 * @return The number of possible seats.
	 */
	public int getSeats()
	{
		return this.seats;
	}
	
	/**
	 * Sets the number of seats that can be sat at the table.
	 * @param seatsIn Number of seats.
	 */
	public void setSeats(int seatsIn)
	{
		if (seatsIn > 0)
		{
			this.seats = seatsIn;
		}
	}
	
	/**
	 * Used to get String representation of the Table. Returned String is of the format:
	 * 
	 * Product Name: PROD_NAME, Product Number: PROD_NUM, Number of Seats: NUM_SEATS
	 * 
	 * Where PROD_NAME is the name of the product, PROD_NUM is the product number,
	 * and NUM_SEATS is the number of seats.
	 * @return String giving the Table's name, number, and seats.
	 */
	public String toString()
	{
		return String.format("%s, Number of seats: %d", super.toString(), this.seats);
	}
}