/**
*  The BinaryTree class defines the interface to a binary tree collection.
*
*  @author  Warren Smith/Java Foundations
*/

package javafoundations;

import java.util.Iterator;

public interface BinaryTree<T> extends Iterable<T>
{
	/**
	*  Returns the element stored in the root of the tree.
	*/
	public T getRootElement();

	/** 
	*  Returns the left subtree of the root.
	*/
	public BinaryTree<T> getLeft();

	/**
    *  Returns the right subtree of the root.
	*/
	public BinaryTree<T> getRight();

	/**
	*  Returns true if the binary tree contains an element that matches the specified element and false otherwise.
	*
	*  @param  T target
	*/
	public boolean contains(T target);
	
	/**
	*  Returns a reference to the element in the tree matching the specified target.
	*
	*  @param  T target
	*/
	public T find(T target);

	/** 
	*  Returns true if the binary tree contains no elements, and false otherwise.
	*/
	public boolean isEmpty();

	/** 
	*  Returns the number of elements in this binary tree.
	*/
	public int size();

	/** 
	*  Returns the string representation of the binary tree.
	*/
	public String toString();

	/**
	* Returns a preorder traversal on the binary tree.
	*/
	public Iterator<T> preorder();

	/**
	*  Returns an inorder traversal on the binary tree.
	*/
	public Iterator<T> inorder();

	/** 
	*  Returns a postorder traversal on the binary tree.
	*/
	public Iterator<T> postorder();
	
	/**
	*  Performs a level-order traversal on the binary tree.
	*/
	public Iterator<T> levelorder();
}

