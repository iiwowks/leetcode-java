/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> val = new ArrayList<>();
        inorder(root, val);
        TreeNode dummyHead = new TreeNode(0);
        TreeNode cur = dummyHead;
        for (int value : val) {
            cur.right = new TreeNode(value);
            cur = cur.right;
        }
        return dummyHead.right;
        
    }
    public void inorder(TreeNode node, List<Integer> val) {
        if (node == null) {
            return;
        }
        inorder(node.left, val);
        val.add(node.val);
        inorder(node.right, val);
    }
}
// @lc code=end

