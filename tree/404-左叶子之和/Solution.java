/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 * 解题思路：遍历所有node，当它的左节点是一个叶子节点，就把左节点的值累加
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
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
