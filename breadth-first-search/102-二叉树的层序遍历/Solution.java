/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // 创建队列
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>(); // 结果List
        
        if (root == null) return wrapList; // 出口

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum  = queue.size();
            List<Integer> subList = new LinkedList<Integer>(); // 层结果
            // 在本层内
            for (int i = 0; i < levelNum; i++) {
                // 将左右孩子进队
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val); // 队列头出队
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
// @lc code=end

