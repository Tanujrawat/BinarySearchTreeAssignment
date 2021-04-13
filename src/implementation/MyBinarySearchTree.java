package implementation;

import myinterface.BinarySearchTreeADT;
import myinterface.Node;

public class MyBinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {
    //complete this class
    
    private Node<E> root;

    @Override
    public void insert(E data)
	{
		root = insert(root, data);
	}

	private Node<E> insert(Node<E> root, E data)
	{
		
		if (root == null)
		{
			return new Node<E>(data);
		}
		
		else if (data.compareTo(root.data) < 0)
		{
			root.left = insert(root.left, data);
		}
		
		else 
		{
			root.right = insert(root.right, data);
		}
		

		return root;
	}
    
    @Override
    public boolean search(E data)
	{
		return search(root, data);
	}

	private boolean search(Node<E> root, E data)
	{
		
		if (root == null)
		{
			return false;
		}
		
		else if (data.compareTo(root.data) < 0)
		{
			return contains(root.left, data);
		}
		
		else if (data.compareTo(root.data) > 0)
		{
			return contains(root.right, data);
		}
		
		else
		{
			return true;
		}
	}
    

    @Override
    public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	
	private void inorder(Node<E> root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}

   
}
