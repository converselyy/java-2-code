// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package uno.collections.lists;

/**
 * This class is a specialized form of linked list that maintains sortedorder for all inserted items.
 * 
 * @author bcline
 * @param <E> The type of an individual item to be stored in the list.
 */
public class SortedLinkedList<E extends Comparable<E>> extends LinkedList<E>
{
	/**
	 * Creates a new empty SortedLinkedList.
	 */
	public SortedLinkedList()
	{
		super();
	}
	
	/**
	 * Adds the specified item to the list while preserving the global sorted order of the list.
	 * This method guarantees no worse than linear runtime performance for each add operation.
	 * 
	 * @param item The new item to be inserted.
	 * @return True when the item was successfully added (which is always).
	 */
	public boolean add(E item)
	{
		super.add(item);
		return true;
	}
	
	/**
	 * 
	 * @param index The index where an item is to be added in the list.
	 * @param item The item to be added to the list.
	 * @throws UnsupportedOperationException - is thrown any time this method gets called as it
	 * would violate sorted ordering requirements of SortedLinkedList.
	 */
	public void add(int index, E item)
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method is disallowed for SortedLinkedLists. All calls will result in an exception.
	 * @param index The index where an item is to be added in the list.
	 * @param item The item to be added to the list.
	 * @return The element previously stored at the specified index.
	 * @throws UnsupportedOperationException is thrown any time this method gets called as it
	 * would violatesorted ordering requirements of SortedLinkedList.
	 */
	public E set(int index, E item)
	{
		throw new UnsupportedOperationException();
	}
}
