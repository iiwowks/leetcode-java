/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 * 方法一：单指针：
 * * 使用一个指针ptr表示头部的范围， 从左向右遍历，找到0，就与nums[head]交换，head++
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }
}
// @lc code=end

