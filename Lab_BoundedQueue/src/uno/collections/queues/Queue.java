package uno.collections.queues;

/**
 * This interface specifies the Queue abstract data type with
 * standard queue operations.  
 * 
 * @author bdorn
 *
 * @param <E> The type of an individual item stored in the queue.
 */
public interface Queue<E>
{
	/**
	 * Check if the queue is empty. 
	 * 
	 * @return true if the queue contains no items, false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Retrieves the number of elements currently stored in the queue.
	 * 
	 * @return The number of items stored.
	 */
	int size();
	
	/**
	 * Retrieve the element at the front of the queue without removing it.
	 * 
	 * @return The front element.
	 * @throws IllegalStateException when the queue is empty.
	 */
	E peek();
	
	/**
	 * Remove the front element from this queue and return it.
	 * 
	 * @return The previous front element.
	 * @throws IllegalStateException when the queue is empty.
	 */
	E dequeue();
	
	/**
	 * Add an item to the rear of this queue.
	 * 
	 * @param item The value to be added to the queue.
	 */
	void enqueue(E item);
}
