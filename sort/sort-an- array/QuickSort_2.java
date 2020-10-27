/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 * 解题思路：快速排序
 */

// @lc code=start
class QuickSort_2 {
    public int[] sortArray(int[] nums) {
        int size = nums.length;
        quickSort(nums, 0, size - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        // 选择nums[left]作为主元
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i < right + 1; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, lt, i);
            }
        }
        swap(nums, lt, left);
        return lt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
