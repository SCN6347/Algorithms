package sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SelectionSortTest
{

	@Test
	void testPerformSorting()
	{
		SelectionSort selectionSort = new SelectionSort();
		int inputData[] = { 64, 34, 25, 12, 22, 11, 90 };
		selectionSort.performSorting(inputData);
		Assertions.assertArrayEquals( new int [] {11, 12, 22, 25, 34, 64, 90}, inputData);
	}

}
