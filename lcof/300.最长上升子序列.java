import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start

// 动态规划： 状态转移方程； dp[i] = max(dp[i], dp[j] + 1) for j in [0,i)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
            res = Math.max(res , dp[i]);
        }
        return res;
    }
}
// @lc code=end
