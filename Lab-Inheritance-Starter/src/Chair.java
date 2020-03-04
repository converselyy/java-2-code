// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Brandon Cline
// RESOURCES: No external resources were used or referenced.

/**
 * Class for a generic chair product. Inherits basic product data from FurnitureProduct.
 */
public class Chair extends FurnitureProduct
{
	/**
	 * Denotes whether or not the chair has cushions.
	 */
	private boolean cushioned;
	
	/**
	 * Chair constructor, takes all information required of a chair furniture product.
	 * @param nameIn The name of the chair.
	 * @param productNumberIn The product number of the chair.
	 * @param cushionedIn True if the chair has cushions, false if not.
	 */
	public Chair(String nameIn, int productNumberIn, boolean cushionedIn)
	{
		super(nameIn, productNumberIn);
		this.cushioned = cushionedIn;
	}
	
	/**
	 * Used to get String representation of the Chair. Returned String is of the format:
	 * 
	 * Product Name: PROD_NAME, Product Number: PROD_NUM, CUSHIONED
	 * 
	 * Where PROD_NAME is the name of the product, PROD_NUM is the product number, and
	 * CUSHIONED is either the String "Has cushions" or "No cushions".
	 * 
	 * @return String giving the Chairs's name, number, and if it has cushions.
	 */
	public String toString()
	{
		if (this.cushioned)
		{
			return super.toString() + ", Has cushions";
		}
		else
		{
			return super.toString() + ", No cushions";
		}
	}
}