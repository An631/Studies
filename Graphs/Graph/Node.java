import java.util.*;

public class Node <K>
{
	private K value;
	public K getValue(){ return this.value; }
	public void setValue (K value) { this.value = value; }

	// This Node works with any number of connections to other nodes. It can be used as any type of graph
	private Map<Node<K>,Integer> children;
	public Map<Node<K>,Integer> getChildren(){ return this.children;}
	public void putChild(Node<K> key, int pathWeight) { this.children.put(key,pathWeight);}


	public Node(K value, Map<Node<K>, Integer> children)
	{
		this.value = value;
		this.children = children;
	}

	public Node(K value)
	{
		this.value=value;
		this.children = new HashMap<Node<K>, Integer>();
	}
}