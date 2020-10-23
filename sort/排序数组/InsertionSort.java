/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 * 解题思路：插入排序
 */

// @lc code=start
class InsertionSort {
    public int[] sortArray(int[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            int temp = nums[i];
            int j = i;
            // 
            while(j > 0) {
                if (nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
// @lc code=end
