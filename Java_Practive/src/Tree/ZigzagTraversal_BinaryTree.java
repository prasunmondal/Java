package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTraversal_BinaryTree {

	class TreeNode {
		int value;
		TreeNode left, right;

		public TreeNode(int value) {
			this.value = value;
			left = right = null;
		}
	}

	public void zigzag(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<ZigzagTraversal_BinaryTree.TreeNode>();
		Stack<TreeNode> stack = new Stack<ZigzagTraversal_BinaryTree.TreeNode>();
		
		que.add(root);
		boolean odd = true;
		
		while (!que.isEmpty()) {
			odd = !odd;
			stack = new Stack<ZigzagTraversal_BinaryTree.TreeNode>();
			while (!que.isEmpty()) {
				TreeNode temp = que.remove();
				System.out.print(temp.value + " ");

				if (odd) {
					if (temp.left != null)
						stack.add(temp.left);

					if (temp.right != null)
						stack.add(temp.right);
				} else {
					if (temp.right != null)
						stack.add(temp.right);
					
					if (temp.left != null)
						stack.add(temp.left);
				}
			}

			System.out.println();
			while (!stack.empty()) {
				que.add(stack.pop());
			}
		}
	}

	public static void main(String[] args) {

		ZigzagTraversal_BinaryTree tree = new ZigzagTraversal_BinaryTree();
		ZigzagTraversal_BinaryTree.TreeNode root = tree.new TreeNode(50);

		root.left = tree.new TreeNode(25);
		root.right = tree.new TreeNode(75);
		root.left.left = tree.new TreeNode(15);
		root.left.right = tree.new TreeNode(35);
		root.right.left = tree.new TreeNode(60);
		root.right.right = tree.new TreeNode(100);
		root.left.left.left = tree.new TreeNode(10);
		root.left.left.right = tree.new TreeNode(20);
		root.left.right.left = tree.new TreeNode(30);
		root.left.right.right = tree.new TreeNode(40);
		root.right.left.left = tree.new TreeNode(51);
		root.right.left.right = tree.new TreeNode(70);
		root.right.right.left = tree.new TreeNode(80);
		root.right.right.right = tree.new TreeNode(120);

		tree.zigzag(root);
	}
}

//								50
//				25								75
//		15				35  			60				100
//10 		20 		30 		40		51		70		80		120
