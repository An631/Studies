import java.util.*;

public class TestingLinkedLists{
	public static void main(String args[])
	{
		SingleLinkedListWithChildren linkedList = new SingleLinkedListWithChildren(0);
		SingleLinkedListWithChildren children1 = new SingleLinkedListWithChildren(6);
		SingleLinkedListWithChildren children2 = new SingleLinkedListWithChildren(11);

		System.out.println();
		System.out.println("Children1:");
		for(int i = 7; i<=10; i++)
		{
			
			children1.addNodeByValue(i);
			children1.printList(children1.getHead());
		}

		System.out.println();
		System.out.println("Children2:");
		for(int i = 12; i<=15; i++)
		{
			
			children2.addNodeByValue(i);
			children2.printList(children2.getHead());
		}

		System.out.println();
		System.out.println("LinkedList:");
		for(int i = 1; i<=5; i++)
		{
			linkedList.addNodeByValue(i);
			linkedList.printList(linkedList.getHead());
		}

		System.out.println();
		System.out.println("Adding Children:");
		// Add children to the linkedList
		linkedList.getNodeAt(2).setLeftNode(children1.getHead());
		linkedList.getNodeAt(3).setLeftNode(children2.getHead());
		linkedList.printList(linkedList.getHead());

		System.out.println();
		System.out.println("Point tails to children:");
		// Point tails to children for muru's weird question.
		linkedList.getNodeAt(linkedList.length()-1).setNextNode(children1.getHead());
		linkedList.printList(linkedList.getHead());
		
		System.out.println();
		children1.getNodeAt(children1.length()-1).setNextNode(children2.getHead());
		children1.printList(children1.getHead());

		System.out.println();
		System.out.println("Printing finalized tails pointing to children problem: ");
		linkedList.printList(linkedList.getHead());
		System.out.println();
		System.out.println("Undoing Tails to children pointers Muru's weird question: ");
		undoTailsToChildren(linkedList.getHead());
		System.out.println("printing: ");
		linkedList.printList(linkedList.getHead());

/*
		System.out.println();
		for(int i = 5; i>=0; i--)
		{
			linkedList.deleteNodeByValue(i);
			linkedList.printList(linkedList.getHead());	
		}
		
		System.out.println();
		for(int i = 1; i<=10; i+=2)
		{
			linkedList.addNodeByValue(i);
			linkedList.printList(linkedList.getHead());
		}

		linkedList.deleteNodeByValue(100);
*/
	}

	// Unflattens a list that was flatened but still has all the children pointers active.
	public static void undoTailsToChildren(Node head)
	{
		// Pointer to search for nodes with a child
		Node childSearcher = head;

		// Pointer to search for the pointer that is pointing to a child
		Node pointerSearcher = null;

		// Array to keep track of all the pointers that are pointing to a child.
		// These pointers will have their .next node pointer set to null.
		ArrayList<Node> toRemove = new ArrayList<Node>();

		while(childSearcher != null)
		{
			// getLeftNode() returns the pointer to children. Using "Left" for children as this Node class can be used for trees too.
			if(childSearcher.getLeftNode()!=null)
			{
				// Only the first time this needs to be initialized. Afterwards it will just continue from last position.
				if(pointerSearcher==null)
				{
					pointerSearcher=childSearcher;
				}

				// We need to find the tail that is pointing to this same child
				// We assume the linked list was correctly flattened and so the child has te be pointed by another node in the list.
				// if this is not true the linked list has a child that is not part of the "flattened list" and we will hit a exception trying to get next node of null.
				while(childSearcher.getLeftNode()!=pointerSearcher.getNextNode())
				{
					pointerSearcher = pointerSearcher.getNextNode();
				}

				// Once found save the node for later deletion.
				// We can't delete the pointer now because childrenSearcher needs to continue searching all the pointers until it hits the end of the flattened list.
				toRemove.add(pointerSearcher);
			}

			childSearcher=childSearcher.getNextNode();
		}

		// Remove the .next pointer of all the nodes that were saved.
		for(Node node : toRemove)
		{
			node.setNextNode(null);
		}
	}
}