package uno.collections.lists;

/**
 * A generic linked list class that stores items of a consistent type.  This
 * class meets performance expectations for a standard singly-linked list.
 * 
 * NOTE: THIS CLASS DOES NOT CURRENTLY PERFORM BOUNDS CHECKING ON PARAMETERS
 *       AS IT IS AN EXERCISE LEFT TO STUDENTS.
 *
 * @author pcavanaugh, bdorn
 * @param <E> The type of an individual item to be stored in the list.
 */
public class LinkedList<E> implements List<E>
{

	/**
	 * A reference to the first node in the list.  Refers to null when the list
	 * contains no items.
	 */
	private ListNode<E> firstNode;
	
	/**
	 * A reference to the last node in the list.  Refers to null when the list
	 * contains no items.
	 */
	private ListNode<E> lastNode;
	
	/**
	 * An internal counter of the number of items stored in the nodes of this list.
	 */
	private int numElements;
	
	/**
	 * Creates a new empty LinkedList.
	 */
	public LinkedList()
	{
		clear();
	}

	
	/* (non-Javadoc)
	 * @see uno.collections.lists.List#size()
	 */
	public int size()
	{
		return numElements;
	}
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#isEmpty()
	 */
	public boolean isEmpty()
	{
		return numElements == 0;
	}
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#clear()
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


	/* (non-Javadoc)
	 * @see uno.collections.lists.List#add(java.lang.Object)
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
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#add(int, java.lang.Object)
	 */
	public void add(int index, E item)
	{
		//TODO: Update this method to properly do index bounds checking.
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
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#set(int, java.lang.Object)
	 */
	public E set(int index, E item)
	{
		//TODO: Update this method to properly do index bounds checking.
		ListNode<E> temp = getNode(index);
		E data = temp.getData();
		temp.setData(item);
		return data;
	}
	
	/* (non-Javadoc)
	 * @see uno.collections.lists.List#remove(int)
	 */
	public E remove(int index)
	{
		//TODO: Update this method to properly do index bounds checking.
		
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

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#get(int)
	 */
	public E get(int index)
	{	
		//TODO: Update this method to properly do index bounds checking.
		return getNode(index).getData();
	}
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#indexOf(java.lang.Object)
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
	
}

