package Tree;

class BinaryNode {
	int data;
	BinaryNode left, right;

	public BinaryNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class BinaryTree {
	BinaryNode root;

	public BinaryTree() {
		root = null;
	}

	public int getHeight(BinaryNode node, int height) {
		if (node == null) {
			return height;
		}
		int height1 = getHeight(node.left, height + 1);
		int height2 = getHeight(node.right, height + 1);
		return height1 > height2 ? height1 : height2;
	}
}

public class BinaryTree_Ops {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new BinaryNode(23);
		bt.root.left = new BinaryNode(21);
		bt.root.left.left = new BinaryNode(21);
		System.out.println(bt.getHeight(bt.root, 0));
	}
}
