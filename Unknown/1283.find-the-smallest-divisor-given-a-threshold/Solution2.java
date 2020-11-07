/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 */

// @lc code=start
// 暴力枚举，会超时
class Solution2 {
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1;

        while (sum(nums, i) > threshold) {
            i++;
        }
        return i;
    }
    
    public int sum(int[] nums, int x) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % x == 0) {
                res += nums[i] / x;
            }
            else {
                res += nums[i] / x + 1;
            }
        }
        return res;
    }
}
// @lc code=end

