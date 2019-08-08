package tree.skills;

import tree.binarySearchTree.TreeNode;

public class _230_KthSmallestElementinaBST {

    int count;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = 0;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
