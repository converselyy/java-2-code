// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: I didn't write this. Twas already provided.

package uno.collections.lists;

/**
 * Provides an implementation of a dynamic array-based list structure. 
 * 
 * @author bdorn
 *
 * @param <E> The type of an individual item to be stored in the list.
 */
public class ArrayList<E> implements List<E>
{
	/**
	 * The initial capacity of an ArrayList.
	 */
	private static final int DEFAULT_SIZE = 10;
	/**
	 * The place where data in the list will be stored.
	 */
	private E[] data;
	/**
	 * The number of elements stored in this list.
	 */
	private int numElements;
	
	/**
	 * Creates a new empty ArrayList.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList()
	{
		data = (E[]) new Object[DEFAULT_SIZE];
		numElements = 0;
	}
	
	/**
	 * Adds the specified item to the list while preserving the global sorted order of the list.
	 * 
	 * @param item The new item to be inserted.
	 * @return true when the item was successfully added (which is always)
	 */
	public boolean add(E item)
	{
		if (numElements == data.length) //If array is full
		{
			expand(); //"Increase" size
		}
		data[numElements] = item;
		numElements++;
		return true;
	}
	
	/**
	 * A helper method used to increase the capacity of the internal array
	 * used to store items.  Capacity will be doubled and all existing items will
	 * remain in the same index locations in the new array.
	 */
	private void expand()
	{
		@SuppressWarnings("unchecked")
		E[] temp = (E[]) new Object[data.length * 2];
		for (int i = 0; i < data.length; i++) //Copy items
		{
			temp[i] = data[i];
		}
		
		data = temp;
	}
	
	/**
	 * Adds a new item to this list at a specified index.  
	 * 
	 * @param index The index where an item is to be added in the list.
	 * @param item  The item to be added to the list.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size(), inclusive.
	 */
	public void add(int index, E item)
	{
		if (index < 0 || index > this.size())
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of range.");
		}
		if (numElements == data.length) //If array is full
		{
			expand(); //"Increase" size
		}
		
		for (int i = numElements - 1; i >= index; i--)
		{
			data[i + 1] = data[i];
		}
		
		data[index] = item;
		numElements++;
	}
	
	/**
	 * Overwrites the value stored at the indicated index with the provided item value.
	 * 
	 * @param index The index of the value to be overwritten in the list.
	 * @param item The new value to place at the specified index.
	 * @return the element previously stored at the specified index.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size() - 1, inclusive.
	 */
	public E set(int index, E item)
	{
		if (index < 0 || index > this.size() - 1)
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of range.");
		}
		
		E temp = data[index];
		data[index] = item;
		return temp;
	}
	
	/**
	 * Retrieves the item at a specified index from this list.
	 * 
	 * @param index The zero based index indicating which value to retrieve.
	 * @return the item stored at the specified index.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size()-1, inclusive.
	 */
	public E get(int index)
	{
		if (index < 0 || index > this.size() - 1)
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of range.");
		}
		
		return data[index];
	}
	
	/**
	 * Searches this list for an item.  This method relies on a properly overridden
	 * definition for the equals method for comparisons.
	 * 
	 * @param item The item to be found in the list.
	 * @return The index position where the item was found or -1 if the item was not found 
	 * 		in the list.
	 */
	public int indexOf(E item)
	{
		int location = -1;	//Perform linear search
		for (int i = 0; i < numElements; i++)
		{
			if (item.equals(data[i]))
			{
				location = i;
				break;
			}
		}
		return location;
	}
	
	/**
	 * Removes the item at a provided index.  The item that was removed is also returned.
	 * 
	 *  @param index The index where an item is to be removed from the list.
	 *  @return the item previously stored at the specified index.
	 *  @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size()-1, inclusive.
	 *  
	 */
	public E remove(int index)
	{
		if (index < 0 || index > this.size() - 1)
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of range.");
		}
		
		E temp = data[index];
		for (int i = index; i < numElements - 1; i++)
		{
			data[i] = data[i + 1];
		}
		numElements--;
		return temp;
	}
	
	/**
	 * A predicate method which indicates whether this list is empty or not.
	 * 
	 * @return true if the size of this list is 0; false otherwise.
	 */
	public boolean isEmpty()
	{
		return numElements == 0;
	}
	
	/**
	 * Retrieves the number of items that have been added to this list
	 * thus far.
	 * 
	 * @return The number of items stored in this list.
	 */
	public int size()
	{
		return numElements;
	}
	
	/**
	 * Resets the state of this SortedlLinkedList such that all contents are removed
	 * and the list is now empty.
	 */
	public void clear()
	{
		numElements = 0;
	}
}
