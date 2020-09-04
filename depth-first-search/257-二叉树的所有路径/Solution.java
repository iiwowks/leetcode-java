/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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

