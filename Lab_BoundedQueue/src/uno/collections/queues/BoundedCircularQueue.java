// COURSE: CSCI1620
// TERM: Spring 2020
//
// NAME: Brandon Cline
// RESOURCES: No external resources were referenced or used.

package uno.collections.queues;

/**
 * Provides a standard definition of a circular queue (aka, a ring buffer)
 * with a maximum capacity. All queue operations are guaranteed to complete
 * in constant time. 
 * 
 * @author bcline
 *
 * @param <E> The type of an individual element stored in the queue.
 */
public class BoundedCircularQueue<E> implements Queue<E>
{
	/**
	 * Constant representing the max number of items in this queue.
	 */
	private static int len = 10;
	/**
	 * The array where we will store data in this queue.
	 */
	private E[] values;
	/**
	 * The index of the current front item in the queue.
	 */
	private int front;
	/**
	 * The index of the current rear item in the queue.	
	 */
	private int rear;
	/**
	 * The number of items currently stored in the queue.
	 */
	private int numberOfItems;
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue with a default maximum capacity of 10.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue()
	{
		len = 10;
		this.values = (E[]) new Object[len];
		this.numberOfItems = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	/**
	 * Constructs a new, initially empty BoundedCircularQueue.
	 * @param capacity The maximum number of items that can be stored in this queue.
	 */
	@SuppressWarnings("unchecked")
	public BoundedCircularQueue(int capacity)
	{
		this.values = (E[]) new Object[capacity];
		len = capacity;
	}
	
	/**
	 * Check if the queue is empty.
	 * @return true if the queue contains no items, false otherwise.
	 */
	@Override
	public boolean isEmpty()
	{
		return this.numberOfItems == 0;
	}

	/** 
	 * Check if the queue is empty.
	 * @return The number of items stored.
	 */
	@Override
	public int size()
	{
		return this.numberOfItems;
	}

	/**
	 * Retrieve the element at the front of the queue without removing it.
	 * @return The front element.
	 */
	@Override
	public E peek()
	{
		return this.values[this.front];
	}

	/**
	 * Remove the front element from this queue and return it.
	 * @return The previous front element.
	 */
	@Override
	public E dequeue()
	{
		if (this.isEmpty())
		{
			throw new IllegalStateException("Cannot dequeue because queue is empty!");
		}
		E temp = this.peek();
		this.front = (this.front >= len) ? 0 : this.front + 1;
		this.values[this.front] = null;
		this.numberOfItems--;
		return temp;
	}
	
	/**
	 * Add an item to the rear of this queue.
	 * 
	 * @param item The value to be added to the queue.
	 * @throws IllegalStateException when the queue is full.
	 * The message will read "Cannot enqueue because queue is already full!"
	 */
	@Override
	public void enqueue(E item)
	{
		if (this.isFull())
		{
			throw new IllegalStateException("Cannot enqueue because queue is already full!");
		}
		this.values[rear++] = item;
		this.rear = (this.rear > len) ? 0 : this.rear + 1;
		this.numberOfItems++;
	}

	/**
	 * A method to test whether this BoundedCircularQueue is currently full.
	 * @return true if this queue is full, false if at least one more item can be enqueued.
	 */
	public boolean isFull()
	{
		return this.numberOfItems == len;
	}
}
