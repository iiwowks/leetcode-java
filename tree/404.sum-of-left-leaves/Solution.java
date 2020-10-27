/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return root != null ? dfs(root) : 0;
    }

    public int dfs(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            res += dfs(root.right);
        }
        return res;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
// @lc code=end

