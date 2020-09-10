// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: Mr. Cavanaugh
// RESOURCES: I referred to no outside resources to build this class.

package uno.collections.lists;

/**
 * This class provides logical list node to store values within a singly
 * linked list.
 * 
 * @author pcavanaugh
 *
 * @param <E> The type of an individual item stored in the node.
 */
public class ListNode<E>
{
	/**
	 * The data value stored in this node.
	 */
	private E data;
	
	/**
	 * A reference to the subsequent list node.  Null if there is no subsequent node.
	 */
	private ListNode<E> next;
	
	/**
	 * Constructs a new node with the provided data and next reference.
	 * 
	 * @param dataIn The data to store in the new node.
	 * @param nextIn A reference to the new node's subsequent node.
	 */
	public ListNode(E dataIn, ListNode<E> nextIn)
	{
		setData(dataIn);
		setNext(nextIn);
	}
	
	/**
	 * Updates the data payload of this node to a new value.
	 * 
	 * @param dataIn The new data to store in this node.
	 */
	public void setData(E dataIn)
	{
		data = dataIn;
	}
	
	/**
	 * Retrieves the data payload from this list node.
	 * 
	 * @return The data stored inside this node.
	 */
	public E getData()
	{
		return data;
	}
	
	/**
	 * Updates the subsequent list node of this node.
	 * 
	 * @param nextIn A reference to the new subsequent node.
	 */
	public void setNext(ListNode<E> nextIn)
	{
		next = nextIn;
	}
	
	/**
	 * Retrieves a reference to this node's subsequent node.
	 * 
	 * @return The subsequent node.
	 */
	public ListNode<E> getNext()
	{
		return next;
	}
}
