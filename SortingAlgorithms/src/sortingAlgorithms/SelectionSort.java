package sortingAlgorithms;

/**
 *
	The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
	
	1) The subarray which is already sorted.
	2) Remaining subarray which is unsorted.
	
	In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
	
	Following example explains the above steps:
	
	
	arr[] = 64 25 12 22 11
	
	Find the minimum element in arr[0...4] and place it at beginning
	11 25 12 22 64
	
	Find the minimum element in arr[1...4] and place it at beginning of arr[1...4]
	11 12 25 22 64
	
	Find the minimum element in arr[2...4] and place it at beginning of arr[2...4]
	11 12 22 25 64
	
	Find the minimum element in arr[3...4] and place it at beginning of arr[3...4]
	11 12 22 25 64 

 *
 * @author scn6347
 *
 */

public class SelectionSort
{
	public void performSorting(int inputData[])
	{
		int len = inputData.length;

		// One by one move boundary of unsorted subarray
		for (int start_index = 0; start_index < len - 1; start_index++)
		{
			// Find the minimum element in unsorted array
			int min_idx = start_index; // Set minimum element as first element in the subset
			for (int i = start_index + 1; i < len; i++)
				if (inputData[i] < inputData[min_idx]) min_idx = i;

			// Swap the found minimum element with the first
			// element
			int temp = inputData[min_idx];
			inputData[min_idx] = inputData[start_index];
			inputData[start_index] = temp;
		}
	}


	// Driver code to test above
	public static void main(String args[])
	{
		SelectionSort selectionSort = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		selectionSort.performSorting(arr);
	}
}