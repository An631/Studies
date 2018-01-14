import java.util.*;

public class Node
{
	private int value;
	public int getValue(){ return this.value; }
	public void setValue (int value) { this.value = value; }

	// This Node works with any number of connections to other nodes. It can be used as any type of graph
	private Node[] children;
	public Node[] getChildren(){ return this.children; }
	public Node getChildAt(int index){ return this.children[index]; }
	public void setChildAt(Node child, int index) { this.children[index] = child;}

	private int level;
	public int getLevel(){return this.level;}
	public void setLevel(int level){this.level=level;}

	private int height;
	public int getHeight(){return this.height;}
	public void setHeight(int height){this.height=height;}


	public Node(int value, Node[] children)
	{
		this.value = value;
		this.children = children;
		this.level=0;
		this.height=0;
	}

	public Node(int value, int maxChildren)
	{
		this.value=value;
		this.children = new Node[maxChildren];
		this.level=0;
		this.height=0;
	}
}