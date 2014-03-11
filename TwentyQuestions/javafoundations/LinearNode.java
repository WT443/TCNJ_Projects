/**
*  The LinearNode class represents a node in a linked list.
*
*  @author  Warren Smith/Java Foundations
*/

package javafoundations;

public class LinearNode<T>
{
   /** Creates node next **/
   private LinearNode<T> next;
   
   /** Creates T element */
   private T element;

   /**
   *  Creates an empty node.
   */
   public LinearNode()
   {
      next = null;
      element = null;
   }

   /**
   *  Creates a node storing the specified element.
   *
   *  @param  T element
   */
   public LinearNode(T elem)
   {
      next = null;
      element = elem;
   }

   /**
   *  Returns the node that follows this one.
   *
   *  @return  next
   */
   public LinearNode<T> getNext()
   {
      return next;
   }

   /**
   *  Sets the node that follows this one.
   *
   *  @param  node - takes in LinearNode node.
   */
   public void setNext(LinearNode<T> node)
   {
      next = node;
   }

   /**
   *  Returns the element stored in this node.
   *
   *  @return  element
   */
   public T getElement()
   {
      return element;
   }

   /**
   *  Sets the element stored in this node.
   *
   *  @param  T element
   */
   public void setElement(T elem)
   {
      element = elem;
   }
}