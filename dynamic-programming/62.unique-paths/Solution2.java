/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 * 解题思路：
 * 状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
 * 自底向上，不存整个二维数组，只保存一行数据
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
// @lc code=end

