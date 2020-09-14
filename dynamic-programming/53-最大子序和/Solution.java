/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * DP方程：
 * f(i) 代表以第i个数结尾的 “连续子数组的最大和”
 * f(i) = max{f(i - 1) + nums[i], nums[i]}
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
// @lc code=end

