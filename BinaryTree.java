package com.algo.assignment.day5;

/**
 * @author Arya Soman
 *
 */
public class BinaryTree {
	Node root;
	public Node a;
    public Node b;
    //constructor calling a create tree method
	public BinaryTree()
	{
        CreateTree();
    }

    private void CreateTree(){

        Node node = new Node(1);
        node.Left = new Node(2);
        node.Right = new Node(3);
        node.Left.Left = new Node(4);
        node.Left.Right = new Node(6);
        node.Right.Left = new Node(7);
        node.Right.Right = new Node(5);
        node.Left.Left.Left = new Node(8);
        node.Left.Left.Right = new Node(9);
        node.Left.Right.Left = new Node(10);
        node.Left.Right.Right = new Node(11);
        node.Right.Left.Left = new Node(12);
        node.Right.Left.Right = new Node(13);
        node.Right.Right.Left = new Node(14);
        node.Right.Right.Right = new Node(15);

        a = node.Left.Left;
        b = node.Left.Right.Right;
        root = node;
    }
	/**
	 * method Prints all Full Nodes in a binary tree
	 * @param node - root node
	 */
	public void printFullNodes(Node node)
	{
		if(node == null)
			return;
		if(node.Left !=null && node.Right != null)
		{
			System.out.print(node.data+",");
		}
		printFullNodes(node.Left);
		printFullNodes(node.Right);
	}
	
	/**
	 * method prints Middle level for  a perfect tree
	 * @param fast - pointer that traverses in twice the speed of slow pointer
	 * @param slow - pointer that traverses in half the speed of fast pointer
	 */
	public void printMiddleLevel(Node fast, Node slow)
	{
		if(slow == null || fast == null)
			return;
		
		if((fast.Left == null || fast.Left.Left ==null))
		{
			System.out.print(slow.data+",");
			return;
		}
		
		printMiddleLevel(fast.Left.Left, slow.Left);
		printMiddleLevel(fast.Right.Right, slow.Right);
	}
	/**
	 * method to check if all Leaves are at same level 
	 */
	public void levelCheckForLeaves()
	{
		int height = findHeight(root);
		System.out.println("levelCheckForLeaves : "+levelCheckForLeaves(root, height,1));
	}
	/**
	 * Recursive method to check if all Leaves are at same level and if yes returns true, else false
	 * @param node
	 * @param height
	 * @param level
	 * @return
	 */
	public boolean levelCheckForLeaves(Node node, int height , int level)
	{		
		if(node == null)
			return true;
		if(node.Left == null && node.Right == null)
		{
			if(height == level)
				return true;
			else
				return false;
		}
		return levelCheckForLeaves(node.Left, height, level+1) && levelCheckForLeaves(node.Right, height, level+1);
	}
	/**
	 * method to find depth of a tree
	 * @param node
	 * @return
	 */
	public int findHeight(Node node)
	{
		if(node == null)
			return 0;
		return 1 + Math.max(findHeight(node.Left) , findHeight(node.Right)) ;
	}
	
	/**
	 * testing the functions
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BinaryTree tree = new BinaryTree();
		System.out.println("Printing full nodes");
		tree.printFullNodes(tree.root);
		System.out.println("\nPrinting middle level nodes");
		tree.printMiddleLevel(tree.root, tree.root);
		System.out.println();
		tree.levelCheckForLeaves();
	}

}
