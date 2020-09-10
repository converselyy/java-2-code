// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Dr. Dorn
// RESOURCES: I referred to no external resources to build this code.

package uno.collections.lists;

/**
 * This interface specifies the behaviors of an abstract data type for list collections.  A list is
 * an indexed, linear collection of like type elements, supporting dynamic insertion and removal at
 * any valid index.
 * 
 * @author bdorn
 *
 * @param <E> The type of an individual element to be stored in the list.
 */
public interface List<E>
{
	/**
	 * Adds the specified item to the end of the list.
	 * 
	 * @param item The new item to be inserted.
	 * @return true when the item was successfully added (which is always)
	 */
	boolean add(E item);
	
	/**
	 * Adds a new item to this list at a specified index.  
	 * 
	 * @param index The index where an item is to be added in the list.
	 * @param item  The item to be added to the list.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size(), inclusive.
	 */
	void add(int index, E item);
	
	/**
	 * Overwrites the value stored at the indicated index with the provided item value.
	 * 
	 * @param index The index of the value to be overwritten in the list.
	 * @param item The new value to place at the specified index.
	 * @return the element previously stored at the specified index.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size() - 1, inclusive.
	 */
	E set(int index, E item);
	
	/**
	 * Retrieves the item at a specified index from this list.
	 * 
	 * @param index The zero based index indicating which value to retrieve.
	 * @return the item stored at the specified index.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size()-1, inclusive.
	 */
	E get(int index);
	
	/**
	 * Removes the item at a provided index.  The item that was removed is also returned.
	 * 
	 *  @param index The index where an item is to be removed from the list.
	 *  @return the item previously stored at the specified index.
	 *  @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size()-1, inclusive.
	 *  
	 */
	E remove(int index);
   
	/**
	 * Searches this list for an item.  This method relies on a properly overridden
	 * definition for the equals method for comparisons.
	 * 
	 * @param item The item to be found in the list.
	 * @return The index position where the item was found or -1 if the item was not found 
	 * 		in the list.
	 */
	int indexOf(E item);
	
	/**
	 * A predicate method which indicates whether this list is empty or not.
	 * 
	 * @return true if the size of this list is 0; false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Retrieves the number of items that have been added to this list
	 * thus far.
	 * 
	 * @return The number of items stored in this list.
	 */
	int size();
	
	/**
	 * Resets the state of this list such that all contents are removed
	 * and the list is now empty.
	 */
	void clear();
}
