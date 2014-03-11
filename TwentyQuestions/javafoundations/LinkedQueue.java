/**
*  The LinkedQueue class represents a linked implementation of a queue.
*
*  @author  Warren Smith/Java Foundations
*/

package javafoundations;

import javafoundations.exceptions.*;

public class LinkedQueue<T> implements Queue<T>
{
	/** Sets up the counter */
	private int count;
	
	/** Sets front & rear nodes */
	private LinearNode<T> front, rear;

	/**
	*  Creates an empty queue.
	*/
	public LinkedQueue()
	{
		count = 0;
		front = rear = null;
	}

	/**
	*  Adds the specified element to the rear of this queue.
	*
	*  @param T element
	*/
	public void enqueue(T element)
	{
		LinearNode<T> node = new LinearNode<T>(element);

		if (count == 0)
			front = node;
		else
			rear.setNext(node);

		rear = node;
		count++;
	}

	/**
	* 	The following methods are left as Programming Projects.
	*
	*  @throws  EmptyCollectionException - thrown if collection is empty.
	*  @return  temp - returns element being removed.
	*/
	public T dequeue() throws EmptyCollectionException 
	{
		T temp = front.getElement();
		front = front.getNext();
		count--;
		return temp;
	}
	
	/**
	*  Shows the first item in the collection.
	*
	*  @throws  EmptyCollectionException - thrown if collection is empty.
	*  @return  front.getElement() - returns front element.
	*/
	public T first() throws EmptyCollectionException 
	{
		return front.getElement();
	}
	
	/**
	*  Checks if the collection is empty or not.
	*
	*  @return  true or false.
	*/
	public boolean isEmpty() 
	{
		return count == 0;
	}
	
	/**
	*  Get the size of the collection.
	*
	*  @return  count - returns number of elements in collection.
	*/
	public int size() 
	{
		return count;
	}
	
	/**
	*  Prints out the string representation.
	*
	*  @return  result - string representation.
	*/
	public String toString() 
	{
		String result = "<front of queue>\n";
		LinearNode<T> current = front;
		while(current != null)
		{
			result += current.getElement() + "\n";
			current = current.getNext();
		}

		return result + "<rear of queue>";
	}
}