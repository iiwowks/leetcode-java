/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 * 解题思路：广度优先搜索
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            double tempSum = 0;
            //
            for (int i = 0; i < levelNum; i++) {
                // 左右孩子进队
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                tempSum += queue.poll().val;
            }
            res.add(tempSum / levelNum);
        }
        return res;
    }
}
// @lc code=end

