/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 * 解题思路：线性搜索
 */

// @lc code=start
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        
        // find the index of the leftmost appearance of target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        // base case
        if (targetRange[0] == -1) {
            return targetRange;
        }
        // find the index of the rightmost appearance of target
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                targetRange[1] = j;
                break;
            }
        }
        return targetRange;
    }
}
// @lc code=end

