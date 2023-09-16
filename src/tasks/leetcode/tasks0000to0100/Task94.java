package tasks.leetcode.tasks0000to0100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 11 минут
 */
public class Task94 {
    /**
     * Этот класс дан из условия задачи.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static void deepInto(TreeNode node, ArrayList<Integer> result) {
        if (node == null) return;
        deepInto(node.left, result);
        result.add(node.val);
        deepInto(node.right, result);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayList<Integer> result = new ArrayList<>();
        deepInto(root.left, result);
        result.add(root.val);
        deepInto(root.right, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(inorderTraversal(root));
    }
}
