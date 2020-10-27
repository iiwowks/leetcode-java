/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 * 返回x的平方根，返回类型是整数，结果只保留整数部分，小数部分舍去
 * // 解题思路：牛顿法
 */

// @lc code=start
class Solution {
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}
// @lc code=end
