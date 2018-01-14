import java.util.*;
public class TestHeap{
	public static void main(String args[])
	{
		MinHeap testMinHeap = new MinHeap();
		testMinHeap.insert(2);
		testMinHeap.insert(1);
		testMinHeap.insert(3);
		testMinHeap.insert(0);
		testMinHeap.insert(-1);
		testMinHeap.print();
/*
		System.out.println("");
		System.out.print("Peek: ");
		System.out.println(testMinHeap.peek());
		System.out.print("Poll: ");
		System.out.println(testMinHeap.poll());
		System.out.print("Poll: ");
		System.out.println(testMinHeap.poll());
		System.out.print("Poll: ");
		System.out.println(testMinHeap.poll());
		System.out.print("Poll: ");
		System.out.println(testMinHeap.poll());
		System.out.print("Poll: ");
		System.out.println(testMinHeap.poll());

		System.out.println("");
		testMinHeap.insert(2);
		testMinHeap.insert(1);
		testMinHeap.insert(3);
		testMinHeap.insert(0);
		testMinHeap.insert(-1);

		System.out.println("");
		System.out.println("Creating MaxHeap");
		MaxHeap testMaxHeap = new MaxHeap(testMinHeap.getHeap());
*/
		System.out.println("");
		System.out.println("Testing SortHeap: ");
		SortHeap testSortHeap = new SortHeap(testMinHeap.getHeap(),'A');
		testSortHeap.sort('D');
		testSortHeap.sort('A');

		testSortHeap.insert(5);
		testSortHeap.print();
		



	}
}