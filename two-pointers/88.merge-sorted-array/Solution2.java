/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 * 方法二：双指针
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int i = 0, j = 0, index = 0;
        while ((i < m) && (j < n)) {
            nums1[index++] = (nums1_copy[i] < nums2[j]) ? nums1_copy[i++] : nums2[j++];
        }
        //
        if (i < m) {
            System.arraycopy(nums1_copy, i, nums1, i + j, m + n - i - j);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
        }
    }
}
// @lc code=end

