/**
*  The BTNode class represents a node in a binary tree with a left and right child.
*  Therefore this class also represents the root of a subtree.
*
*  @author  Warren Smith/Java Foundations
*/
package javafoundations;

public class BTNode<T>
{
   /** Creates T element */
   protected T element;
   
   /** Creates left & right nodes */
   protected BTNode<T> left, right;

   /**
   *  Creates a new tree node with the specified data.
   *
   *  @param  T element
   */
   public BTNode(T element)
   {
      this.element = element;
      left = right = null;
   }

   /**
   *  Returns the element stored in this node.
   *
   *  @return  element - returns the element.
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
   public void setElement(T element)
   {
      this.element = element;
   }

   /**
   *  Returns the left subtree of this node.
   *
   *  @return  left - returns left subtree.
   */
   public BTNode<T> getLeft()
   {
      return left;
   }

   /**
   *  Sets the left child of this node.
   */
   public void setLeft(BTNode<T> left)
   {
      this.left = left;
   }

   /**
   *  Returns the right subtree of this node.
   *
   *  @return  right - returns right subtree.
   */
   public BTNode<T> getRight()
   {
      return right;
   }

   /**
   *  Sets the right child of this node.
   */
   public void setRight(BTNode<T> right)
   {
      this.right = right;
   }

   /**
   *  Searches for specific target element.
   *
   *  @param  T target
   *  @return  result - returns the result of the search.
   */
   public BTNode<T> find(T target)
   {
      BTNode<T> result = null;

      if (element.equals(target))
         result = this;
      else
      {
         if (left != null)
            result = left.find(target);
         if (result == null && right != null)
            result = right.find(target);
      }

      return result;
   }

   /**
   *  Returns the count of nodes.
   *
   *  @return  result - returns the total.
   */
   public int count()
   {
      int result = 1;

      if (left != null)
         result += left.count();

      if (right != null)
         result += right.count();

      return result;
   }

   /**
   *  Performs an inorder traversal on this subtree, updating the
   *  specified iterator.
   *
   *  @param  ArrayIterator<T> - iter
   */
   public void inorder(ArrayIterator<T> iter)
   {
      if (left != null)
         left.inorder (iter);

      iter.add (element);

      if (right != null)
         right.inorder (iter);
   }
   
   /**
   *  Performs an preorder traversal on this subtree, updating the
   *  specified iterator.
   *
   *  @param  ArrayIterator<T> - iter
   */
   public void preorder(ArrayIterator<T> iter) 
   {
	  iter.add(element);
		
	  if(left != null)
		 left.preorder(iter);
			
	  if(right != null)
		 right.preorder(iter);
   }
	
   /**
   *  Performs an postorder traversal on this subtree, updating the
   *  specified iterator.
   *
   *  @param  ArrayIterator<T> - iter
   */
	public void postorder(ArrayIterator<T> iter) 
	{
	  if(left != null)
		 left.preorder(iter);
			
	  if(right != null)
		 right.preorder(iter);
			
	  iter.add(element);
	}
}


