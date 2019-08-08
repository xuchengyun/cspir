package tree.leetcode;

public class _116_PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        // 必须知道父亲节点
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.right;
        }
        connect(root.left);
        connect(root.right);
    }
}
