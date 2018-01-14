public class Caching()
{
	HashTable<Object,String> storage ;
	int maxItems;
	int itemsStored;
	ArrayList<Object> orderedObjects;

	public Caching(int maxItems)
	{
		maxItems = this.maxItems;
		itemsStored=0;
		storage = HashTable<Object,String>();
		orderedObjects = new ArrayList();
	}
	
	//								C              "filepath"
	public boolean Cache(Object element, String filePath)
	{

		try
		{
			if(itemsStored < maxItems)
			{
				itemsStored ++;
			}
			else
			{
				storage.remove(orderedObjects.get(0));
				orderedObjects.removeAt(0);
			}
			
			storage.add(element,filePath);
			orderedObjects.add(element);

		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	public String LookUp(Object element)
	{
		if(itemsStored<=0) return "";

		if(storage.contains(element))
			return storage.get(element);
		else
			return "";
	}

	public boolean flush()
	{
		try
		{
			storage = new HashTable<Object,String>();
			orderedObjects = new ArrayList();
			itemsStored = 0;
		}
		catch(Exception e)
		{
			return false;
		}

		return true;
	}

	public ArrayList getLastElements()
	{
		return orderedObjects;
	}
}