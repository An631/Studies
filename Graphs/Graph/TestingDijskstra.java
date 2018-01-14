import java.util.*;

public class TestingDijskstra {
	
	private static Stack<Node<Character>> visited = new Stack<Node<Character>>();
	public static void main(String args[])
	{
		Node<Character> nodeA = new Node<Character>('A');
		Node<Character> nodeB = new Node<Character>('B');
		Node<Character> nodeC = new Node<Character>('C');
		Node<Character> nodeD = new Node<Character>('D');
		Node<Character> nodeE = new Node<Character>('E');
		Node<Character> nodeF = new Node<Character>('F');
		Node<Character> nodeG = new Node<Character>('G');
		Node<Character> nodeH = new Node<Character>('H');

		nodeA.putChild(nodeC,1);
		nodeA.putChild(nodeD,2);
		nodeA.putChild(nodeE,3);
		nodeA.putChild(nodeG,1);

		nodeC.putChild(nodeB,4);
		nodeC.putChild(nodeD,0);

		nodeD.putChild(nodeB,5);
		nodeD.putChild(nodeA,1);

		nodeE.putChild(nodeB,6);
		nodeE.putChild(nodeF,0);

		nodeG.putChild(nodeH,1);

		nodeH.putChild(nodeB,1);

		System.out.println("Find fastest path between node A and node B: "+findPathDijskstra(nodeA,nodeB));
	}

	public static int findPathDijskstra(Node<Character> start, Node<Character> target)
	{

		// Find out if we have reach our destination
		if(start == target) 
		{
			System.out.println("Got to target node"+start.getValue());
			return 0;
		}
	
		System.out.println("In node"+start.getValue());
		// Used to find the minimum value used to reach each node
		// we use max/2 to avoid an overflow that will cause negative numbers to show
		int min = Integer.MAX_VALUE/2;

		visited.push(start);

		for(Node<Character> child : start.getChildren().keySet())
		{
			// We have reached a node that was already visited in this recurssion, return with a max value to avoid this path.
			if(visited.search(child)>-1) {
				System.out.println("Node"+child.getValue()+" already visited");
				return Integer.MAX_VALUE/2;
			}

			int pathWeight;
			pathWeight = findPathDijskstra(child,target)+start.getChildren().get(child);

			if(pathWeight<min)
			{
				System.out.println("Found smaller value than "+min+": "+pathWeight);
				min = pathWeight;

			}
		}

		visited.pop();
		return min;
	}
}