
public class SingleLinkedListWithChildren{

	private Node head = null;
	public void setHead(Node head){ this.head = head; }
	public Node getHead()	{ return this.head; }

	public SingleLinkedListWithChildren(int value)
	{
		this.head = new Node(value,null,null);
	}

	public SingleLinkedListWithChildren(Node node)
	{
		this.head = node;
	}

	public void addNodeByValue(int value)
	{
		Node newNode = new Node(value);

		if(this.head == null)
		{
			this.head = newNode;
			System.out.println("Added node "+newNode.getValue()+" as head of the list.");
			return;
		}

		Node iteratorNode = head;
		// Go through the list until we hit the tail
		while(iteratorNode.getNextNode() != null)
		{
			iteratorNode = iteratorNode.getNextNode();
		}

		// Add the newNode at the end of the list
		iteratorNode.setNextNode(newNode);
		System.out.println("Added Node: " + newNode.getValue() + " after Node: " +iteratorNode.getValue());
	}

	// Deletes the first value found that matches the provided value.
	public boolean deleteNodeByValue(int value)
	{

		if(this.head==null)
		{
			System.out.println("The single linked list is empty. Use addNodeByValue to add Nodes to the list.");
			return false;
		}

		// Check if value is in head node
		if(head.getValue() == value)
		{
			// If we delete head, then make the next in line the head now.
			System.out.println("Deleted Node: "+this.head.getValue());
			this.head = head.getNextNode();
			return true;
		}

		Node iteratorNode = this.head;
		while(iteratorNode.getNextNode() != null)
		{
			if(iteratorNode.getNextNode().getValue() != value)
			{
				// Run until we find the value we are looking for.
				iteratorNode = iteratorNode.getNextNode();
				continue;
			}

			// Temporarily save the node to delete
			Node temp = iteratorNode.getNextNode();
			// Connect its previous node to its next node to remove it from the list.
			iteratorNode.setNextNode(iteratorNode.getNextNode().getNextNode());
			// "Delete" the node object (not necessarily in java really)
			System.out.println("Deleted Node: "+temp.getValue());
			temp = null;
			return true;
		}

		System.out.println("Value to delete is not found inside list.");
		return false;
	}

	// Returns the nth node counting from head, when head is 0
	public Node getNodeAt(int number)
	{
		if(number < 0)
		{
			System.out.println("getNodeAt() only accepts positive values.");
			return null;
		}

		if(this.head==null)
		{
			System.out.println("The single linked list is empty. Use addNodeByValue to add Nodes to the list.");
			return null;
		}
		
		// Iterate all the list until we find the nth node so we can return it.
		Node iterator = this.head;
		while(iterator.getNextNode() != null && number > 0)
		{
			iterator=iterator.getNextNode();
			number--;
		}

		if(number>0) 
		{
			System.out.println("The number requested was bigger than the list size.");
			return null;
		}

		return iterator;

	}

	// Returns the length of the first level of the linked list. No children are counted
	public int length()
	{
		int counter=0;
		Node iterator = head;
		while(iterator!=null)
		{
			iterator=iterator.getNextNode();
			counter++;
		}
		return counter;
	}

	public void printList(Node head)
	{
		if(head==null)
		{
			System.out.println("The list is empty");
			return;
		}

		Node iteratorNode = head;
		System.out.print(iteratorNode.getValue());
		// Go through the list until we print all values
		while(iteratorNode.getNextNode() != null)
		{
			if(iteratorNode.getLeftNode()!=null)
			{
				System.out.println();
				System.out.println("Children of "+iteratorNode.getValue()+": ");
				printList(iteratorNode.getLeftNode());
			}

			iteratorNode = iteratorNode.getNextNode();
			System.out.print("->"+iteratorNode.getValue());
		}
		// Skip a line now that the list was printed
		System.out.println("");
	}

}