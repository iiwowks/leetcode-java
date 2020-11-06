/*
 * @lc app=leetcode id=1217 lang=java
 *
 * [1217] Minimum Cost to Move Chips to The Same Position
 */

// @lc code=start
class Solution {
    // 1. 奇数序号的chip累加，偶数序号的chip累加
    // 2. 比较 奇数和与偶数和 大小，返回小的和个数
    public int minCostToMoveChips(int[] position) {
        int count1 = 0, count2 = 0;
        
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                count2++;
                continue;
            }
            count1++;
        }
        return Math.min(count1, count2);
    }
}
// @lc code=end

