/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 * 解题思路：二分查找
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
    }
}
// @lc code=end

