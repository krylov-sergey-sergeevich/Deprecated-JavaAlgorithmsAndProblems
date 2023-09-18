package tasks.leetcode.tasks1300to1400;

import java.util.ArrayList;
import java.util.List;

/**
 * 1302. Deepest Leaves Sum
 * https://leetcode.com/problems/deepest-leaves-sum/
 * 1 час
 * Medium
 * Заметка: static коварная штука =)
 */
public class Task1302 {

    private static List<Integer> result;
    private static Integer maxDepth = 0;

    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return buildTreeFromArray(arr, 0);
    }

    private static TreeNode buildTreeFromArray(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = buildTreeFromArray(arr, 2 * index + 1);
        node.right = buildTreeFromArray(arr, 2 * index + 2);

        return node;
    }

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

    public static int deepestLeavesSum(TreeNode root) {
        result = new ArrayList<>();
        maxDepth = 0;
        dfs(root, 1);
        System.out.println(result);
        return result.stream().mapToInt(Integer::intValue).sum();
    }

    public static void dfs(TreeNode node, int d) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.println("Found list " + node.val + " | " + d + " | " + maxDepth);
            if (d == maxDepth) {
                result.add(node.val);
                System.out.println(result);
            }
            if (d > maxDepth) {
                maxDepth = d;
                System.out.println("D = " + d);
                System.out.println(result);
                result = new ArrayList<>();
                result.add(node.val);
            }
        } else {
            dfs(node.left, d + 1);
            dfs(node.right, d + 1);
        }
    }

    public static void main(String[] args) {
        int res1 = deepestLeavesSum(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(7, null, null),
                                        null
                                ),
                                new TreeNode(5, null, null)
                        ),
                        new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8)))


                )
        );

        System.out.println(res1);


        Integer[] arr = {6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        TreeNode root = arrayToTree(arr);
        System.out.println(deepestLeavesSum(root));

        Integer[] arr2 = {37, 97, 18, null, 13, 18};
        ;
        System.out.println(deepestLeavesSum(arrayToTree(arr2)));
    }

}
