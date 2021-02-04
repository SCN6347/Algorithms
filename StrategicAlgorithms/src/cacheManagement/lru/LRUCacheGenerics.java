package cacheManagement.lru;

import java.util.HashMap;

/**
 * 
 * @author SCN6347
 *
 * @param <K>
 * @param <V>
 * 
 *     This is implemented with the help of a doubly linked list. 
 *     The most recently used one will be at the right and least recently used one will be at the left side.
 *     LRU, O1, O2, O3, MRU
 *               
 */
public class LRUCacheGenerics<K, V>
{

	private HashMap<K, Node<K, V>> cache;
	private Node<K, V> leastRecentlyUsed;
	private Node<K, V> mostRecentlyUsed;
	private int maxSize;
	private int currentSize;

	public LRUCacheGenerics(int maxSize)
	{
		this.maxSize = maxSize;
		this.currentSize = 0;
		leastRecentlyUsed = new Node<K, V>(null, null, null, null);
		mostRecentlyUsed = leastRecentlyUsed;
		cache = new HashMap<K, Node<K, V>>();
	}

	public V get(K key)
	{
		// Return null if element is not present in cache.
		Node<K, V> identifiedNode = cache.get(key);
		if (identifiedNode == null)
		{
			return null;
		}
		
		// If the element is MRU, then it should remain in right most position. So no change in the linked list. 
		else if (identifiedNode.getKey() == mostRecentlyUsed.getKey())
		{
			return mostRecentlyUsed.getValue(); 
		}

		// Now we needs to update the list. Get the next and previous nodes of the identified node.
		Node<K, V> nextNode = identifiedNode.getNext();
		Node<K, V> previousNode = identifiedNode.getPrevious();

		// If at the left-most, we update LRU. 
		// Node next to identified node will be the LRU node.
		// MRU node will be the previous node of the identified node.
		// Next node of MRU will be the identified node.
		
		if (identifiedNode.getKey() == leastRecentlyUsed.getKey())
		{
			nextNode.setPrevious(null);
			leastRecentlyUsed = nextNode;
		}

		// If we are in the middle, we need to update the next and previous nodes also from the identified node.
		// Update Previous node, identified node, next node. 3 nodes will be updated now.
		else if (identifiedNode.getKey() != mostRecentlyUsed.getKey())
		{
			previousNode.setNext(nextNode);
			nextNode.setPrevious(previousNode);
		}

		// Finally move our item to the MRU
		identifiedNode.setPrevious(mostRecentlyUsed);
		mostRecentlyUsed.setNext(identifiedNode);
		mostRecentlyUsed = identifiedNode;
		mostRecentlyUsed.setNext(null);

		return identifiedNode.getValue();

	}

	// Put Operation.
	public void put(K key, V value)
	{
		// if element is already present just return. 
		if (cache.containsKey(key))
		{ return; }

		// Put the new node at the right-most end of the linked-list.
		Node<K, V> myNode = new Node<K, V>(mostRecentlyUsed, null, key, value);
		mostRecentlyUsed.setNext(myNode);
		cache.put(key, myNode);
		mostRecentlyUsed = myNode;

		// Delete the left-most entry (LRU) and update the LRU pointer if the cache is full.
		if (currentSize == maxSize)
		{
			cache.remove(leastRecentlyUsed.getKey());
			leastRecentlyUsed = leastRecentlyUsed.getNext();
			leastRecentlyUsed.setPrevious(null);
		}

		// If cache is not full just increment the current cache capacity.
		else if (currentSize < maxSize)
		{
			// For the first element in cache, LRU and MRU will be the same. 
			if (currentSize == 0)
			{
				leastRecentlyUsed = myNode;
			}
			currentSize++;
		}
	}

	public int getMaxSize()
	{
		return maxSize;
	}

	public void setMaxSize(int maxSize)
	{
		this.maxSize = maxSize;
	}

	public Node<K, V> getLeastRecentlyUsed()
	{
		return leastRecentlyUsed;
	}

	public Node<K, V> getMostRecentlyUsed()
	{
		return mostRecentlyUsed;
	}

	public int getCurrentSize()
	{
		return currentSize;
	}

}
