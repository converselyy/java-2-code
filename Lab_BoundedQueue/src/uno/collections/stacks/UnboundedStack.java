package uno.collections.stacks;

import uno.collections.lists.LinkedList;


/**
 * A standard stack data structure with no maximum capacity.
 * 
 * @author pcavanaugh
 *
 * @param <E> The type of an individual item stored in the stack.
 */
public class UnboundedStack<E> implements Stack<E>
{
	/**
	 * Storage for items placed in the stack.  The top of the stack
	 * will always be maintained as the first item of the LinkedList. 
	 */
	private LinkedList<E> list;

	/**
	 * Constructs a new empty stack with no maximum capacity.
	 */
	public UnboundedStack()
	{
		list = new LinkedList<E>();
	}
	
	/* (non-Javadoc)
	 * @see uno.collections.stacks.Stack#isEmpty()
	 */
	@Override
	public boolean isEmpty() 
	{
		return list.isEmpty();
	}

	
	/* (non-Javadoc)
	 * @see uno.collections.stacks.Stack#size()
	 */
	@Override
	public int size() 
	{
		return list.size();
	}

	/* (non-Javadoc)
	 * @see uno.collections.stacks.Stack#peek()
	 */
	@Override
	public E peek() 
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot peek on an empty stack.");
		}
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see uno.collections.stacks.Stack#pop()
	 */
	@Override
	public E pop() 
	{
		if (isEmpty())
		{
			throw new IllegalStateException("Cannot pop on an empty stack.");
		}
		return list.remove(0);
	}


	/* (non-Javadoc)
	 * @see uno.collections.stacks.Stack#push(java.lang.Object)
	 */
	@Override
	public E push(E item) 
	{
		list.add(0, item);
		return item;
	}

	/* (non-Javadoc)
	 * @see uno.collections.stacks.Stack#search(java.lang.Object)
	 */
	@Override
	public int search(Object o) 
	{
		@SuppressWarnings("unchecked")
		int location = list.indexOf((E) o);
		if (location != -1)
		{
			location = location + 1;
		}
		
		return location;
	}
}
