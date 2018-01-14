import java.util.*;

public abstract class Heap
{
	private LinkedList<Integer> data;
	public LinkedList<Integer> getData()
	{
		return this.data;
	}

	public Heap()
	{
		data = new LinkedList<Integer>();
	}

	public Heap(int n)
	{
		this.data = new LinkedList<Integer>();
		this.data.add(n);
	}

	public Heap(LinkedList<Integer> data)
	{
		this.data = data;
		verifyHeap();
	}

	// HEAP FUNCTIONS
	public void insert(int n)
	{
		this.data.add(n);
		System.out.println("Inserted: "+n+" size: "+this.data.size());
		verifyHeap();
	}

	public void delete(int index)
	{
		// Swap the root value with the last value
		int lastIndex = this.data.size()-1;
		if(swap(index, lastIndex))
		{
			// Delete the last node
			this.data.remove(lastIndex);
		}
		else
		{
			System.out.println("Couldn't delete node at index: "+index);
		}

		verifyHeap();
	}

	// Returns root value without removing
	public int peek()
	{
		return data.get(0);
	}

	// Returns root value and deletes node
	public int poll()
	{
		int root = data.get(0);

		// TODO Delete root value and do heap verification;
		delete(0);

		return root;
	}

	public LinkedList<Integer> getHeap()
	{
		return this.data;
	}

	// HELPER FUNCTIONS

	private void verifyIndex(int index)
	{
		if(index < 0 || index >= this.data.size()) { 
			System.out.println("The index "+index+"is out of bounds, can't verify it");
			return; 
		}

		System.out.println("Verifying node in index: "+index+" value: "+data.get(index)+" parent "+parent(index));
		int valueAtIndex = this.data.get(index);
		
		// While valueAtIndex needs to be higher in the heap (according to the implemented compare function) or we reach the root
		System.out.println("Verifying if it can move up.");
		while(
				parent(index) != -1 &&
				valueAtIndex==compare(valueAtIndex,this.data.get(parent(index)))
		)
		{
			int parentIndex = parent(index);
			swap(index,parentIndex);
			index = parentIndex;
		}
	}


	public void verifyHeap()
	{
		if(this.data.size()==0)
		{
			System.out.println("The Heap is empty there is nothing to verify.");
			return;
		}

		for(int index = this.data.size()-1; index>=0; index--)
		{
			System.out.println("Verifying: "+index+"->"+this.data.get(index));
			heapify(index);
		}
	}

	public void heapify(int parentIndex)
	{

		int leftIndex = left(parentIndex);
		int rightIndex = right(parentIndex);
		int parentValue = this.data.get(parentIndex);

	 	if(leftIndex == -1 && rightIndex == -1)
		{
			// Both child missing, leaf node
			System.out.println("Has no children");
			return;
		}
		else if(leftIndex == -1 && rightIndex > -1)
		{
			// Left child missing
			System.out.println("Has right child");
			int rightValue = this.data.get(rightIndex);
			
			if(compare(parentValue,rightValue) != parentValue)
			{
				// Need to rise children
				swap(parentIndex,rightIndex);
			}

		}
		else if(leftIndex > -1 && rightIndex == -1)
		{
			// Right child missing
			System.out.println("Has left child");
			int leftValue = this.data.get(leftIndex);
			
			if(compare(parentValue,leftValue) != parentValue)
			{
				// Need to rise children
				swap(parentIndex,leftIndex);
			}
		}
		else
		{
			// No child missing
			System.out.println("Has 2 children");
			int leftValue = this.data.get(leftIndex);
			int rightValue = this.data.get(rightIndex);

			if(compare(parentValue,compare(leftValue,rightValue)) != parentValue)
			{
				// Need to rise children
				if(compare(leftValue,rightValue)==leftValue)
				{
					swap(parentIndex,leftIndex);
				}
				else
				{
					swap(parentIndex,rightIndex);
				}
				
			}
		}
	}

	private int parent(int index)
	{
		// If looking for parent of root return -1 signaling there is no parent.
		if(index == 0){ return -1;}

		// If index is even, then this is a right child
		if(index%2==0)
			return index/2-1;
		else
			return index/2;
	}

	// Returns the index to the left child of the element located in the received index
	private int left(int index)
	{
		int childIndex = index*2+1;
		if(childIndex < this.data.size())
			return childIndex;
		else
			return -1;
	}

	// Returns the index to the right child of the element located in the received index
	private int right(int index)
	{
		int childIndex = index*2+2;
		if(childIndex < this.data.size())
			return childIndex;
		else
			return -1;
	}

	// Swaps the values in the provided indexes
	public boolean swap(int index1, int index2)
	{
		if((index1 < 0) 
			|| (index1 >= this.data.size()) 
			|| (index2 < 0) 
			|| (index2 >= this.data.size()))
		{
			System.out.println("Can't swap index "+index1+" with index "+index2+" One of the two is out of bounds. Heap Size: "+this.data.size());
			return false;
		}

		int index1Value = this.data.get(index1);
		int index2Value = this.data.get(index2);
		System.out.println("Swapping "+index1+"->"+index1Value+" with "+index2+"->"+index2Value);
		this.data.set(index1, index2Value);
		this.data.set(index2,index1Value);

		return true;
	}

	public void print()
	{
		for(int i = 0; i<this.getData().size(); i++)
		{
			System.out.print(this.getData().get(i)+"->");
		}
		System.out.println("");
	}
	// Compares two int's and returns the one that should go higher in the heap
	public abstract int compare(int left, int right);
}