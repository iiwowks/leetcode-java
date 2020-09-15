/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 * dp方程：
 * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])  2 <= i < nums.length
 * 空间未优化： 使用一维数组
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[N];
    }
}
// @lc code=end

