// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package tests;
import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import molecule.Molecule;
import molecule.exceptions.*;

public class MoleculeTests
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/************* Constructor Tests *************/
	/**
	 * Testing the constructor with a simple valid sequence.
	 */
	@Test
	public void testConstructorSimpleValid() {
		Molecule a = new Molecule("CHO");
		assertEquals("CHO", a.getSequence());
	}
	
	/**
	 * Testing the constructor with a simple invalid sequence.
	 */
	@Test
	public void testConstructorSimpleInvalid() throws InvalidSequenceException {
		thrown.expect(InvalidSequenceException.class);
		Molecule a = new Molecule("((CHO");
	}
	
	/**
	 * Testing the constructor with a blank string.
	 */
	@Test
	public void testConstructorBlankString() throws InvalidSequenceException {
		thrown.expect(InvalidSequenceException.class);
		Molecule a = new Molecule("");
	}
	
	/**
	 * Testing the constructor with a null string.
	 */
	@Test
	public void testConstructorNullSequence() throws InvalidSequenceException {
		thrown.expect(InvalidSequenceException.class);
		Molecule a = new Molecule(null);
	}
	
	/************* getWeight() Tests *************/
	/**
	 * Testing getWeight() with valid simple sequence.
	 */
	@Test
	public void testGetWeightSimpleValid() {
		Molecule a = new Molecule("CHO");
		assertEquals(29, a.getWeight());
	}
	
	/**
	 * Testing getWeight() with another valid simple sequence.
	 */
	@Test
	public void testGetWeightFormicAcidValid() {
		Molecule a = new Molecule("HCOOH");
		assertEquals(46, a.getWeight());
	}
	
	/**
	 * Testing getWeight() with a simple valid sequence including parentheses.
	 */
	@Test
	public void testGetWeightParenthesesValid() {
		Molecule a = new Molecule("(CH)(CH)(CH)");
		assertEquals(39, a.getWeight());
	}
	
	/**
	 * Testing getWeight() with valid multiple sequence.
	 */
	@Test
	public void testGetWeightMultipleValid() {
		Molecule a = new Molecule("(CH)3");
		assertEquals(39, a.getWeight());
	}
	
	/**
	 * Testing getWeight() with valid nested sequence.
	 */
	@Test
	public void testGetWeightNestedValid() {
		Molecule a = new Molecule("H((OH)2C3H)2");
		assertEquals(143, a.getWeight());
	}
	
	/**
	 * Testing getWeight() with H12.
	 */
	@Test
	public void testGetWeightTwelveHydrogen() {
		Molecule a = new Molecule("H12");
		assertEquals(12, a.getWeight());
	}
	
	/**
	 * Testing getWeight() with a valid sequence with multiple digits.
	 */
	@Test
	public void testGetWeightMultiDigitSequenceValid() {
		Molecule a = new Molecule("C6H12O6");
		assertEquals(180, a.getWeight());
	}
	
	/************* atomWeight() tests *************/
	/**
	 * Testing atomWeight() with an uppercase valid atom.
	 */
	@Test
	public void testAtomWeightUppercaseValid() {
		assertEquals(1, Molecule.atomWeight('H'));
	}
	
	/**
	 * Testing atomWeight() with a lowercase valid atom.
	 */
	@Test
	public void testAtomWeightLowercaseValid() {
		assertEquals(1, Molecule.atomWeight('h'));
	}
	
	/**
	 * Testing atomWeight() with an invalid character.
	 */
	@Test
	public void testAtomWeightInvalid() throws InvalidAtomException {
		thrown.expect(InvalidAtomException.class);
		Molecule.atomWeight('N');
	}
	
	/************* compareTo() Tests *************/
	/**
	 * Testing compareTo() where a is less than b.
	 */
	@Test
	public void testCompareToLessThan() {
		Molecule a = new Molecule("H"); // 1
		Molecule b = new Molecule("O"); // 16
		assertEquals(-1, a.compareTo(b));
	}
	
	/**
	 * Testing compareTo() where b is greater than a.
	 */
	@Test
	public void testCompareToGreaterThan() {
		Molecule a = new Molecule("H"); // 1
		Molecule b = new Molecule("O"); // 16
		assertEquals(1, b.compareTo(a));
	}
	
	/**
	 * Testing compareTo() where b is equal to a.
	 */
	@Test
	public void testCompareToEqual() {
		Molecule a = new Molecule("C");
		Molecule b = new Molecule("C");
		assertEquals(0, a.compareTo(b));
	}
	
	/************* validAtom() Tests *************/
	/**
	 * Testing validAtom() with an uppercase valid atom.
	 */
	@Test
	public void testValidAtomUppercaseValid() {
		assertEquals(true, Molecule.validAtom('C'));
	}
	
	/**
	 * Testing validAtom() with an uppercase invalid atom.
	 */
	@Test
	public void testValidAtomUppercaseInvalid() {
		assertEquals(false, Molecule.validAtom('N'));
	}
	
	/**
	 * Testing validAtom() with a lowercase valid atom.
	 */
	@Test
	public void testValidAtomLowercaseValid() {
		assertEquals(true, Molecule.validAtom('h'));
	}
	
	/**
	 * Testing validAtom() with a lowercase invalid atom.
	 */
	@Test
	public void testValidAtomLowercaseInvalid() {
		assertEquals(false, Molecule.validAtom('n'));
	}
	
	/**
	 * Testing toString().
	 */
	@Test
	public void testToString() {
		Molecule a = new Molecule("H");
		assertEquals("H                        : 1", a.toString());
	}
	
	/**
	 * Testing stackHelper().
	 */
	@Test
	public void testStackHelper() throws InvalidSequenceException {
		Stack<Integer> st = new Stack<>();
		thrown.expect(InvalidSequenceException.class);
		Molecule.stackHelper(st);
	}

}
