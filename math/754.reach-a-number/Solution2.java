/*
 * @lc app=leetcode id=754 lang=java
 *
 * [754] Reach a Number
 */

// @lc code=start
class Solution2 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}
// @lc code=end

