/**
*  The LinkedBinaryTree class implements a binary tree using a linked representation.
*
*  @author  Warren Smith/Java Foundations
*/

package javafoundations;

import javafoundations.*;
import javafoundations.exceptions.*;
import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTree<T>
{
	/** Creates root node */
	protected BTNode<T> root;
	
	/**
	*  Creates an empty binary tree.
	*/
	public LinkedBinaryTree()
	{
		root = null;
	}
	
	/**
	*  Creates a binary tree with the specified element as its root.
	*
	*  @param  T element
	*/
	public LinkedBinaryTree (T element)
	{
		root = new BTNode<T>(element);
	}
	
	/**
	*  Creates a binary tree with the two specified subtrees.
	*
	*  @param  T element
    *  @param  LinkedBinaryTree<T> left	
	*  @param  LinkedBinaryTree<T> right
	*/
	public LinkedBinaryTree (T element, LinkedBinaryTree<T> left,
	LinkedBinaryTree<T> right)
	{
		root = new BTNode<T>(element);
		root.setLeft(left.root);
		root.setRight(right.root);
	}
	
	/**
	*  Returns the element stored in the root of the tree. Throws an
	*  EmptyCollectionException if the tree is empty.
	*
	*  @return  root
	*/
	public T getRootElement()
	{
		if (root == null)
			throw new EmptyCollectionException ("Get root operation "
			+ "failed. The tree is empty.");
		return root.getElement();
	}
	
	/**
	*  Returns the left subtree of the root of this tree.
	*
	*  @return  result
	*/
	public LinkedBinaryTree<T> getLeft()
	{
		if (root == null)
			throw new EmptyCollectionException ("Get left operation "
			+ "failed. The tree is empty.");
			LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
			result.root = root.getLeft();
		return result;
	}
	
	/**
	*  Returns the right subtree of the root of this tree.
	*
	*  @return  result
	*/
	public LinkedBinaryTree<T> getRight() 
	{
		if (root == null)
			throw new EmptyCollectionException ("Get right operation "
            + "failed. The tree is empty.");

		LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
		result.root = root.getRight();

		return result;
	}
	
	/**
	*  Returns the element in this binary tree that matches the
	*  specified target. Throws a ElementNotFoundException if the
	*  target is not found.
	*
	*  @param  T target
	*  @return  node
	*/
	public T find (T target)
	{
		BTNode<T> node = null;
		if (root != null)
			node = root.find(target);
		if (node == null)
			throw new ElementNotFoundException("Find operation failed. "
			+ "No such element in tree.");
		return node.getElement();
	}
	
	/**
	*  Returns the number of elements in this binary tree.
	*
	*  @return result
	*/
	public int size()
	{
		int result = 0;
		if (root != null)
			result = root.count();
		return result;
	}
	
	/**
	*  Populates and returns an iterator containing the elements in
	*  this binary tree using an inorder traversal.
	*
	*  @return iter
	*/
	public Iterator<T> inorder()
	{
		ArrayIterator<T> iter = new ArrayIterator<T>();
		if (root != null)
			root.inorder (iter);
		return iter;
	}
	
	/**
	*  Populates and returns an iterator containing the elements in
	*  this binary tree using an levelorder traversal.
	*
	*  @return iter
	*/
	public Iterator<T> levelorder()
	{
		LinkedQueue<BTNode<T>> queue = new LinkedQueue<BTNode<T>>();
		ArrayIterator<T> iter = new ArrayIterator<T>();
		if (root != null)
		{
			queue.enqueue(root);
			while (!queue.isEmpty())
			{
				BTNode<T> current = queue.dequeue();
				iter.add (current.getElement());
				if (current.getLeft() != null)
					queue.enqueue(current.getLeft());
				if (current.getRight() != null)
					queue.enqueue(current.getRight());
			}
		}
		return iter;
	}
	
	/**
	*  Satisfies the Iterable interface using an inorder traversal.
	*
	*  @return  inorder
	*/
	public Iterator<T> iterator()
	{
		return inorder();
	}
   
    /**
	*  Checks if certain target is within the tree.
	*
	*  @param  T target
	*  @return  true or false
	*/
	public boolean contains (T target) 
 	{
		try
		{
			find(target);
		}
		catch(ElementNotFoundException enfe)
		{
			return false;
		}
		return true;
	}
   
    /**
    *  Checks if tree is empty or not.
    *  
    *  @return  true or false
    */	
	public boolean isEmpty() 
	{
		return size() == 0;
	}
	
	/**
    *  Performs an preorder traversal on this subtree, updating the
    *  specified iterator.
	*
	*  return  iter
    */
	public Iterator<T> preorder() 
	{
		ArrayIterator<T> iter = new ArrayIterator<T>();

		if (root != null)
			root.preorder (iter);

		return iter;
	}
   
    /**
    *  Performs an postorder traversal on this subtree, updating the
    *  specified iterator.
    *
    *  @return  iter
    */
	public Iterator<T> postorder() 
	{
		ArrayIterator<T> iter = new ArrayIterator<T>();

		if (root != null)
			root.postorder (iter);

		return iter;
	}
	
	/**
	*  Prints out the string representation.
	*
	*  @return  result - string representation.
	*/
	public String toString() 
	{
		String result = "";
		Iterator<T> iter = iterator();
		while(iter.hasNext())
			result += iter.next() + "\n";
		return result;
	}
}

