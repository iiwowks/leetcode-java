/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if (root == null) return list;
        while (root != null || !stack.isEmpty()) {
            // 将左分支进栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 从最左下端开始
            root = stack.pop();
            list.add(root.val);
            // 遍历当前节点的右子树
            root = root.right;
        }
        return list;
    }
}
// @lc code=end

