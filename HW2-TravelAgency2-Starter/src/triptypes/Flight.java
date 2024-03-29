// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline, Nate Tyler
// RESOURCES: Checked the docs for Calendar to see what the format for toString() is.

package triptypes;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * This class represents a single flight within the travel agency system.
 * 
 * @author bcline, ntyler
 */
public class Flight
{
	/**
	 * Two character airline code.
	 */
	private String airline = "";
	/**
	 * Flight number.
	 */
	private int flightNum;
	/**
	 * Three letter airport code for departure airport.
	 */
	private String departureAirport = "";
	/**
	 * Three letter airport code for receiving airport.
	 */
	private String receivingAirport = "";
	/**
	 * Date format for departure and arrival times.
	 */
	private SimpleDateFormat flightFormat = new SimpleDateFormat("HH:mm MM-dd-YYYY");
	/**
	 * Calendar time representing the departure time/date.
	 */
	private Calendar departureTime = Calendar.getInstance();
	/**
	 * Calendar time representing the arrival time/date.
	 */
	private Calendar arrivalTime = Calendar.getInstance();
	/**
	 * Double representing the price of the flight in USD.
	 */
	private double price;
	
	/**
	 * Creates a new flight leg in the system.
	 * 
	 * @param airlineIn The two letter airline code (e.g, "DL", "AA").
	 * @param flightNumIn The unique flight number on a given day.
	 * @param from The three letter airport code for the departure airport (e.g, "OMA").
	 * @param to The three letter airport code for the arrival airport (e.g., "CDG").
	 * @param leavesAt The departure time.
	 * @param arrivesAt The arrival time.
	 * @param priceIn The price for this flight in USD.
	 */
	public Flight(String airlineIn, int flightNumIn, String from, String to,
			Calendar leavesAt, Calendar arrivesAt, double priceIn)
	{
		this.airline = airlineIn;
		this.flightNum = flightNumIn;
		this.departureAirport = from;
		this.receivingAirport = to;
		this.departureTime = leavesAt;
		this.arrivalTime = arrivesAt;
		this.price = priceIn;
	}
	
	/**
	 * Retrieves the price of this flight.
	 * @return The price in USD.
	 */
	public double getPrice()
	{
		return this.price;
	}
	
	/**
	 * Retrieves a formatted string summarising this Flight. Strings will
	 * be formatted as:
	 * 
	 * XX#### Departs: AIR at HH:mm MM-dd-YYYY; Arrives POR at HH:mm MM-dd-YYYY
	 * 
	 * Where XX is the two letter airline abbreviation and #### is the flight number, which may be
	 * 1-4 digits in length and is right aligned in a 4 character wide field.
	 * AIR and POR are the departure and arrival airport codes, respectively.
	 * The HH:mm MM-dd-YYYY values correspond to the departure and arrival time formats using a 24-hour
	 * clock. (see, e.g., java.util.SimpleDateFormat).
	 * For example:
	 * 
	 * DL 123 Departs: OMA at 15:25 03-15-2019; Arrives ATL at 18:01 03-15-2019
	 * 
	 * @return The formatted string summary.
	 */
	public String toString()
	{
		return String.format("%s%4d Departs: %s at %s; Arrives %s at %s", this.airline, this.flightNum,
				this.departureAirport, this.flightFormat.format(this.departureTime.getTime()),
				this.receivingAirport, this.flightFormat.format(this.arrivalTime.getTime()));
	}
}
