/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 * 解题思路：选择排序
 */

// @lc code=start
class MergeSort {
    public int[] sortArray(int[] nums) {
        int size = nums.length;
        int[] temp = new int[size];
        mergeSort(nums, 0, size - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        mergeOfTwoSortedArray(nums, left, mid, right, temp);
    }

    /**
     * 合并两个有序数组
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        
        for (int i = left; i < right + 1; i++) {
            temp[i] = nums[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k < right + 1; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
// @lc code=end
