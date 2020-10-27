/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 * 解题思路：快速排序
 */

// @lc code=start
class QuickSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start ,int end ) {
        if(start >= end) return ;
        int left = start, right= end;
        // 枢轴
        int pivot = nums[(left + right )/2];

        while (left <= right){
            while (left<= right && nums[left] < pivot){
                left ++;
            }
            while ( left <= right && nums[right] > pivot){
                right--;
            } 
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}
// @lc code=end
