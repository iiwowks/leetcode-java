/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    List<Integer> res = new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        // 左子树
        if (root.left != null) {
            postorderTraversal(root.left);
        }
        // 右子树
        if (root.right != null) {
            postorderTraversal(root.right);
        }
        res.add(root.val);
        return res;
    }
}
// @lc code=end

