package com.algo.assignment.day3;
/**
 * @author Arya Soman
 *class for double linked list
 */
public class DoublyLinkedList 
{
	Node head;
	
	/**
	 * Method to add nodes in sorted manner in doubly Linked list
	 * @param data - pass the new node data
	 */
	public void addNodesInSortedOrder(int data)
	{
		Node node = new Node(data);
		
		if(head == null)
		{
			head = node;
		}
				
		else if(head.data > node.data)
		{
			node.Next = head;
			head.Previous = node;
			head = node;
		}
		else
		{
			Node temp;
			temp = head;
			
			while(temp.Next != null && temp.Next.data < node.data)
			{
				temp = temp.Next;
			}
			
			if(temp.Next == null)
			{
				temp.Next = node;
				node.Previous = temp;
			}
			
			else
			{
				Node temp1 = temp.Next;
				temp.Next = node;
				node.Next = temp1;
				temp1.Previous = node;
				node.Previous = temp;
				
			}
		}
	}
	
	/**
	 * method to display the nodes values
	 */
	public void showLL()
	{
		Node temp;
		temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.Next;
		}
	}
	
	/**
	 * @param args
	 * calling the insert and display methods for displaying the added nodes 
	 */
	public static void main(String[] args) 
	{
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addNodesInSortedOrder(6);
		list.addNodesInSortedOrder(3);
		list.addNodesInSortedOrder(0);
		list.addNodesInSortedOrder(8);
		list.addNodesInSortedOrder(4);
		list.addNodesInSortedOrder(7);
		list.addNodesInSortedOrder(-5);
		list.addNodesInSortedOrder(2);
		list.addNodesInSortedOrder(10);
		list.showLL();
	}

}
