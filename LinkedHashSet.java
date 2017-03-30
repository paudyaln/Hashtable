/*
 * implements a hash table using chains of nodes for the buckets
 */

public class LinkedHashSet<T> implements Set<T>
{
	private class Node
	{
		private T data;
		private Node next;

		public Node(T item)
		{
			data = item;
			next = null;
		}

		public String toString()
		{
			return "" + data;
		}
	}

	public static final int DEFAULT_CAPACITY = 9;

	private Node[] hashtable;
	private int size;   
	private int items;  

	public LinkedHashSet ()
	{
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public LinkedHashSet (int capacity)
	{
		hashtable = (Node[]) new LinkedHashSet.Node[capacity];
		size = capacity;
		items = 0;
	}

	public boolean add (T item)
	{
		// don't allow null values
		checkItem(item);

		// get hash index
		int index = getIndex(item);  

		// get corresponding bucket
		Node current = hashtable[index];

		// if item not present
		if (current == null)
		{
		
			// add it to bucket
			hashtable[index] = new Node(item);
			items++;
			return true;
		}

		// if item already present
		while (current.next!= null)
		{
			// don't add it
			if (current.data.equals(item))
			{
				return false;
			}

			current = current.next;
		}

		// check last/only item
		if (current.data.equals(item)) 
		{
			return false;
		}
		
		// if not present, add new item
		current.next = new Node(item);
		items++;
		return true;
	}

	/**
	* remove item form the hash table
	*/
	public boolean remove (T item)
	{
		checkItem(item);

		//get hash index for the item
		int index = getIndex(item);

		//get the first node from the hashtable	
		Node current = hashtable[index];
	
		//linking node for removing element 
		Node previous = current;
		
		//check current item if null				
		if(current == null)
		{
			return false;
		}
		
		//check only one item
		if(current.next == null)
		{
			if(current.data.equals(item))
			{
				hashtable[index] = null;
				items--;
				return true;
			}
			return false;
		}
		//check the first item
		if(current.data.equals(item))
		{
			hashtable[index] = current.next;
			items--;
			return true;
		}
		

		//check all item 		
		while(current.next != null)
		{
			previous = current;
			current = current.next;
			//if item found, remove it
			if(current.data.equals(item))
			{
				previous.next = current.next;		
				items--;		
				return true;
			}
		}
		return false;
	}
	/*
	* remove random item from the hash table
	*/
	public T remove ()
	{
			
		return null;
	}

	public T get()
	{
		boolean filled = false;
		int random = 0;

		while (!filled)
		{
			random = (int)(Math.random() * items);

			if (hashtable[random] != null) 
			{
				filled = true;
			}
		}	
		
		return hashtable[random].data;
	}

	public boolean contains(T item)
	{
		int index = getIndex(item);

		Node current = hashtable[index];

		if (current == null)
		{
			return false;
		}

		while (current.next != null)
		{
			if (current.data.equals(item))
			{
				return true;
			}

			current = current.next;
		}

		if (current.data.equals(item))
		{
			return true;
		}

		return false;		
	}

	public int size()	
	{
		return size;
	}

	public String toString()
	{
		if (size == 0)
		{
			return "[]";
		}
		
		String h = "";

		for (int i = 0; i < size; i++)
		{
			Node current = hashtable[i];

			if (current == null) h+= i + "\t" + " " + "\n";

			else	
			{
				h+= i + "\t" + current + " ";

				while (current.next != null)
				{
					current = current.next;
					h+= current + " ";
				}

				h+= "\n";
			}
		}
		return h;
	}

	private void checkItem (T item)
	{
		if (item == null)
		{
			throw new IllegalArgumentException("null not a possible value!");
		}
	}

	private int getIndex(T item)
	{
		int index = item.hashCode() % size; 

		if (index < 0)
		{
			index += size;
		}

		return index;
	}
}
