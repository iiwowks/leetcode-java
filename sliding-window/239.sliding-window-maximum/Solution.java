/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// 方法一：暴力法：遍历每个滑动窗口， 一共有N - k + 1个滑动窗口
// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0]; // n 与 k均不为零
        
        int[] output = new int[n - k + 1];
        
        // 窗口移动
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            // 窗口内的遍历
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }
}
// @lc code=end

