package cacheManagement.lru;

public class Node<T, U>
{
	private Node<T, U> previous;
	private Node<T, U> next;
	private T key;
	private U value;

	public Node(Node<T, U> previous, Node<T, U> next, T key, U value)
	{
		this.previous = previous;
		this.next = next;
		this.key = key;
		this.value = value;
	}

	public Node<T, U> getPrevious()
	{
		return previous;
	}

	public void setPrevious(Node<T, U> previous)
	{
		this.previous = previous;
	}

	public Node<T, U> getNext()
	{
		return next;
	}

	public void setNext(Node<T, U> next)
	{
		this.next = next;
	}

	public T getKey()
	{
		return key;
	}

	public void setKey(T key)
	{
		this.key = key;
	}

	public U getValue()
	{
		return value;
	}

	public void setValue(U value)
	{
		this.value = value;
	}

}