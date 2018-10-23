package com.algo.assignment.day6;
/**
 * @author Arya Soman
 *
 */

/**
 * creating count object to use as a reference in following methods
 * @return
 */
class Count 
{
	int count;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
}
public class BinarySearchTree 
{
	int counter=0;
	Node root;
	public BinarySearchTree()
	{
		Initialize();
	}
	//create BST
	public void Initialize()
	{
		root = new Node(8);

		root.Left = new Node(3);
		root.Right = new Node(10);

		root.Left.Left = new Node(1);
		root.Left.Right = new Node(6);
		root.Right.Right = new Node(14);


		root.Left.Right.Left = new Node(4);
		root.Left.Right.Right = new Node(7);
		root.Right.Right.Left = new Node(13);


	}
	/**
	 * Method to Find K the largest Node.
	 * @param k
	 */

	public void kthLargestNode(int k)
	{
		Count count = new Count();
		count.setCount(0);
		Node kthLargest = new Node(-1);
		Node result = kthLargestNode(root, k, count,kthLargest);
		System.out.println("kthLargestNode = "+result.data);
	}

	/**
	 * Recursive method to Find K the largest Node.
	 * @param node 
	 * @param k
	 * @param count Object of class Count (Pass by reference using object)
	 * @param kthLargest Node object to return kth largest node
	 * @return returns -1 if not found
	 */
	public Node kthLargestNode(Node node, int k, Count count, Node kthLargest)
	{
		if(node != null)
		{
			kthLargestNode(node.Right, k, count,kthLargest);
			count.setCount(count.getCount()+1);
			if(count.getCount() == k)
				kthLargest.data = node.data;
			kthLargestNode(node.Left, k, count,kthLargest);
		}
		return kthLargest;
	}

	/**
	 * Method to Find K the smallest Node.
	 * @param k
	 */

	public void kthSmallestNode(int k)
	{
		Count count = new Count();
		Node kthSmallest = new Node(-1);
		Node result = kthSmallestNode(root, k, count, kthSmallest);
		System.out.println("kth Smallest node = " +result.data);
	}
	/**
	 * Recursive method to Find K the smallest Node.
	 * @param node 
	 * @param k
	 * @param count Object of class Count (Pass by reference using object)
	 * @param kthSmallest Node object to return kth smallest node
	 * @return returns -1 if not found
	 */
	public Node kthSmallestNode(Node node, int k, Count count, Node kthSmallest)
	{
		if(node !=null)
		{
			kthSmallestNode(node.Left, k, count, kthSmallest);
			count.setCount(count.getCount()+1);;
			if(count.getCount() == k)
				kthSmallest.data = node.data;
			kthSmallestNode(node.Right, k, count, kthSmallest);
		}
		return kthSmallest;
	}

	/**
	 * Method to Print nodes in range for a BST	
	 * adding one more method using in-order traversal
	 * @param node
	 * @param low
	 * @param high
	 */

	public void printNodesInRange(Node node, int low, int high)
	{
		if(node != null)
		{
			printNodesInRange(node.Left,low,high);
			if(node.data >= low && node.data <= high)
				System.out.print(node.data+",");
			printNodesInRange(node.Right,low,high);
		}
	}

	/**
	 * Method to Find Ceiling of an element
	 * @param data
	 */
	public void findCeilingNode(int data)
	{
		if(root == null)
			return;
		Node parent = null;
		Node child = root;

		findCeilingNode(data, parent,child);
	}
	
	/**
	 * Recursive Method to Find Ceiling of an element
	 * @param data - node data whose ceiling needs to be found
	 * @param parent
	 * @param child
	 */
	public void findCeilingNode(int data, Node parent, Node child)
	{
		if(child.data == data)
		{
			System.out.println("Ceiling found ="+child.data);
			return;
		}

		if(child.data > data && child.Left !=null)
		{
			parent = child;
			child = child.Left;
			findCeilingNode(data,parent,child);
		}
		else if(child.data < data && child.Right !=null)
		{
			parent = child;
			child = child.Right;
			findCeilingNode(data,parent,child);
		}
		else
		{
			if(child.data > data)
				System.out.println("\nCeiling found ="+child.data);
			else if((child.data < data && parent == null) || parent.data < data)
				System.out.println("\nNo ceiling found!");
			else
				System.out.println("\nCeiling found ="+parent.data);
		}
	}

	/**
	 * testing methods
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.kthLargestNode(6);
		bst.kthSmallestNode(1);
		System.out.println("Printing nodes in range...");
		bst.printNodesInRange(bst.root, 5, 12);
		bst.findCeilingNode(5);
	}

}
