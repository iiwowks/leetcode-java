/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 * * 思路：如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
 * * 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 右半段是有序的
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 左半段是有序的
            else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
