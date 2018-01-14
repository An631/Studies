import java.lang.*;
import java.util.*;

public class SortHeap extends Heap{
	
	private char order;
	private int lastIndex;

	public SortHeap()
	{
		super();
		this.order = 'A';
	}
	
	public SortHeap(int n)
	{
		super(n);
		this.order = 'A';
	}

	public SortHeap(LinkedList<Integer> data)
	{
		super(data);
		this.order ='A';
	}

	public SortHeap(LinkedList<Integer> data, char order)
	{
		super(data);
		this.order = order;
	}

		// HEAP FUNCTIONS
	public void insert(int n)
	{
		this.getData().add(n);
		this.lastIndex = this.getData().size();

		System.out.println("Inserted: "+n+" size: "+this.getData().size());
		verifyHeap();
	}

	public void sort()
	{
		this.lastIndex = this.getData().size();
		int rootIndex = 0;
		System.out.println("");
		System.out.println("Sorting "+this.order);
		// Make sure the heap is in the right order as it could have changed.
		verifyHeap();
		System.out.println("Done Verification in order "+order);
		while(this.lastIndex>rootIndex)
		{
			swap(this.lastIndex-1,rootIndex);

			// Remove one to lastIndex because the last value should not be considered inside the heap anymore.
			this.lastIndex--;
			heapifyRemaining();
		}
		// Reset the lastIndex value to be able to sort the heap again later
		this.lastIndex = this.getData().size();

		System.out.println("\nSorted "+order+":");
		print();
		System.out.println("");
	}

	public void sort(char order)
	{
		this.order = order;
		sort();
	}

	public void heapifyRemaining()
	{
			for(int index = this.lastIndex; index>=0; index--)
			{
				System.out.println("Verifying: "+index+"->"+this.getData().get(index));
				heapify(index);
			}
	}

	public void heapify(int parentIndex)
	{

		int leftIndex = left(parentIndex);
		int rightIndex = right(parentIndex);
		int parentValue = this.getData().get(parentIndex);

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
			int rightValue = this.getData().get(rightIndex);
			
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
			int leftValue = this.getData().get(leftIndex);
			
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
			int leftValue = this.getData().get(leftIndex);
			int rightValue = this.getData().get(rightIndex);

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
		// Returns the index to the left child of the element located in the received index
	private int left(int index)
	{
		int childIndex = index*2+1;
		System.out.println("Checking left: "+childIndex+"<"+this.lastIndex);
		if(childIndex < this.lastIndex)
			return childIndex;
		else
			return -1;
	}

	// Returns the index to the right child of the element located in the received index
	private int right(int index)
	{
		int childIndex = index*2+2;
		System.out.println("Checking right: "+childIndex+"<"+this.lastIndex);
		if(childIndex < this.lastIndex)
			return childIndex;
		else
			return -1;
	}

	public int compare(int left, int right)
	{
		if(this.order=='A')
		{
			return Math.max(left,right);
		}
		else
		{
			return Math.min(left, right);
		}
	}
}