package tree.skills;

import tree.binarySearchTree.TreeNode;

public class _104_MaxinumDepthofBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
