package Tree.RepeatPractice;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		left = null;
		right = null;
		this.data = data;
	}
}

class Binary_Tree {
	Node root;

	public Binary_Tree() {
		root = null;
	}

	public int getPosition(Node node, int a, int pos) {
		if (node == null)
			return 0;
		if (node.data == a) 
			return pos;
		
		return getPosition(node.left, a, pos * 2) + getPosition(node.right, a, pos * 2 + 1);
	}

	public int calculatePathDistance(int parentOfA, int parentOfB) {
		int distance = 0;
		while (parentOfA != parentOfB) {
			if (parentOfA > parentOfB)
				parentOfA = parentOfA >> 1;
			else
				parentOfB = parentOfB >> 1;
			distance++;
		}
		return distance;
	}

	public int find_distance_between(int a, int b) {
		int posA = getPosition(root, a, 1);
		int posB = getPosition(root, b, 1);

		if (posA == 0 || posB == 0) // any one or more nodes doesn't exist
			return -1;

		return calculatePathDistance(posA, posB);
	}
}

public class Distance_Between_Two_Nodes {
	public static void main(String[] args) {
		Binary_Tree bt = new Binary_Tree();

		// 1.50
		// 2.25 3.75
		// 4.13 5.20 6.60 7.80
		// 13.17 15.90

		bt.root = new Node(50);
		bt.root.left = new Node(25);
		bt.root.right = new Node(75);
		bt.root.left.left = new Node(13);
		bt.root.left.right = new Node(20);
		bt.root.right.left = new Node(60);
		bt.root.right.right = new Node(80);
		bt.root.right.right.right = new Node(90);
		bt.root.left.left.right = new Node(17);
		
		System.out.println(bt.find_distance_between(50, 50));
		System.out.println(bt.find_distance_between(50, 25));
		System.out.println(bt.find_distance_between(25, 50));
		System.out.println(bt.find_distance_between(75, 25));
		System.out.println(bt.find_distance_between(13, 80));
		System.out.println(bt.find_distance_between(90, 13));
		System.out.println(bt.find_distance_between(90, 17));
	}
}
