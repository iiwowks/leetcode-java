/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
 * 
 * 二叉树中找到每一层最大值
 * 解题思路：DFS
 * Use depth to expand result list size and put the max value in the appropriate position.
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        // expand list size
        if (level == res.size()) {
            res.add(root.val);
        } else {
            // or set value
            res.set(level, Math.max(res.get(level), root.val));
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}

// @lc code=end
