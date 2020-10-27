/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 * dp方程：
 * dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])  2 <= i < nums.length
 * 使用两个变量优化空间
 */

// @lc code=start
class Solution3 {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;
    
        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }
    
        return curr;
    }
}
// @lc code=end

