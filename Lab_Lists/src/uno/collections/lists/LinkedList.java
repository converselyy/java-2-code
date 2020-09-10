// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: This file; no other external resources were used.

package uno.collections.lists;

/**
 * A generic linked list class that stores items of a consistent type.  This
 * class meets performance expectations for a standard singly-linked list.
 *
 * @param <E> The type of an individual item to be stored in the list.
 */
public class LinkedList<E> implements List<E>
{
	/**
	 * A reference to the first node in the list.  Refers to null when the list contains no items.
	 */
	protected ListNode<E> firstNode;
	/**
	 * A reference to the last node in the list.  Refers to null when the list contains no items.
	 */
	protected ListNode<E> lastNode;
	/**
	 * An internal counter of the number of items stored in the nodes of this list.
	 */
	protected int numElements;
	
	/**
	 * Creates a new empty LinkedList.
	 */
	public LinkedList()
	{
		clear();
	}

	/**
	 * Retrieves the number of items that have been added to this list
	 * thus far.
	 * 
	 * @return The number of items stored in this list.
	 */
	public int size()
	{
		return this.numElements;
	}
	
	/**
	 * A predicate method which indicates whether this list is empty or not.
	 * 
	 * @return true if the size of this list is 0; false otherwise.
	 */
	public boolean isEmpty()
	{
		return this.numElements == 0;
	}
	
	/**
	 * Resets the state of this list such that all contents are removed
	 * and the list is now empty.
	 */
	public void clear()
	{
		firstNode = null;
		lastNode = null;
		numElements = 0;
	}
	
	/**
	 * This method provides access to individual items stored in this list.  The index
	 * refers to the zero-based position in this list (0 to size - 1, inclusive).
	 * 
	 * @param index The index of the corresponding value to be retrieved.
	 * @return The value stored in this list at the provided index.
	 */
	private ListNode<E> getNode(int index)
	{
		ListNode<E> temp = firstNode;
		for (int i = 0; i < index; i++)
		{
			temp = temp.getNext();
		}
		
		return temp;
	}

	/**
	 * Adds the specified item to end of the list.
	 * 
	 * @param item The new item to be inserted.
	 * @return true when the item was successfully added (which is always)
	 */
	public boolean add(E item)
	{		
		ListNode<E> newNode = new ListNode<E>(item, null);
		
		if (firstNode == null)
		{
			firstNode = newNode; 
			lastNode = newNode;
		}
		else
		{
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		
		numElements++;
		return true;
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
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0 && !isEmpty())
		{
			ListNode<E> newNode = new ListNode<E>(item, firstNode);
			firstNode = newNode;
			numElements++;
		}
		else if (index < numElements && !isEmpty())
		{
			ListNode<E> prev = getNode(index - 1);
			ListNode<E> newNode = new ListNode<E>(item, prev.getNext());
			prev.setNext(newNode);
			numElements++;
		}
		else
		{
			add(item);
		}
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
			throw new IndexOutOfBoundsException();
		}
		ListNode<E> temp = getNode(index);
		E data = temp.getData();
		temp.setData(item);
		return data;
	}
	
	/**
	 * Removes the item at a provided index.  The item that was removed is also returned.
	 * 
	 * @param index The index where an item is to be removed from the list.
	 * @return the item previously stored at the specified index.
	 * @throws IndexOutOfBoundsException when the provided index is outside the range 0 .. size() - 1, inclusive.
	 */
	public E remove(int index)
	{
		if (index < 0 || index > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		
		E data;
		
		if (size() == 1)
		{
			data = firstNode.getData();
			firstNode = null;
			lastNode = null;
		}
		else if (index == 0)
		{
			data = firstNode.getData();
			firstNode = firstNode.getNext();
		}
		else
		{
			ListNode<E> prev = getNode(index - 1);
			data = prev.getNext().getData();
			prev.setNext(prev.getNext().getNext());
			if (index == size() - 1)
			{
				lastNode = prev;
			}
		}
		numElements--;
		return data;
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
		if (index < 0 || index > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		return getNode(index).getData();
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
		int location = -1;
		ListNode<E> temp = firstNode;
		for (int i = 0; i < size(); i++)
		{
			if (temp.getData().equals(item))
			{
				location = i;
				break;
			}
			temp = temp.getNext();
		}
		return location;
	}
	
	/**
	 * This method modifies the state of this list such that its contents are logically
	 * in reversed order upon completing the method.
	 */
	public void reverse()	
	{
		if (this.size() > 1)
		{
			//Set up a few temporary references to track things
			ListNode<E> prev = firstNode;
			ListNode<E> next = firstNode.getNext();
			ListNode<E> tail = next.getNext();
					
			//Walk through the data swapping links along the way
			while (next != null)
			{
				next.setNext(prev);
							
				//advance the references
				prev = next;
				next = tail;
				
				if (tail != null)
				{
					tail = tail.getNext();   // watch out for null!
				}
			}
	
			//Update first and last node references		
			firstNode.setNext(null);
			ListNode<E> temp = firstNode;
			firstNode = lastNode;
			lastNode = temp;		
		}
	}
	
	/**
	 * Provides a String representation of this list.  The list is formatted
	 * as "(item0, item1, item2, ...)" where each item# is the toString 
	 * version of the item at that position in the list.
	 * 
	 * @return The formatted String.
	 */
	@Override
	public String toString()
	{
		String result = "(";
		ListNode<E> temp = firstNode;
		
		while (temp != null)
		{
			result += temp.getData().toString();
			temp = temp.getNext();
			result += (temp != null) ? ", " : "";
		}
		return result + ")";
	}
	
	/**
	 * Retrieves an array containing contents of this list at the same indexes.
	 * The resulting array will have a length equal to the size of this list. 
	 * The contents of this list are unaffected by this operation.
	 * 
	 * This method guarantees no worse than linear runtime performance.
	 * 
	 * @return The contents in an array. If this list is empty, the return value will 
	 * be null.
	 */
	public E[] toArray()
	{
		if (this.numElements <= 0)
		{
			return null;
		}
		else
		{
			@SuppressWarnings("unchecked")
			E[] arr = (E[]) new Object[this.numElements];
			
			for (int i = 0; i < this.numElements; i++)
			{
				arr[i] = getNode(i).getData();
			}
			
			return arr;
		}
	}
}
