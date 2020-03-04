// COURSE: CSCI1620
// TERM: Fall 2018
//
// NAME: Dr. Dorn and Mr. Cavanaugh
// RESOURCES: Sorting algorithm implementations were given in the TrACE video and appear
//            in Chapter 8 of the textbook.  Code was modified in places to eliminate 
//            helper method calls so that timing data was more easily interpretable by
//            students for this lab.  Interested readers can try putting the helper calls
//            back to see how it impacts performance metrics.

package datautils;

/**
 * This class provides generic implementations of multiple sorting
 * algorithms.
 * 
 * @author Dr. Dorn and Mr. Cavanaugh (and bcline, who deleted some useless stuff)
 */
public class Sorting // got rid of some weird trailing whitespace.
{
	/**
	 * Re-orders the contents of a given array using the bubble sort algorithm (with early-exit optimization).
	 * 
	 * @param data The array to be sorted.
	 */
	public static void bubbleSort(int[] data)
	{
		boolean sorted;
		for (int pass = 0; pass < data.length - 1; pass++)  	// count passes
		{	
			sorted = true;
			for (int comp = 0; comp < data.length - 1; comp++) 	// check order
			{
				if (data[comp] > data[comp + 1])
				{
					sorted = false;
					
					//SWAP pasted here to avoid method invocation overhead in timing data
					//swap(data, comp, comp + 1);
					int temp = data[comp];
					data[comp] = data[comp + 1];
					data[comp + 1] = temp;
				}				
			}
			if (sorted) 
			{
				break;
			}
		}
	}	
	
	/**
	 * Re-orders the contents of a given array using the insertion sort algorithm.
	 * 
	 * @param data The array to be sorted.
	 */
	public static void insertionSort(int[] data) 
	{
		int insert; // temporary variable to hold element to insert
		
		// loop over data.length - 1 elements
		for (int next = 1; next < data.length; next++) 
		{ 
			insert = data[next]; // store value in current element
			int moveItem = next; // initialize location to place element
		   
			// shift items in the sorted part of the array to make room for next element
			// making sure we don't step off the front of the array
			while (moveItem > 0 && data[ moveItem - 1 ] > insert) 
			{           
				// SWAP pasted here to avoid method invocation overhead in timing data
				// swap(data, moveItem, moveItem - 1); // shift element right one slot
				int temp = data[moveItem];
				data[moveItem] = data[moveItem - 1];
				data[moveItem - 1] = temp;							
				
				moveItem--;
			} 
		   
			data[moveItem] = insert; // place inserted element
		}
	}
	
	/**
	 * Re-orders the contents of a given array using the selection sort algorithm.
	 * 
	 * @param arr The array to be sorted.
	 */
	public static void selectionSort(int[] arr)
	{
		for (int pos = 0; pos < arr.length - 1; pos++) 
		{
			//FIND SMALLEST pasted here to avoid method invocation overhead in timing data
			//int smallest = findSmallest(arr, pos, arr.length - 1);
			int smallestPos = pos;
			for (int i = pos + 1; i <= arr.length - 1; i++)
			{
				if (arr[i] < arr[smallestPos])
				{
					smallestPos = i;
				}				
			}				
			
			//SWAP code directly typed out here to avoid method invocation overhead in timing data
			//swap(arr, pos, smallest);
			int temp = arr[pos];
			arr[pos] = arr[smallestPos];
			arr[smallestPos] = temp;			
		}
	}
}