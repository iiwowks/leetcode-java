/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 * 解题思路：动态规划
 * dp方程：创建一个二维数组
 * if s1[-1] != s2[-1]:     lcs[s1, s2] = max(lcs[s1 - 1, s2], lcs[s1, s2 - 1])
 * if s1[-1] == s2[-1]:     lcs[s1, s2] = lcs[s1 - 1, s2 - 1] + 1
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

