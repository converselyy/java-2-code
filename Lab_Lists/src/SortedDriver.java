// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: This file was not written by me.

import java.util.Random;

import uno.collections.lists.SortedLinkedList;

public class SortedDriver
{
	public static void main(String[] args)
	{
		SortedLinkedList<Integer> test = new SortedLinkedList<>();
		Random r = new Random();
		
		System.out.println("Adding 20 random items to the list:");
		for (int i = 0; i < 20; i++)
		{
			test.add(r.nextInt(200));
			System.out.println(test.toString());
		}
	}
}
