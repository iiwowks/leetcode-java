/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 * 返回x的平方根，返回类型是整数，结果只保留整数部分，小数部分舍去
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // 为了照顾到 1 把右边界设置为 x / 2 + 1
        long right = x / 2 + 1;

        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            long mid = left + (right - left + 1) / 2;
            // long mid = (left + right + 1) >>> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int)left;
    }
}

// @lc code=end
