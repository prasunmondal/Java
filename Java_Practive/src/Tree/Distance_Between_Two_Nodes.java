package Tree;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class FindNodeDistanceInTree {
	int locNodeA;
	int locNodeB;

	public void findElements(Node root, int NodeA, int NodeB, int rootPos) {
		if (root == null || (this.locNodeA > -1 && this.locNodeB > -1))
			return;
		if (root.data == NodeA) {
			this.locNodeA = rootPos;
		}
		if (root.data == NodeB) {
			this.locNodeB = rootPos;
		}
		findElements(root.left, NodeA, NodeB, rootPos * 2);
		findElements(root.right, NodeA, NodeB, rootPos * 2 + 1);
	}

	public int nodeLevel(int node) {
		return (int) Math.floor(Math.log(node) / Math.log(2));
	}

	public int calculateDistane(int nodeA, int nodeB) {
		int rca = nodeA > nodeB ? nodeA : nodeB;
		int lca = nodeA > nodeB ? nodeB : nodeA;
		int count = 0;
		while (nodeLevel(rca) > nodeLevel(lca)) {
			rca = (int) Math.floor(rca / 2);
			count++;
		}
		while (rca != lca) {
			rca = (rca) / 2;
			lca = (lca) / 2;
			count += 2;
		}
		return count;
	}

	public int measureDistance(Node root, int nodeA, int nodeB) {
		locNodeA = locNodeB = -1;
		findElements(root, nodeA, nodeB, 1);
		return calculateDistane(locNodeA, locNodeB);
	}
}

public class Distance_Between_Two_Nodes {
	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(9);
		root.right = new Node(11);
		root.left.right = new Node(8);
		root.right.right = new Node(12);
		root.right.left = new Node(64);

		FindNodeDistanceInTree obj = new FindNodeDistanceInTree();
		System.out.println(obj.measureDistance(root, 8, 12));
	}
}
