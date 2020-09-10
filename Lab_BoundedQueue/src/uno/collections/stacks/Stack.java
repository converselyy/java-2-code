package uno.collections.stacks;

/**
 * This interface specifies the Stack abstract data type with
 * standard stack operations.  
 * 
 * @author pcavanaugh
 *
 * @param <E> The type of an individual item stored in the Stack.
 */
public interface Stack<E>
{
	/**
	 * Check if the stack is empty. 
	 * 
	 * @return true if the stack contains no items, false otherwise.
	 */
	boolean isEmpty();
	
	/**
	 * Retrieves the number of elements currently stored in the stack.
	 * 
	 * @return The number of items stored.
	 */
	int size();
	
	/**
	 * Retrieve the element at the top of the stack without removing it.
	 * 
	 * @return The top element.
	 * @throws IllegalStateException when the stack is empty.
	 */
	E peek();
	
	/**
	 * Remove the top element from this stack and return it.
	 * 
	 * @return The previous top element.
	 * @throws IllegalStateException when the stack is empty.
	 */
	E pop();
	
	/**
	 * Add an item to the top of this stack and return the new top.
	 * 
	 * @param item The value to be added to the stack.
	 * @return The new top element on the stack.
	 */
	E push(E item);
	
	/**
	 * Determine the position of an item on the stack.  Returns
	 * a 1-based position value, with the item of the top corresponding
	 * to the value 1.  In essence, this tells you the number of pop 
	 * operations that would have to be taken to remove the object from 
	 * the stack.
	 * 
	 * @param o The item to search for in the stack.
	 * @return A number greater than or equal to one if found, -1 if the item 
	 * is not present.
	 */
	int search(Object o);
}
