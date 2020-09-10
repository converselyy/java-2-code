// COURSE: CSCI1620
// TERM: SPRING 2020
// 
// NAME: Brandon Cline
// RESOURCES: I reviewed the documentation for the Stack class. Nate Tyler also gave me some ideas of how
// to parse the sequence string and how to parse ints from strings without Integer.parseInt(). He also helped with
// conceptualising a lot of what happens in setSequence().

package molecule;
import java.util.Stack;
import molecule.exceptions.InvalidAtomException;
import molecule.exceptions.InvalidSequenceException;

/**
 * Objects of the Molecule class represent a single chemical molecule made up of any number
 * of hydrogen, carbon, and oxygen atoms. The class provides functionality to compute the atomic weight
 * of the molecule.
 *  
 * @author bcline
 */
public class Molecule implements Comparable<Molecule>, Cloneable
{
	/**
	 * Constant representing the arbitrary weight of a Hydrogen atom.
	 */
	private static final int H_WEIGHT = 1;
	/**
	 * Constant representing the arbitrary weight of a Carbon atom.
	 */
	private static final int C_WEIGHT = 12;
	/**
	 * Constant representing the arbitrary weight of an Oxygen atom.
	 */
	private static final int O_WEIGHT = 16;
	/**
	 * String representing the atom sequence of this molecule.
	 */
	private String sequence = "";
	/**
	 * Integer representing the weight of the Molecule.
	 */
	private int weight = 0;
	
	/**
	 * Creates a new Molecule made up of the H, C, and O atoms in the configuration specified by sequenceIn.
	 * @param sequenceIn - The sequence of atoms for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn or
	 *  incoming sequence is null or empty String.
	 */
	public Molecule(String sequenceIn)
	{
		if (sequenceIn == null || sequenceIn.equals(""))
		{
			throw new InvalidSequenceException();
		}
		this.setSequence(sequenceIn);
	}

	/**
	 * Updates the sequence of atoms represented by this Molecule.
	 * @param sequenceIn - The new molecular sequence to be used for this Molecule.
	 * @throws InvalidAtomException - if any non C, H, O atom exists in sequenceIn
	 * @throws InvalidSequenceException - if unmatched parentheses exist in sequenceIn
	 */
	public void setSequence(String sequenceIn) throws InvalidAtomException, InvalidSequenceException
	{
		Stack<Integer> stack = new Stack<Integer>();
		String seq = "(" + sequenceIn + ")";
		int num = 0, par = 0;
		
		for (int i = 0; i < seq.length(); i++)
		{
			// check if it's a digit
			if (Character.isDigit(seq.charAt(i)))
			{
				num = parseInteger(seq, i);
				stackHelper(stack);
				// extend the index past the integer
				i += String.valueOf(num).length() - 1;
				num *= stack.pop();
				stack.push(num);
			}
			else
			{
				// if it's not a digit then it's a character
				switch (seq.charAt(i))
				{
					case '(':
						stack.push(-1);
						par++;
						break;
					case ')':
						num = 0;
						if (par > 0)
						{
							par--;
							while (!stack.empty() && stack.peek() != -1)
							{
								num += stack.pop();
							}
							stack.pop();
							stack.push(num);
							break;
						}
						else
						{
							throw new InvalidSequenceException();
						}
					// and if it's not a parenthesis, then hopefully it's a valid atom
					default:
						if (validAtom(seq.charAt(i)))
						{
							stack.push(atomWeight(seq.charAt(i)));
						}
						// but if it's not then throw an exception
						else
						{
							throw new InvalidAtomException(seq.charAt(i));
						}
						break;
				}
			}
		}
		if (par != 0)
		{
			throw new InvalidSequenceException();
		}
		
		this.weight = stack.pop();
		this.sequence = sequenceIn;
	}
	
	/**
	 * Retrieves a String containing this Molecule's sequence of atoms.
	 * @return Molecular sequence of the Molecule.
	 */
	public String getSequence()
	{
		return this.sequence;
	}
	
