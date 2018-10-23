package com.algo.assignment.day3;

/**
 * @author Arya Soman
 * Node class defined for single and doubly linked list
 */
public class Node 
{
	int data;
	Node Next;
	Node Previous;
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return Next;
	}

	public void setNext(Node next) {
		Next = next;
	}

	public Node getPrevious() {
		return Previous;
	}

	public void setPrevious(Node previous) {
		Previous = previous;
	}

	private Node(){}
	


	
	/**
	 Parametrised constructor to be called each time a node (object) is created.
	 * @param data
	 */
	public Node(int data)
	{
		this.data = data;
		this.Next = null;
		this.Previous = null;
	}
}
