// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package morsecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class provides the ability to encode character data and files
 * into their equivalent representation in Morse Code. The International
 * Morse Code alphabet is used, and only the letters A-Z are supported. 
 *  
 * For more: https://en.wikipedia.org/wiki/Morse_code
 * 
 * @author bcline
 *
 */
public class MorseEncoder
{
	/**
	 * The number of letters in the English alphabet.
	 */
	private static final int NUM_LETTERS = 26;
	/**
	 * An array of morse code characters.
	 */
	private String[] key = new String[NUM_LETTERS];
	
	/**
	 * Initialises a MorseEncoder object based on a character map file.
	 * The character map file is a CSV where each row represents the mapping
	 * between a single English alphabet character and the Morse Code equivalent.
	 * 
	 * For example, rows in the should look like this:
	 * A,.-
	 * B,-...
	 * C,-.-.
	 * 
	 * Further, MorseEncoder class assumes that rows in this file are in order
	 * from A-Z and that no additional data is present in the file.
	 * 
	 * All exceptions arising during attempts to read character map file will be
	 * passed back to the client code.
	 * 
	 * @param characterMapFile The name of the file containing Morse code character mappings.
	 * @throws FileNotFoundException when the characterMapFile path is invalid 
	 */
	public MorseEncoder(String characterMapFile) throws FileNotFoundException
	{
		try
		{
			Scanner file = new Scanner(new File(characterMapFile));
			
			for (int i = 0; i < NUM_LETTERS; i++)
			{
				key[i] = file.nextLine().split(",")[1];
			}
			file.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * Encodes a single English alphabet character into Morse code based on
	 * the character map file specified at the time this MorseCode object was
	 * created.  Lowercase and uppercase characters are treated equivalent
	 * in the conversion to Morse code.
	 * 
	 * @param plainChar The alphabetic character to convert into Morse code.
	 * @return A string containing the corresponding Morse code character.
	 * @throws InvalidCharacterException when a character other than A-Z or a-z is passed
	 * as plainChar.
	 */
	public String encodeChar(char plainChar)
	{
		try
		{
			return key[this.charToInt(Character.toUpperCase(plainChar))];
		}
		catch (InvalidCharacterException e)
		{
			e.printStackTrace();
			throw new InvalidCharacterException("Invalid char: ", plainChar);
		}
	}
	
	/**
	 * Encodes a whole English word into Morse code based on the character map
	 * file specified at the time this MorseCode object was created.  Lowercase and 
	 * uppercase characters are treated equivalent in the conversion to Morse code.
	 * 
	 * Consecutive characters in the Morse code equivalent string will be separated
	 * by a single space character.  For example: "DOG" ==> "-.. --- --."
	 * 
	 * @param plainWord The word to convert into Morse code.
	 * @return A string containing the corresponding Morse code characters.
	 * @throws InvalidCharacterException when plainWord contains one or more non-alphabetic
	 * characters.
	 */
	public String encodeWord(String plainWord)
	{
		String temp = "";
		for (int i = 0; i < plainWord.length(); i++)
		{
			temp += this.encodeChar(plainWord.charAt(i)) + " ";
		}
		return temp.trim();
	}
	
	/**
	 * Processes a text input file and outputs its Morse code equivalent
	 * in a separate file.  Line breaks are preserved between the input
	 * and output files in identical locations.  Consecutive words on a 
	 * single line will be rendered in the output file with the sequence 
	 * " | " so that they can be easily distinguished in Morse code.  
	 * 
	 * Thus, if the input file contains the phrase:
	 *  GO SPOT GO
	 *  
	 * The output file will contain:
	 *  --. --- | ... .--. --- - | --. ---
	 * 
	 * Any exceptions that occur during file read/write will be passed back
	 * to the calling code.
	 * 
	 * @param inputFile The filename of the English based file to be processed.
	 * @param outputFile The filename where the output will be written.  Output files are
	 * 					 always written in "write" mode and any existing contents will be
	 *                   deleted.
	 * @throws FileNotFoundException when the inputFile does not exist.
	 * @throws InvalidCharacterException when one or more invalid characters are detected 
	 *                   while processing the input file.
	 */
	public void encodeFile(String inputFile, String outputFile) throws FileNotFoundException
	{
		FileOutputStream output = new FileOutputStream(outputFile, true);
		PrintWriter writer = new PrintWriter(output);
		Scanner input = new Scanner(new File(inputFile));
		Scanner line;
		
		while (input.hasNextLine())
		{
			String temp = "";
			line = new Scanner(input.nextLine());
			
			while (line.hasNext())
			{
				temp += this.encodeWord(line.next()) + " | ";
			}
			temp = input.hasNextLine() ? temp.substring(0, temp.length() - 3) + "\n"
				: temp.substring(0, temp.length() - 3);
			writer.print(temp);
			line.close();
		}
		
		input.close();
		writer.close();
	}
	
	/**
	 * A helper method that quickly converts between a character letter and an integer ordinal
	 * position suitable for use as an array index.
	 * 
	 * @param c	The uppercase character to convert.
	 * @return	An ordinal value 0-25 corresponding to the letter c's alphabetic position
	 * (A is 0, B is 1, and so on).
	 *          The behavior for non-uppercase characters is unspecified.
	 */
	private int charToInt(char c)
	{
		return c - 'A';
	}
}
