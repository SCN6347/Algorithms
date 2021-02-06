package sortingAlgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSortTest
{

	@Test
	void test()
	{
		BubbleSort bubbleSort = new BubbleSort();
		int inputData[] = { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort.performSorting(inputData);
		Assertions.assertArrayEquals( new int [] {11, 12, 22, 25, 34, 64, 90}, inputData);
	}

}
