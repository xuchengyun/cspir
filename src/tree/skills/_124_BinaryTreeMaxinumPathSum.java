package tree.skills;

import tree.binarySearchTree.TreeNode;

public class _124_BinaryTreeMaxinumPathSum {

    int res;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
