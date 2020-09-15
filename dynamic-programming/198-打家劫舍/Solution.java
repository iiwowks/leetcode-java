/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 * dp方程：
 * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])  2 <= i < nums.length
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notrob = 0;
        for (int i = 0; i < nums.length; i++) {
            int currob = notrob + nums[i];
            notrob = Math.max(notrob, rob);
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}
// @lc code=end