	/**
	 * Parses an integer of 1 or more digits in a given string starting at a given index.
	 * @param s String to parse the integer from.
	 * @param index The index at which to start parsing.
	 * @return The integer found in String s starting at index i.
	 */
	private static int parseInteger(String s, int index)
	{
		String temp = "";
		int i = index;
		while (Character.isDigit(s.charAt(i)))
		{
			temp += s.charAt(i++);
		}
		return Integer.parseInt(temp);
	}
	
	/**
	 * Retrieves this Molecule's weight, which is calculated based on the Molecule's sequence per the algorithm
	 * specified.
	 * @return Weight of the Molecule.
	 */
	public int getWeight()
	{
		return this.weight;
	}

	/**
	 * Static utility method to return the atomic weight of a given atom.
	 * Supported atoms are Carbon (C), Hydrogen (H), and Oxygen (O), and the value of the atom parameter
	 * corresponds to the single letter abbreviation for these atoms (case insensitive).
	 * Atomic weights are given in their nearest whole number:
	 *  Hydrogen - 1
	 *  Carbon - 12
	 *  Oxygen - 16
	 * @param atom - Character for atom abbreviation
	 * @return Atomic weight of passed atom
	 * @throws molecule.exceptions.InvalidAtomException - Thrown if an unsupported atom is passed
	 */
	public static int atomWeight(char atom) throws InvalidAtomException
	{
		int temp = 0;
		switch (Character.toUpperCase(atom))
		{
			case 'H': temp = H_WEIGHT; // 1
			break;
			case 'C': temp = C_WEIGHT; // 12
			break;
			case 'O': temp = O_WEIGHT; // 16
			break;
			default: throw new InvalidAtomException(atom);
		}
		return temp;
	}

	/**
	 * Compares this Molecule to a passed Molecule, determining natural order.
	 * Molecules with the same weight (regardless of sequence) are considered equal.
	 * All others are ordered relative to the magnitude of their weights.
	 * @param other - Incoming Molecule to be compared with this (local) Molecule.
	 * @return Returns an int less than 0 if the local Molecule is less than the passed Molecule,
	 *  an int greater than 0 if the local Molecule is greater than the passed Molecule,
	 *  and a 0 if the Molecules are equal.
	 */
	public int compareTo(Molecule other)
	{
		return this.getWeight() < other.getWeight() ? -1 : (this.getWeight() > other.getWeight() ? 1 : 0);
	}
	
	/**
	 * Validates whether the passed in atom is Carbon, Hydrogen, or Oxygen. Assumes atom is uppercase.
	 * @param atom The character to be validated.
	 * @return True is if atom is a valid atom, false if not.
	 */
	public static boolean validAtom(char atom)
	{
		char temp = Character.toUpperCase(atom);
		return temp == 'C' || temp == 'H' || temp == 'O';
	}
	
	/**
	 * Checks the state of the stack passed in.
	 * @param st The stack to check.
	 * @return true if the stack isn't empty and if the top item is greater than or equal to 0.
	 * @throw InvalidSequenceException if the stack is empty or the top item is less than 0.
	 */
	public static boolean stackHelper(Stack st)
	{
		if (st.empty() || (int) st.peek() < 0)
		{
			throw new InvalidSequenceException();
		}
		return true;
	}
	
	/**
	 * Returns a deep copy of the Molecule.
	 * The reference returned should refer to a completely separate molecule with no direct or
	 * indirect aliasing of any instance data in the original Molecule.
	 * NOTE: This method should NOT throw a CloneNotSupportedException.
	 * @return Deep copy of the calling Molecule.
	 */
	@Override
	public Object clone()
	{
		try
		{
			return new Molecule(((Molecule) super.clone()).getSequence());
		}
		catch (CloneNotSupportedException e)
		{
			throw new RuntimeException();
		}
	}
	
	/**
	 * Generates and returns a String with the Molecule's sequence and weight. The format of the String is
	 * 
	 * [SEQUENCE               ]: WEIGHT
	 * 
	 * Where SEQUENCE has a field width of 25 and is left justified
	 * (square brackets are just placeholders and will not appear in actual return values).
	 * WEIGHT should be left-justified. There is no space following the SEQUENCE field and the colon.
	 * @return The generated String.
	 */
	@Override
	public String toString()
	{
		return String.format("%-25s: %d", this.getSequence(), this.getWeight());
	}
}
