/*
 * @lc app=leetcode id=1283 lang=java
 *
 * [1283] Find the Smallest Divisor Given a Threshold
 * 题意：找到最小的的除数，除以数组，得到的sum小于 threshold (这里的除法：商 <= 商的最近整数)
 * 解题思路：暴力 + 二分查找
 */

// @lc code=start
class Solution {
    public long computeSum(int[] nums, int x) {
        long s = 0;
        for (int n : nums) {
            s += n / x + (n % x == 0 ? 0 : 1);
        }
        return s;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        // 找到除数的范围
        int left = 1, right = 2;
        while (computeSum(nums, right) > threshold) {
            left = right;
            right *= 2;
        }
        // 二分查找
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            long num = computeSum(nums, pivot);
            
            if (num > threshold) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return left;
    }
}
// @lc code=end

