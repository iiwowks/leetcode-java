/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 * 解题方法：递归
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }
}
// @lc code=end

