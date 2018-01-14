public class TestingQuickSort{

	public static void main(String args[])
	{
		QuickSort sorter = new QuickSort();
		sorter.print();
		sorter.sort();

		System.out.println("");
		System.out.println("Sort 2");
		QuickSort sorter2 = new QuickSort();
		sorter2.print();
		sorter2.sort2();
		
	}
}