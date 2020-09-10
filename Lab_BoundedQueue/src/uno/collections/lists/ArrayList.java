package uno.collections.lists;

/**
 * Provides an implementation of a dynamic array-based list structure. 
 * 
 * @author pcavanaugh, bdorn
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
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#add(java.lang.Object)
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
	
	
	/* (non-Javadoc)
	 * @see uno.collections.lists.List#add(int, java.lang.Object)
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
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#set(int, java.lang.Object)
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
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#get(int)
	 */
	public E get(int index)
	{
		if (index < 0 || index > this.size() - 1)
		{
			throw new IndexOutOfBoundsException("Index " + index + " out of range.");
		}
		
		return data[index];
	}
	
	
	/* (non-Javadoc)
	 * @see uno.collections.lists.List#indexOf(java.lang.Object)
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
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#remove(int)
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
	
	
	/* (non-Javadoc)
	 * @see uno.collections.lists.List#isEmpty()
	 */
	public boolean isEmpty()
	{
		return numElements == 0;
	}
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#size()
	 */
	public int size()
	{
		return numElements;
	}
	

	/* (non-Javadoc)
	 * @see uno.collections.lists.List#clear()
	 */
	public void clear()
	{
		numElements = 0;
	}
}
