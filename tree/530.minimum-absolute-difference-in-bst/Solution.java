/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //
        inOrder(root.left);
        //
        if (pre != null && Math.abs(root.val - pre.val) < res) {
            res = Math.abs(root.val - pre.val);
        }
        pre = root;
        //
        inOrder(root.right);
    }
}

// class Solution {
//     private int res = Integer.MAX_VALUE;
//     private TreeNode preNode = null;
    
//     public int getMinimumDifference(TreeNode root) {
//         inOrder(root);
//         return res;
//     }
    
//     private void inOrder(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         inOrder(root.left);
//         //
//         if (preNode != null) {
//             res = Math.min(Math.abs(root.val - preNode.val), res);
//         }
//         preNode = root;
//         //
//         inOrder(root.right);
//     }
// }
// @lc code=end

