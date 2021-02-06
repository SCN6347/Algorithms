package sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InsertionSortTest
{

	@Test
	void testPerformSorting()
	{
		InsertionSort insertionSort = new InsertionSort();
		int inputData[] = { 64, 34, 25, 12, 22, 11, 90 };
		insertionSort.performSorting(inputData);
		Assertions.assertArrayEquals( new int [] {11, 12, 22, 25, 34, 64, 90}, inputData);
	}

}
