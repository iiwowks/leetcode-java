/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 * 解题思路：选择排序
 */

// @lc code=start
class SelectSort {
    public int[] sortArray(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
