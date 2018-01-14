import java.util.*;

public class TestingTrees {
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree(7);

		System.out.println("Populating tree:");
		tree.addNodeByValue(5);
		tree.addNodeByValue(8);
		tree.addNodeByValue(6);
		tree.addNodeByValue(1);
		tree.print();
		tree.addNodeByValue(2);
		tree.addNodeByValue(10);
		tree.addNodeByValue(9);
		tree.addNodeByValue(3);
		tree.print();

		//System.out.println("Searching value 2 =" + tree.search(2).getValue());
		//System.out.println("Searching value 5 =" + tree.search(5).getValue());
		//System.out.println("Searching value 10 =" + tree.search(10).getValue());
	}
}