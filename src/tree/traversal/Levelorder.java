package tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder {

    public void levelorder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        print(res);
    }


    // 用递归写level order
    // 层序遍历递归需要记录层level
    public void levelorder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return;
        }
        helper(res, root, 0);
        print(res);
    }

    private void helper(List<List<Integer>> lists, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        //占位
        if (level >= lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        helper(lists, root.left, level + 1);
        helper(lists, root.right, level + 1);
    }

    private void print(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
        Levelorder lo = new Levelorder();
//        lo.levelorder(root);
        lo.levelorder2(root);
    }
}
