package com.algo.assignment.day3;

/**
 * @author Arya Soman
 *class for single linked list
 */
public class LinkedList 
{
	Node head;

	/**
	 * method to find length of nodes
	 * @param node - starting node of linked list is passed
	 * @return returns the length of Linked list
	 */
	public int countNodes(Node node)
	{

		int count = 0;
		if(node == null)
		{
			return 0;
		}
		else
		{
			Node temp=node;
			while(temp!=null)
			{
				temp = temp.Next;
				count++;
			}
		}
		return count;
	}

	/**
	 * method to check if two linked lists intersect
	 *@param node1- first node of first linked list 
	 * @param node2 - first node of second linked list
	 * @return boolean value true(if intersects) or false(if do not intersect)
	 */
	public boolean ifIntersect(Node node1, Node node2)
	{
		Node front;
		Node back;
		int count1= 0;
		int count2 = 0; 
		int count = 0;

		count1 = countNodes(node1);
		count2 = countNodes(node2);
		if(count1 > count2)
		{
			count = count1 - count2;
			front = node1;
			back = node2;
		}
		else
		{
			count = count2 - count1;
			front = node2;
			back = node1; 
		}

		for(int i=0 ; i < count ; i++)
		{
			front = front.Next;
		}

		while(front.Next != null)
		{
			front = front.Next;
			back = back.Next;
			if(front == back)
			{
				return true;
			}
		}
		return false;
	}

	public void nodeIntersection()
	{
		//creating an intersecting LL for testing purpose

		Node node1=new Node(4);
		node1.Next = new Node(6);
		Node temp = node1.Next;
		node1.Next.Next = new Node(9);
		node1.Next.Next.Next = new Node(5);
		node1.Next.Next.Next.Next = new Node(2);
		node1.Next.Next.Next.Next.Next = new Node(9);

		Node node2=new Node(1);
		node2.Next = new Node(1);
		node2.Next.Next = new Node(6);
		node2.Next.Next.Next = temp;

		//calling the ifIntersect method to check if the nodes are intersecting

		boolean result = ifIntersect(node1, node2);
		System.out.println("Intersection result : "+result);
	}

	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		//calling the method for testing
		list.nodeIntersection();
	}

}
