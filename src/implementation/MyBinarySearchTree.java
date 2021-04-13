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
    	public void inOrder()
	{
		System.out.print("In-order Traversal:");
		inOrder(root);
		System.out.println();
	}

	
	private void inOrder(Node<E> root)
	{
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(" " + root.data);
		inOrder(root.right);
	}

	@Override
	public void postOrder()
	{
		System.out.print("Post-order Traversal:");
		postOrder(root);
		System.out.println();
	}


	private void postOrder(Node<E> root)
	{
		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(" " + root.data);
	}
   
}
