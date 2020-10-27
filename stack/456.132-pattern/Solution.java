/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            // find the min value of current index
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

