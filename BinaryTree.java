/**
 * 
 */
package com.algo.assignment.day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Arya Soman
 *
 */
public class BinaryTree 
{	
	Node root;
	/**
	 * Constructor that creates a new Binary tree each time an object is created
	 * @param args
	 */
	public BinaryTree() 
	{
		createBinaryTree();
	}

	/**
	 * Method to create a binary tree
	 */

	public void createBinaryTree()
	{
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.left.right.right = new Node(10);
		node.left.left.left = new Node(8);
		node.left.left.left.right = new Node(15);
		node.left.left.left.right.left = new Node(17);
		node.left.left.left.right.left.left = new Node(18);
		node.left.left.left.right.right = new Node(16);
		node.left.left.right = new Node(9);
		node.right.left = new Node(6);
		node.right.left.left = new Node(13);
		node.right.left.left.left = new Node(14);
		node.right.right = new Node(7);
		node.right.right.right = new Node(11);
		node.right.right.right.right = new Node(12);
		root = node;

	}

	/**
	 * Method to print Bottom View of Binary Tree in order from Left to right
	 * we do level order traversal and put node values and cursors to tree map
	 * @param args
	 */
	public void bottomViewSorted()
	{
		int hd = 0;
		TreeMap<Integer, Node> map = new TreeMap<>();
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		root.hd=hd;
		Node node;
		que.add(root);
		
		while(que.size() != 0)
		{
			node = que.poll();
			hd = node.hd;
			map.put(hd, node);
			if(node.left != null)
			{
				node.left.hd = hd - 1;
				que.add(node.left);
			}
			if(node.right != null)
			{	
				node.right.hd = hd + 1;
				que.add(node.right);
			}	
		}
		Set<Integer> keys = map.keySet();

		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +map.get(i).data);
		}
	}
	
	/*public void bottomViewSortedtest(Node node, int hd, int cursor)
	{
		//int hd = 0;
		TreeMap<Integer, Queue> map = new TreeMap<>();
		TreeMap<Integer, Queue> map1 = new TreeMap<>();
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		while(node != null)
		{
		que.add(node);
		map.put(cursor, que);
		bottomViewSortedtest(node.left,hd+1,cursor-1);
		bottomViewSortedtest(node.right,hd+1,cursor+1);
		}
		
		Set<Integer> keys = map.keySet();

		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +map.get(i));
		}
	}*/
	
	/**
	 * Method to return maximum width of a tree
	 * @return returns integer value corresponding to max width
	 */

	public int maxWidthOfTree()
	{
		if(root == null)
			return 0;
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		que.add(null);
		int maxWidth = 1;

		while(que.size() != 0)
		{
			Node node = que.poll();
			if(node != null)
			{
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
			}
			else
			{
				maxWidth = Math.max(que.size(), maxWidth);
				if(que.size() == 0)
					break;
				que.add(null);
			}
		}

		return maxWidth;
	}

	/**
	 * Method to print top view without repetition of root
	 * we do level order traversal and put node values and cursors to tree map
	 * check if key is already present, if not add new entry in map(visible from top)
	 */

	public void topViewWithoutRepetition()
	{
		int hd = 0;
		TreeMap<Integer, Node> map = new TreeMap<>();
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		root.hd=hd;
		Node node;
		que.add(root);
		
		while(que.size() != 0)
		{
			node = que.poll();
			hd = node.hd;
			if(!map.containsKey(hd))
			map.put(hd, node);
			if(node.left != null)
			{
				node.left.hd = hd - 1;
				que.add(node.left);
			}
			if(node.right != null)
			{	
				node.right.hd = hd + 1;
				que.add(node.right);
			}	
		}
		Set<Integer> keys = map.keySet();

		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +map.get(i).data);
		}
	}

	public static void main(String[] args) 
	{
		// Testing the methods

		BinaryTree tree = new BinaryTree();
		System.out.println("Printing bottom View from left to right");
		tree.bottomViewSorted();
		System.out.println("Max width of tree : " +tree.maxWidthOfTree());
		System.out.println("Printing top View Without Repetition");
	//	tree.bottomViewSortedtest(tree.root, 0, 0);
		
	}

}
