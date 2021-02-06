package sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest
{

	@Test
	void testPerformSorting()
	{
		MergeSort mergeSort = new MergeSort();
		int inputData[] = { 64, 34, 25, 12, 22, 11, 90 };
		mergeSort.performSorting(inputData);
		Assertions.assertArrayEquals( new int [] {11, 12, 22, 25, 34, 64, 90}, inputData);
	}

}
