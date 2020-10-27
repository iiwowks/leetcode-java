/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private TreeNode pre = null;
    private int[] ret;
    private int retCount = 0;
    private int maxCount = 0;
    private int currCount = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        pre = null;
        ret = new int[retCount];
        retCount = 0;
        currCount = 0;
        inOrder(root);
        return ret;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre != null && pre.val == root.val)
            currCount++;
        else
            currCount = 1;
        if (currCount > maxCount) {
            maxCount = currCount;
            retCount = 1;
        } else if (currCount == maxCount) {
            if (ret != null)
                ret[retCount] = root.val;
            retCount++;
        }
        pre = root;
        inOrder(root.right);
    }
}
// @lc code=end
