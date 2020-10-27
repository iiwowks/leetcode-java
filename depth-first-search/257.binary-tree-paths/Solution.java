/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode r, StringBuilder sb) {
        if (r == null) return;
        sb.append(r.val);

        if (r.left == null && r.right == null) {
            res.add(sb.toString());
        }
        dfs(r.left, new StringBuilder(sb).append("->"));
        dfs(r.right, new StringBuilder(sb).append("->"));
    }
}
// @lc code=end

