// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package tests;

import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import molecule.Molecule;
import molecule.MoleculeCollection;
import molecule.exceptions.*;

public class MoleculeCollectionTests
{
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/************* Constructor Tests *************/
	/**
	 * Testing the default constructor.
	 */
	@Test
	public void testDefaultConstructor() {
		MoleculeCollection a = new MoleculeCollection();
		assertEquals(a, a);
	}
	
	/**
	 * Testing the loaded constructor with a new LinkedList.
	 */
	@Test
	public void testLoadedConstructor() {
		LinkedList<Molecule> a = new LinkedList<Molecule>();
		MoleculeCollection b = new MoleculeCollection(a);
		assertEquals(a, b.getMoleculeList());
	}
	
	/**
	 * Testing the loaded constructor with a null.
	 */
	@Test
	public void testLoadedConstructorNull() {
		MoleculeCollection a = new MoleculeCollection(null);
		assertEquals(a, a);
	}
	
	/************* addMolecule() Tests *************/
	/**
	 * Testing addMolecule() with a valid Molecule.
	 */
	@Test
	public void testAddMoleculeValid() {
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(0, new Molecule("H"));
		assertEquals(1, a.moleculeWeights());
	}
	
	/**
	 * Testing addMolecule() with null.
	 */
	@Test
	public void testAddMoleculeNull() {
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(0, new Molecule("H"));
		a.addMolecule(0, null);
		assertEquals(1, a.moleculeWeights());
	}
	
	/**
	 * Testing addMolecule() with an invalid index.
	 */
	@Test
	public void testAddMoleculeNegativeIndex() {
		MoleculeCollection a = new MoleculeCollection();
		a.addMolecule(-10, new Molecule("H"));
		assertEquals(1, a.moleculeWeights());
	}
	
}
