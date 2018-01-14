import java.lang.*;
import java.util.*;

public class MinHeap extends Heap{
	
	public MinHeap()
	{
		super();
	}

	public MinHeap(int n)
	{
		super(n);
	}

	public MinHeap(LinkedList<Integer> data)
	{
		super(data);
	}

	public int compare(int left, int right)
	{
		return Math.min(left,right);
	}
}