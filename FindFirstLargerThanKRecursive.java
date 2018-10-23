package com.algo.assignment.day2;

/**
 * @author Arya Soman
 * 
 * 2. Find First Value larger than K in a sorted array in recursive manner
 */

public class FindFirstLargerThanKRecursive 
{
	/**
	 * This is a recursive method to find first value larger than K in a sorter array.
	 * @param array - input array
	 * @param low - represents lower index
	 * @param high - represents higher index
	 * @param k - represents the value passed
	 * @return first value larger than k
	 */
	public static int nextBiggerNumberRec(int [] array, int low, int high, int k)
	{
		if(low > high || array[high] <= k)
		{
			return -1;
		}
		else if(array[low] > k)
		{
			return array[low];
		}

		int mid = (low + high)/2;
		if(array[mid] == k)
		{
			//check for repetition
			while(array[mid] == k)
				mid++;
			return array[mid];
		}
		else if(array[mid] < k)
		{
			return nextBiggerNumberRec(array, mid + 1, high, k);
		}
		else 
		{
			return nextBiggerNumberRec(array, low, mid, k);
		}
	}

	public static void main(String[] args) 
	{
		int[] array = {1,2,5,6,7,9,11,13,15,18,18,18,18,44,46,47};
		int k = 18;
		int result = nextBiggerNumberRec(array, 0, array.length-1,k);
		System.out.println("Input:"+k+" Result:"+result);
	}

}
