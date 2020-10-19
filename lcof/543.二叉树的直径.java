/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode( int x){ val = x;}
}
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1; 
    }
    public int depth(TreeNode node){
        //访问到空节点了，返回零
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);

        ans = Math.max(ans,L+R+1);  //计算d_note的值 L+R+1, 并更新ans
        return Math.max(L,R) + 1;   //返回该节点为根的子树深度
    }
}
// @lc code=end

