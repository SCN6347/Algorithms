package sortingAlgorithms;

public class MergeSort
{
	
	public void performSorting(int inputData[])
	{
		performMergeSort(inputData, 0, inputData.length - 1);
	}
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	private void merge(int inputData[], int startIndex, int middleIndex, int endIndex)
	{
		// Find sizes of two subarrays to be merged
		int n1 = middleIndex - startIndex + 1;
		int n2 = endIndex - middleIndex;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = inputData[startIndex + i];
		for (int j = 0; j < n2; ++j)
			R[j] = inputData[middleIndex + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = startIndex;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				inputData[k] = L[i];
				i++;
			}
			else
			{
				inputData[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{
			inputData[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{
			inputData[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	private void performMergeSort(int inputData[], int startIndex, int endIndex)
	{
		if (startIndex < endIndex)
		{
			// Find the middle point
			int middleIndex = startIndex + (endIndex - startIndex) / 2;

			// Sort first and second halves
			performMergeSort(inputData, startIndex, middleIndex);
			performMergeSort(inputData, middleIndex + 1, endIndex);

			// Merge the sorted halves
			merge(inputData, startIndex, middleIndex, endIndex);
		}
	}
}