/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 * 1. 遍历数组每一个位置， 实时维护一个 最远可以到达的位置
 * 2. 对于位置 x，跳跃最大长度： x + nums[x] > y --> y 位置可以到达
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

