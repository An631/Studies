import java.util.*;



public class HashMap {
	
	private ArrayList<HashMapStorage<String,Integer>> data;
	private final int DEFAULT_ARRAY_SIZE = 16;
	public int size;

	public HashMap (){

		data = new ArrayList<HashMapStorage<String, Integer>>(DEFAULT_ARRAY_SIZE);

		for(int i = 0; i < DEFAULT_ARRAY_SIZE; i++)
		{
			HashMapStorage<String,Integer> d = new HashMapStorage<String,Integer>();
			data.add(d);
		}
	}

	public void put (String key, Integer value)
	{
		HashMapStorage<String, Integer> newValue = new HashMapStorage<String,Integer>(key, value);
		int index = hashF(key);

		if(data.get(index).key == null)
		{
			data.set(index,newValue);
			System.out.println("Added k: "+data.get(index).key+" v: "+data.get(index).value);
		}
		else
		{
			HashMapStorage<String,Integer> iterator = data.get(index);

			while(iterator.next != null)
			{
				iterator = iterator.next;
			}

			iterator.next = newValue;
			System.out.println("Added k: "+iterator.next.key+" v: "+iterator.next.value);
		}

		this.size++;
	}

	public Integer get(String key)
	{
		int index = hashF(key);
		HashMapStorage<String,Integer> iterator = data.get(index);
		// Look for the key inside the linked list of HashMapStorage units
		while(iterator.key != key && iterator.next != null)
		{
			iterator = iterator.next;
		}
		
		if(iterator.key!=key && iterator.next == null)
		{
			System.out.println("The key: "+key+" is not found inside the HashMap");
			return null;
		}

		return iterator.value;
	}

	public boolean remove(String key)
	{
		int index = hashF(key);

		HashMapStorage<String,Integer> iterator = data.get(index).next;
		HashMapStorage<String,Integer> prevIterator = data.get(index);
		this.size--;
		if(prevIterator.key==key)
		{
			// Delete the value while keeping the list intact.
			System.out.println("Found to delete at the beginning of list k: "+ prevIterator.key+" v: "+prevIterator.value);
			data.set(index,iterator);
			prevIterator.clear();
			return true;
		}

		// Look for the key inside the linked list of HashMapStorage units
		while(iterator.key != key && iterator.next != null)
		{
			prevIterator=iterator;
			iterator = iterator.next;
		}
		
		if(iterator.key!=key && iterator.next == null)
		{
			System.out.println("The key: " + key + " is not found inside the HashMap");
			this.size++;
			return false;
		}

		// Delete the value and update the list
		System.out.println("Found to delete k: "+ iterator.key+" v: "+iterator.value);
		prevIterator.next = iterator.next;

		iterator.clear();

		return true;
	}


	private int hashF(String key)
	{
		int sum = 0;
		for(int i =0; i<key.length(); i++)
		{
			System.out.print(" "+(key.charAt(i)+0));
			sum += key.charAt(i);
		}
		System.out.println(" Sum: "+sum);
		return sum%data.size()+1;
	}







// Nested Storage Unit Class
	public class HashMapStorage<K,V> {
		
		public K key;
		public V value;
		public HashMapStorage<K,V> next;

		public HashMapStorage(){
			this.key = null;
			this.value = null;
			this.next = null;
		}

		public HashMapStorage(K key, V value){

			this.key = key;
			this.value = value;
		}

		public void clear()
		{
			this.key=null;
			this.value=null;
			this.next=null;
		}
	}
}