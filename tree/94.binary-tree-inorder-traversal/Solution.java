/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) return res;
        while (root != null || !stack.isEmpty()) {
            // 将左分支进栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 从最左下端开始
            root = stack.pop();
            res.add(root.val);
            // 遍历当前节点的右子树
            root = root.right;
        }
        return res;
    }
}
// @lc code=end

