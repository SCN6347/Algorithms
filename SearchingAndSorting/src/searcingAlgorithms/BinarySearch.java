package searcingAlgorithms;

public class BinarySearch
{
	public static void main(String args[])
	{
		int searchArray[] = { 2, 3, 4, 10, 40 };
		Integer searchIndex = new BinarySearch().binarySerach(searchArray, 10);
		if (searchIndex != null)
		{
			System.out.println("Search Key not Found");
		}
		else
		{
			System.out.println("Search Key found at index: " + searchIndex);
		}
	}
	
	public Integer binarySerach(int[] searchArray,int searchKey)
	{
		return performBinarySearch(searchArray, 0, searchArray.length, searchKey);
	}

	private Integer performBinarySearch(int[] searchArray, int startPos, int arrayLength, int searchKey)
	{
		if (arrayLength >= startPos)
		{
			// Check if element is present at the middle. If present return the index of middle
			int midIndex = startPos + (arrayLength - startPos) / 2;
			if (searchArray[midIndex] == searchKey) return midIndex;

			// If element is smaller than middle, consider the elements left of middle. End position will change now. 
			if (searchArray[midIndex] > searchKey) return performBinarySearch(searchArray, startPos, midIndex - 1, searchKey);

			// If element is greater than middle, consider the elements right of middle. start position will change now. 
			return performBinarySearch(searchArray, midIndex + 1, arrayLength, searchKey);
		}

		// If element is not present, return null.
		return null;
	}
}
