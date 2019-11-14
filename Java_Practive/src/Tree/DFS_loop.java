package Tree;

import java.util.Stack;

public class DFS_loop {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return this.data + "";
		}

		public void DFS(Node root) {
			Stack<Node> stack = new Stack<Node>();
			if (root == null)
				return;
			stack.add(root);

			while (!stack.isEmpty()) {
				Node popped = stack.pop();
				System.out.print(popped + " ");
				if (popped.right != null)
					stack.add(popped.right);
				if (popped.left != null)
					stack.add(popped.left);
			}
		}
	}

	public static void main(String[] args) {

//						50
//					  /    \
//					25		75
//				   /  \	   /  \
//				  10  30  60  85

		Node root = new DFS_loop().new Node(50);
		root.left = new DFS_loop().new Node(25);
		root.right = new DFS_loop().new Node(75);
		root.left.left = new DFS_loop().new Node(10);
		root.left.right = new DFS_loop().new Node(30);
		root.right.left = new DFS_loop().new Node(60);
		root.right.right = new DFS_loop().new Node(85);
		root.DFS(root);

	}
}
