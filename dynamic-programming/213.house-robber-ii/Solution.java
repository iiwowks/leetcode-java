/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 * 1. 在不偷窃第一个房子的情况下（即 nums[1:]），最大金额是 p1 
 * 2. 在不偷窃最后一个房子的情况下（即 nums[:n-1]），最大金额是 p2 
 * 3. 综合偷窃最大金额： 为以上两种情况的较大值，即 max(p1,p2)
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob_help(Arrays.copyOfRange(nums, 1, nums.length)),
                rob_help(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int rob_help(int[] nums) {
        int pre = 0, cur = 0, temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }
}
// @lc code=end

