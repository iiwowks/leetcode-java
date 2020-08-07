/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if ( n == 0 || n == 1 || n == 2) {
            return n == 0 ? 0 : 1;
        }
        int a = 0, b = 1, c = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }
        return result;
    }
}
// @lc code=end

