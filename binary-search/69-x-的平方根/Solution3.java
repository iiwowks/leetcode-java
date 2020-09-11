/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 * 返回x的平方根，返回类型是整数，结果只保留整数部分，小数部分舍去
 */

// @lc code=start

public class Solution {

    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }
}


// @lc code=end
