import java.util.*;

// This binary tree uses a Node class that contains an array of Nodes.
// It uses the Node in position 0 to denote the left Node and 1 to denote the right Node of the binary tree.
public class BinaryTree{

	private Node root = null;
	private final int NUMBER_OF_CHILDREN = 2;
	private final int LEFT = 0;
	private final int RIGHT = 1;

	public void setRoot(Node root){ this.root = root; }
	public Node getRoot(){ return this.root; }


	public BinaryTree(int value)
	{
		this.root = new Node(value, NUMBER_OF_CHILDREN);
	}

	public BinaryTree(Node node)
	{
		this.root = node;
	}

	private int height(Node node)
	{
		if(node==null)
			return -1;
		else
			return node.getHeight();
	}

	private int max(int left, int right)
	{
		if(left>right)
		{
			return left;
		}
		else
		{
			return right;
		}
	}

	public Node addNode(Node newNode, Node root)
	{
		if(root==null)
		{
			root=newNode;
		}
		else if(newNode.getValue()>root.getValue())
		{
			System.out.println("Adding " + newNode.getValue() + " to RIGHT of "+root.getValue());
			newNode.setLevel(root.getLevel()+1);
			root.setChildAt(addNode(newNode,root.getChildAt(RIGHT)),RIGHT);
			if(height(root.getChildAt(RIGHT))-height(root.getChildAt(LEFT)) == 2)
			{
				if(newNode.getValue()>root.getChildAt(RIGHT).getValue())
				{
					root=rotateLeft(root);
				}
				else
				{
					root=rotateRightLeft(root);
				}
				
			}
		}
		else if(newNode.getValue()<root.getValue())
		{
			System.out.println("Adding " + newNode.getValue() + " to LEFT of "+root.getValue());
			newNode.setLevel(root.getLevel()+1);
			root.setChildAt(addNode(newNode,root.getChildAt(LEFT)),LEFT);
			if(height(root.getChildAt(LEFT))-height(root.getChildAt(RIGHT))==2)
			{
				if(newNode.getValue()>root.getChildAt(LEFT).getValue())
				{
					root=rotateLeftRight(root);
				}
				else
				{
					root=rotateRight(root);
				}
			}
		}

		root.setHeight(max(height(root.getChildAt(LEFT)),height(root.getChildAt(RIGHT)))+1);
		return root;
	}

	public void addNodeByValue(int value)
	{
		Node newNode = new Node(value, NUMBER_OF_CHILDREN);
	  	this.root=addNode(newNode,this.root);
	}

	public Node rotateRight(Node root)
	{
		System.out.println("Rotating Right Node: "+root.getValue());
		Node temp = root.getChildAt(LEFT);

		root.setChildAt(temp.getChildAt(RIGHT), LEFT);
		temp.setChildAt(root,RIGHT);

		// Adjust heights of the rotated nodes
		root.setHeight(max(height(root.getChildAt(LEFT)),height(root.getChildAt(RIGHT)))+1);
		temp.setHeight(max(height(temp.getChildAt(LEFT)),height(temp.getChildAt(RIGHT)))+1);

		// Adjust levels of the rotated nodes
		root.setLevel(root.getLevel()+1);
		temp.setLevel(temp.getLevel()-1);
		modifyTreeLevels(root.getChildAt(RIGHT),+1);
		modifyTreeLevels(temp.getChildAt(LEFT),-1);

		return temp;
	}

	public Node rotateLeft(Node root)
	{
		System.out.println("Rotating Left Node: "+root.getValue());
		Node temp = root.getChildAt(RIGHT);

		root.setChildAt(temp.getChildAt(LEFT), RIGHT);
		temp.setChildAt(root,LEFT);

		// Adjust heights of the rotated nodes
		root.setHeight(max(height(root.getChildAt(LEFT)),height(root.getChildAt(RIGHT)))+1);
		temp.setHeight(max(height(temp.getChildAt(LEFT)),height(temp.getChildAt(RIGHT)))+1);

		// Adjust levels of the rotated nodes
		root.setLevel(root.getLevel()+1);
		temp.setLevel(temp.getLevel()-1);
		modifyTreeLevels(root.getChildAt(LEFT),+1);
		modifyTreeLevels(temp.getChildAt(RIGHT),-1);
		
		return temp;
	}

	public Node rotateLeftRight(Node root)
	{
		// Rotate root->left to the left and change root->left to point to the new node who was root->left->right before.
		root.setChildAt(rotateLeft(root.getChildAt(LEFT)),LEFT);
		return rotateRight(root);
	}

	public Node rotateRightLeft(Node root)
	{
		// Rotate root->right to the right and change root->right to point to the new node who was root->right->left before.
		root.setChildAt(rotateRight(root.getChildAt(RIGHT)),RIGHT);
		return rotateLeft(root);
	}

	public void modifyTreeLevels(Node root, int value)
	{
		if(root==null) return;
		root.setLevel(root.getLevel()+value);
		modifyTreeLevels(root.getChildAt(LEFT), value);
		modifyTreeLevels(root.getChildAt(RIGHT), value);
	}


	public Node search(int value)
	{
		Node iterator = this.root;
		while(iterator!=null)
		{
			System.out.println("Comparing with: "+iterator.getValue());
			if(iterator.getValue()==value)
			{
				System.out.println("Found value in: "+iterator.getValue());
				return iterator;
			}
			else if(value>iterator.getValue())
			{
				iterator = iterator.getChildAt(RIGHT);
			}
			else if(value<iterator.getValue())
			{
				iterator = iterator.getChildAt(LEFT);
			}
		}
		System.out.println("The value was not found");
		return null;
	}

	public void print()
	{
		print(this.root);
	}

	public void print(Node root)	
	{
		if(root == null) return;
		Queue<Node> queue = new LinkedList<Node>();
		Node current;
		queue.add(root);
		int currentLevel = root.getLevel();
		while(queue.peek()!=null)
		{
			current = queue.poll();

			if(current.getChildAt(LEFT)!=null)
			{
				queue.add(current.getChildAt(LEFT));
			}
			if(current.getChildAt(RIGHT)!=null)
			{
				queue.add(current.getChildAt(RIGHT));
			}
			
			if(currentLevel<current.getLevel())
			{
				currentLevel = current.getLevel();
				System.out.println();
			}
			
			System.out.print(current.getValue()+" ");
			//System.out.print(current.getValue()+" level: "+current.getLevel()+" ");

		}
	}
	
}