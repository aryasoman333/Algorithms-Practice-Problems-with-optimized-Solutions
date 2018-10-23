package com.algo.assignment.day2;

/**
 * @author Arya Soman
 * 
 * 1. Find Floor of value X in a sorted array
 */

public class FindFloorOfX 
{
	/**
	 * This is a recursive method to find floor of a value X in a sorted array.
	 * @param array - input array
	 * @param low - represents lower index
	 * @param high - represents higher index
	 * @param x - is the value passed
	 * @return - floor of value x
	 */
	
	/*public static int findFloorRecursive(int[] array, int low, int high, int x)
	{
		if(low > high || array[low] > x)
		{
			return -1;

		}
		if(array[high] <= x)
		{
			return array[high];
		}
		int mid = (low + high)/2;

		//check to handle infinite loop

		if(low == mid)
		{
			return array[low];
		}

		if(array[mid] == x)	
		{
			return array[mid];
		}
		else if(array[mid] < x)
		{
			return findFloorRecursive(array, mid,high, x);
		}
		else 
		{
			return findFloorRecursive(array, low, mid-1, x);
		}
	}*/
	
	public static int findCeilRecursive(int[] array, int low, int high, int x)
	{
		if(low > high || array[high] < x)
		{
			return -1;

		}
		if(array[low] >= x)
		{
			return array[low];
		}
		int mid = (low + high)/2;

		//check to handle infinite loop

		if(low == mid)
		{
			return array[low];
		}

		if(array[mid] == x)	
		{
			return array[mid];
		}
		else if(array[mid] < x)
		{
			return findCeilRecursive(array, mid+1,high, x);
		}
		else 
		{
			return findCeilRecursive(array, low, mid, x);
		}
	}

	public static void main(String[] args) {

		int[] array = {1,3,4,6,7,9};
		int x = 0;
		//int result = findFloorRecursive(array, 0, array.length-1, x);
		int result = findCeilRecursive(array, 0, array.length-1, x);
		
		//System.out.println("Input:"+x+" Floor:"+result);
		System.out.println("Input:"+x+" Ceil:"+result);
		
	}



}
