/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 * 方法一：合并后排序
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
// @lc code=end

