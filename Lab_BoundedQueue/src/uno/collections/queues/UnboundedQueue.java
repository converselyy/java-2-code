package uno.collections.queues;

import uno.collections.lists.LinkedList;

/**
 * An implementation of a linked-list based queue
 * data structure with no maximum capacity.  Individual
 * queue operations satisfy constant-time performance
 * expectations.
 * 
 * @author bdorn
 *
 * @param <E> The type of all items stored in the queue.
 */
public class UnboundedQueue<E> implements Queue<E>
{
	/**
	 * The list where items in the queue will be stored.
	 * The front of the queue is always logically 
	 * represented as position 0 in the list, and the 
	 * rear of the queue is maintained as the value at
	 * index size() - 1 in the list. 
	 */
	private LinkedList<E> data;
	
	/**
	 * Constructs a new empty queue.
	 */
	public UnboundedQueue()
	{
		data = new LinkedList<>();
	}
	
	
	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		return data.isEmpty();
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#size()
	 */
	@Override
	public int size()
	{
		return data.size();
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#peek()
	 */
	@Override
	public E peek()
	{
		if (data.isEmpty())
		{
			throw new IllegalStateException("Cannot peek on an empty queue!");
		}
		
		return data.get(0);
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#dequeue()
	 */
	@Override
	public E dequeue()
	{
		if (data.isEmpty())
		{
			throw new IllegalStateException("Cannot dequeue from an empty queue!");
		}
		
		E front = data.get(0);
		data.remove(0);
		return front;
	}

	/* (non-Javadoc)
	 * @see uno.collections.queues.Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(E item)
	{
		data.add(item);
	}


}
