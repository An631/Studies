import java.lang.*;
import java.util.*;

public class MaxHeap extends Heap{
	
	public MaxHeap()
	{
		super();
	}
	
	public MaxHeap(int n)
	{
		super(n);
	}

	public MaxHeap(LinkedList<Integer> data)
	{
		super(data);
	}

	public int compare(int left, int right)
	{
		return Math.max(left,right);
	}
}