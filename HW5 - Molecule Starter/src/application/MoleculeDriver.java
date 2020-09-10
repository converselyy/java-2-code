// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package application;

import molecule.Molecule;

/**
 * I'm not even sure documentation is required on driver programs I write, but here it is just in case.
 * Just a simple driver program for testing Molecule.java in ways that JUnit tests can't quite help me with.
 * 
 * @author bcline
 */
public class MoleculeDriver {
	// actually super helpful
	public static void main(String[] args) {
		Molecule a = new Molecule("H12");
		print("H12: " + a.getWeight());
		
	}
	
	public static void print(String s) {
		System.out.print(s);
	}
}
