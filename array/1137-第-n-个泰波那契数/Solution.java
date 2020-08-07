/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
// 暴力解法会超时
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n <= 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}
// @lc code=end

