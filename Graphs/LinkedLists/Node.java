
public class Node
{
	private int value;
	public int getValue(){ return this.value; }
	public void setValue (int value) { this.value = value; }

// In trees this is treated as the right node.
	private Node next;
	public Node getNextNode(){ return this.next; }
	public void setNextNode(Node next){ this.next = next; }

// For double linked list:
	private Node previous;
	public Node getPreviousNode(){ return this.previous; }
	public void setPreviousNode(Node previous){ this.previous = previous; }

// For tree implementations. Also works as child in muru's weird question xD.
	private Node left;
	public Node getLeftNode(){ return this.left; }
	public void setLeftNode(Node left){ this.left = left; }

// Mostly used to insert a node in a tree. Previous should be set to null
	public Node(int value, Node next, Node previous, Node left)
	{
		this.value = value;
		this.next = next;
		this.previous = previous;
		this.left = left;
	}

// Mostly used to insert a node in a double linked list
	public Node(int value, Node next, Node previous)
	{
		this.value = value;
		this.next = next;
		this.previous = previous;
		this.left = null;
	}

// Used to insert a Node in a single linked list
	public Node(int value, Node next)
	{
		this.value=value;
		this.next = next;
		this.previous = null;
		this.left=null;
	}

// Used to insert the first node of a linked list or at the end of a single linked List
	public Node(int value)
	{
		this.value=value;
		this.next = null;
		this.previous = null;
		this.left = null;
	}

}