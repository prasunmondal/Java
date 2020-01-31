package Tree;

public class Symmetric_BinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		
		return isSymmetricUtil(root.left, root.right);
	}
	
	private static boolean isSymmetricUtil(TreeNode left, TreeNode right) {
		if(left==null && right==null)
			return true;
		
		if(left==null || right==null)
			return false;
		
		if(left.val != right.val)
			return false;
					
		return isSymmetricUtil(left.right, right.left) && isSymmetricUtil(left.left, right.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
