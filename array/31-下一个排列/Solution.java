/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--; // 找到第一个在降序中的逆序对
        if (i >= 0) {  // 如果不是全体降序
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--; // j 指向逆序对第二个
            swap(nums, i, j); // 交换值
        }
        // 逆序降序序列
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }
}
// @lc code=end

