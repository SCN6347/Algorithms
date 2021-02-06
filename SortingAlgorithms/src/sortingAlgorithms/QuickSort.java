package sortingAlgorithms;

public class QuickSort
{
	
	public void performSorting(int inputData[])
	{
		performSorting(inputData, 0, inputData.length - 1);
	}
	
	/*
	 * This function takes last element as pivot, places the pivot element
	 * at its correct position in sorted array, and places all smaller
	 * (smaller than pivot) to left of pivot and all greater elements to
	 * right of pivot
	 */
	private int partition(int inputData[], int low, int high)
	{
		int pivot = inputData[high];
		int pivotIndex = (low - 1); // index of smaller element
		for (int j = low; j < high; j++)
		{
			// If current element is smaller than the pivot
			if (inputData[j] < pivot)
			{
				pivotIndex++;

				// swap arr[i] and arr[j]
				int temp = inputData[pivotIndex];
				inputData[pivotIndex] = inputData[j];
				inputData[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = inputData[pivotIndex + 1];
		inputData[pivotIndex + 1] = inputData[high];
		inputData[high] = temp;

		return pivotIndex + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	private void performSorting(int inputData[], int low, int high)
	{
		if (low < high)
		{
			/*
			 * arr[partitionIndex] is now at right place
			 */
			int partitionIndex = partition(inputData, low, high);

			// Recursively sort elements before
			// partition and after partition
			performSorting(inputData, low, partitionIndex - 1);
			performSorting(inputData, partitionIndex + 1, high);
		}
	}
	
	
}
