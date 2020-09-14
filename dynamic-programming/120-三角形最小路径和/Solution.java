/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 * 1. 重复性
 * 2. 定义状态数组: f[i][j]：表示从点(i, j)开始的最小路径和
 * 3. DP方程：f[i][j] = min(f[i + 1][j] + f[i + 1][j + 1]) + a[i][j]
 * 
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
// @lc code=end

