/*
 * @lc app=leetcode id=754 lang=java
 *
 * [754] Reach a Number
 */

// @lc code=start
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int p = 0, i = 0;
        while (p < target || (p + target) % 2 != 0) {
            i++;
            p += i;
        }
        return i;
    }
}
// @lc code=end

