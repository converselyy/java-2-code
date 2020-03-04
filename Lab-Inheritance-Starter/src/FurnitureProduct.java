// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Brandon Cline
// RESOURCES: Checked the String.format() Java method docs to confirm
// that %s is used for putting strings into strings.

/**
 * The FurnitureProduct class is the base class for all products sold in a furniture store.
 * It contains the two things that all furniture products have, a name and product number.
 */
public class FurnitureProduct
{
	/**
	 * The smallest allowed value for a product number, set to 10000.
	 */
	private static final int MINIMUM_PRODUCT_NUMBER = 10000;
	/**
	 * The largest allowed value for a product number, set to 99999.
	 */
	private static final int MAXIMUM_PRODUCT_NUMBER = 99999;	
	/**
	 * The name of the product.
	 */
	private String productName;
	/**
	 * The number of the product. An invalid product number will be denoted by a -1.
	 */
	private int productNumber;
	
	/**
	 * Creates a new furniture product object.
	 * @param productNameIn The product name.
	 * @param productNumberIn The product number.
	 */
	public FurnitureProduct(String productNameIn, int productNumberIn)
	{
		this.productName = productNameIn;
		if (productNumberIn <= MAXIMUM_PRODUCT_NUMBER
			&& productNumberIn >= MINIMUM_PRODUCT_NUMBER)
		{
			this.productNumber = productNumberIn;
		}
		else
		{
			this.productNumber = -1;
		}
	}
	
	/**
	 * Determines if one FurnitureProduct is equal to another based solely on product number.
	 * @param temp The FurnitureProduct object to be tested.
	 * @return True if the product numbers are equal, false if not.
	 */
	public boolean equals(FurnitureProduct temp)
	{
		return (temp != null) && this.productNumber == temp.getProductNumber();
	}
	
	/**
	 * Returns the product number.
	 * @return The product number.
	 */
	public int getProductNumber()
	{
		return this.productNumber;
	}
	
	/**
	 * Returns the furniture product's name.
	 * @return The product's name.
	 */
	public String getName()
	{
		return this.productName;
	}
	
	/**
	 * Sets the product number.
	 * @param productNumberIn The updated product number.
	 */
	public void setProductNumber(int productNumberIn)
	{
		this.productNumber = productNumberIn;
	}
	
	/**
	 * Used to get String representation of the FurnitureProduct. Returned String is of the format:
	 * 
	 * Product Name: PROD_NAME, Product Number: PROD_NUM
	 * 
	 * Where PROD_NAME is the name of the product and PROD_NUM is the product number.
	 * @return The formatted string.
	 */
	public String toString()
	{
		return String.format("Product Name: %s, Product Number: %d", this.productName, this.productNumber);
	}
}
